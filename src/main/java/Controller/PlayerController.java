//*******************************************************************
// PlayerController.java       Author: Gruppe 17
//
// Kontrollerer spillernes data
//*******************************************************************

package Controller;

import Model.Die;
import Model.Player;
import Model.Squares.Ownable;
import Utilities.TextReader;

import java.io.IOException;
import java.util.HashMap;

public class PlayerController {
    private int numOfPlayers;
    private Player[] playerModels;
    private HashMap buildingPrice;

    //Konstruktør som også istantiere alle spillere
    public PlayerController(int numOfPlayers) throws IOException {
        this.numOfPlayers = numOfPlayers;
        playerModels = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            playerModels[i] = new Player(i);
        }
        buildingPrice = TextReader.textReader(".\\src\\Resources\\BuildingPrice");
    }

    //Håndtere en spillers valg om at betale sig ud af fængslet, eller prøve at slå et parslag i tre forsøg, og sidder derefter spilleren ud af fængslet
    public void wantOutOfJail(int ref, int choice, Die die1, Die die2) {
        // Spiller betaler sig ud af fængslet
        if (choice == 1){
            playerModels[ref].updateBalance(-1000);
            playerModels[ref].setOutOfJailTries(0);
            setInJail(ref, false);
        }
        // Spiller slår med terninger for at komme ud
        else if (choice == 2){

            int roll1 = die1.roll();
            int roll2 = die2.roll();

            if (roll1 == roll2){
                setInJail(ref, false);
                playerModels[ref].setOutOfJailTries(0);
            }
            else {
                playerModels[ref].setOutOfJailTries(playerModels[ref].getOutOfJailTries() + 1);
                if (playerModels[ref].getOutOfJailTries() == 3){
                    playerModels[ref].updateBalance(-1000);
                    playerModels[ref].setOutOfJailTries(0);
                    setInJail(ref, false);
                }
            }
        }
    }

    //Bruger en spillers "kom ud af fængsel" kort og sidder spilleren ud af fængslet
    public void getOutOfJailFree(int playerNum){
        playerModels[playerNum].setJailCard(false);
        setInJail(playerNum, false);
    }

    //Finder vinderen af spillet
    public int playerWithHighestBalance(int loser) {
        int max = 0;
        int ref = 0;
        //int sumOfProp;

        for (int i = 0; i < numOfPlayers; i++) {
            //Finder den spiller, som har den størtse pengebeholdning
            if(i != loser) {
                if (max < getPlayerFortune(i)) {
                    max = getPlayerFortune(i);
                    ref = i;
                }

                //Hvis to spiller har lige store pengebeholdninger, er vinderen den spiller med den højeste ejendomsværdi
                else if (max == getPlayerFortune(i)) {
                    if (playerModels[ref].getSumOfProperties() < playerModels[i].getSumOfProperties()) {
                        ref = i;
                    }
                }
            }
        }
        return ref;
    }

    // Udregner samlede formue for en spiller (Penge + værdi af samlede ejendomme + bygninger)
    public int getPlayerFortune(int playerNum){
        int fortune = playerModels[playerNum].getBalance();
        Ownable[] ejendomme = playerModels[playerNum].getAllPlayerOwnables();
        for(int n = 0; n < ejendomme.length; n++){
            fortune += ejendomme[n].getPrice() + (ejendomme[n].getNumOfBuildings() * (Integer)buildingPrice.get(ejendomme[n].getPositionOnBoard()));
        }
        return fortune;
    }
    public int getSumOfBuildings(int playerNum) {
        int buildningPrice = 0;
        Ownable[] ejendomme = playerModels[playerNum].getAllPlayerOwnables();
        for (int n = 0; n < ejendomme.length; n++) {
            buildningPrice += (ejendomme[n].getNumOfBuildings() * (Integer) buildingPrice.get(ejendomme[n].getPositionOnBoard()));
        }
        return buildningPrice;
    }

    public int getSumofOwnables(int playerNum){
        int sumofOwnables = 0;
        Ownable[] ejendomme = playerModels[playerNum].getAllPlayerOwnables();
        for(int n = 0; n < ejendomme.length; n++) {
            sumofOwnables += ejendomme[n].getPrice();
        }
        return sumofOwnables;
    }


    //Beregner en spillers nye position på brættet ud fra tegnnig slag og håndtere hvis en spiller passere start
    public void calcNewPosition(int rollSum1, int rollSum2, int i) {
        int oldPosition = playerModels[i].getCurPosition();
        playerModels[i].setOldPosition(oldPosition);

        int newPosition;
        if (rollSum1+rollSum2 + oldPosition == 39) {
            playerModels[i].setCurPosition(39);
        } else if ((rollSum1+rollSum2 + oldPosition) > 39) {
            newPosition = ((rollSum1+rollSum2 + oldPosition) % 40);
            playerModels[i].setCurPosition((newPosition));

        } else {
            newPosition = (rollSum1+rollSum2 + oldPosition);
            playerModels[i].setCurPosition((newPosition));
        }
    }

    //Tjekker om en spiller er gået fallit
    public void broke(int ref) {
        if (playerModels[ref].getBalance() < 0) playerModels[ref].setBroke(true);
    }

    //Ændre en spiller pengebeholdning med et difinret beløb
    public void updatePlayerBalance(int ref, int accountUpdate) {
        playerModels[ref].updateBalance(accountUpdate);
    }

    //(Se Account.owable)
    public void addOwnable(Ownable ownable, int i){
        this.playerModels[i].addOwnable(ownable);
    }

    //(Se Account.owable)
    public void removeOwnable(Ownable ownable, int i){
        this.playerModels[i].removeOwnable(ownable);
    }

    //Finder en spiller reference nummer ud fra spilleren navn
    public int getPlayerNumFromName(String name) {
        int ref = -1;

        for(int n=0 ; n < playerModels.length ; n++) {
            if (name.equals(playerModels[n].getName()))
                ref = n;
        }

        return ref;
    }

    //Sætter  kun en spillers position (i modsætning til calcNewPosition)
    public void setPosition(int newPosition, int playerNum) {
        int oldPosition = playerModels[playerNum].getCurPosition();
        playerModels[playerNum].setOldPosition(oldPosition);
        playerModels[playerNum].setCurPosition(newPosition);
    }


    //Getters og setters
    public boolean getInJail(int ref) {
        return playerModels[ref].getInJail();
    }

    public void setInJail(int i, boolean bool) {
        playerModels[i].setInJail(bool);
    }

    public void setJailCard(int i, boolean bool) {
        playerModels[i].setJailCard(bool);
    }

    public boolean getJailCard(int ref) {
        return playerModels[ref].getJailCard();
    }

    public int getPlayerOldPosition(int ref) {
        return playerModels[ref].getOldPosition();
    }

    public int getPosition(int i) {
        return playerModels[i].getCurPosition();
    }

    public int getOldPosition(int i) {
        return playerModels[i].getOldPosition();
    }

    public String getName(int i) {
        return playerModels[i].getName();
    }

    public void setName(String name, int i) {
        playerModels[i].setName(name);
    }

    public int getBalance(int i) {
        return playerModels[i].getBalance();
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public boolean getModelBroke(int i) {
        return playerModels[i].getBroke();
    }

    public Ownable[] getPlayerOwnables(int ref) {
        return playerModels[ref].getAllPlayerOwnables();
    }
}