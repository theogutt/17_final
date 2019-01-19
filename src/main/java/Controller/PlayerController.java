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
    public void wantOutOfJail(int playerNum, int choice, Die die1, Die die2) {
        // Spiller betaler sig ud af fængslet
        if (choice == 1){
            playerModels[playerNum].updateBalance(-1000);
            playerModels[playerNum].setOutOfJailTries(0);
            setInJail(playerNum, false);
        }
        // Spiller slår med terninger for at komme ud
        else if (choice == 2){

            int roll1 = die1.roll();
            int roll2 = die2.roll();

            if (roll1 == roll2){
                setInJail(playerNum, false);
                playerModels[playerNum].setOutOfJailTries(0);
            }
            else {
                playerModels[playerNum].setOutOfJailTries(playerModels[playerNum].getOutOfJailTries() + 1);
                if (playerModels[playerNum].getOutOfJailTries() == 3){
                    playerModels[playerNum].updateBalance(-1000);
                    playerModels[playerNum].setOutOfJailTries(0);
                    setInJail(playerNum, false);
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
        int playerNum = 0;
        //int sumOfProp;

        for (int i = 0; i < numOfPlayers; i++) {
            //Finder den spiller, som har den størtse pengebeholdning
            if(i != loser) {
                if (max < getPlayerFortune(i)) {
                    max = getPlayerFortune(i);
                    playerNum = i;
                }

                //Hvis to spiller har lige store pengebeholdninger, er vinderen den spiller med den højeste ejendomsværdi
                else if (max == getPlayerFortune(i)) {
                    if (playerModels[playerNum].getSumOfProperties() < playerModels[i].getSumOfProperties()) {
                        playerNum = i;
                    }
                }
            }
        }
        return playerNum;
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
    public void calcNewPosition(int rollSum1, int rollSum2, int playerNum) {
        int oldPosition = playerModels[playerNum].getCurPosition();
        playerModels[playerNum].setOldPosition(oldPosition);

        int newPosition;
        if (rollSum1+rollSum2 + oldPosition == 39) {
            playerModels[playerNum].setCurPosition(39);
        } else if ((rollSum1+rollSum2 + oldPosition) > 39) {
            newPosition = ((rollSum1+rollSum2 + oldPosition) % 40);
            playerModels[playerNum].setCurPosition((newPosition));

        } else {
            newPosition = (rollSum1+rollSum2 + oldPosition);
            playerModels[playerNum].setCurPosition((newPosition));
        }
    }

    //Tjekker om en spiller er gået fallit
    public void broke(int playerNum) {
        if (playerModels[playerNum].getBalance() < 0) playerModels[playerNum].setBroke(true);
    }

    //Ændre en spiller pengebeholdning med et difinret beløb
    public void updatePlayerBalance(int playerNum, int accountUpdate) {
        playerModels[playerNum].updateBalance(accountUpdate);
    }

    //(Se Account.owable)
    public void addOwnable(Ownable ownable, int playerNum){
        this.playerModels[playerNum].addOwnable(ownable);
    }

    //(Se Account.owable)
    public void removeOwnable(Ownable ownable, int playerNum){
        this.playerModels[playerNum].removeOwnable(ownable);
    }

    //Finder en spiller reference nummer ud fra spilleren navn
    public int getPlayerNumFromName(String name) {
        int playerNum = -1;

        for(int n=0 ; n < playerModels.length ; n++) {
            if (name.equals(playerModels[n].getName()))
                playerNum = n;
        }

        return playerNum;
    }

    //Sætter  kun en spillers position (i modsætning til calcNewPosition)
    public void setPosition(int newPosition, int playerNum) {
        int oldPosition = playerModels[playerNum].getCurPosition();
        playerModels[playerNum].setOldPosition(oldPosition);
        playerModels[playerNum].setCurPosition(newPosition);
    }


    //Getters og setters
    public boolean getInJail(int playerNum) {
        return playerModels[playerNum].getInJail();
    }

    public void setInJail(int playerNum, boolean bool) {
        playerModels[playerNum].setInJail(bool);
    }

    public void setJailCard(int playerNum, boolean bool) {
        playerModels[playerNum].setJailCard(bool);
    }

    public boolean getJailCard(int playerNum) {
        return playerModels[playerNum].getJailCard();
    }

    public int getPlayerOldPosition(int playerNum) {
        return playerModels[playerNum].getOldPosition();
    }

    public int getPosition(int playerNum) {
        return playerModels[playerNum].getCurPosition();
    }

    public int getOldPosition(int playerNum) {
        return playerModels[playerNum].getOldPosition();
    }

    public String getName(int playerNum) {
        return playerModels[playerNum].getName();
    }

    public void setName(String name, int playerNum) {
        playerModels[playerNum].setName(name);
    }

    public int getBalance(int playerNum) {
        return playerModels[playerNum].getBalance();
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public boolean getModelBroke(int playerNum) {
        return playerModels[playerNum].getBroke();
    }

    public Ownable[] getPlayerOwnables(int playerNum) {
        return playerModels[playerNum].getAllPlayerOwnables();
    }
}