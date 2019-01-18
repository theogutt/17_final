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
    private HashMap squarePrice;

    public PlayerController(int numOfPlayers) throws IOException {
        this.numOfPlayers = numOfPlayers;
        playerModels = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            playerModels[i] = new Player(i);
        }
        squarePrice = TextReader.textReader(".\\src\\Resources\\SquarePrice");
    }

    public void wantOutOfJail(int ref, int choice, Die die1, Die die2) {
        if (choice == 1){
            playerModels[ref].updateBalance(-1000);
            playerModels[ref].setOutOfJailTries(0);
            setInJail(ref, false);
        }
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

    public void getOutOfJailFree(int playerNum){
        playerModels[playerNum].setJailCard(false);
        setInJail(playerNum, false);
    }

    public int playerWithHighestBalance(int loser) {
        int max = 0;
        int ref = 0;
        //int sumOfProp;

        for (int i = 0; i < numOfPlayers; i++) {
            //Finds the player with the highest balance and property value
            if(i != loser) {
                if (max < getPlayerFortune(i)) {
                    max = getPlayerFortune(i);
                    ref = i;
                }

                //If equal amount, the winner is the one with the greatest amount of property value
                else if (max == getPlayerFortune(i)) {
                    if (playerModels[ref].getSumOfProperties() < playerModels[i].getSumOfProperties()) {
                        ref = i;
                    }
                }
            }
        }
        return ref;
    }
    public int getPlayerFortune(int playerNum){
        int fortune = playerModels[playerNum].getBalance();
        Ownable[] ejendomme = playerModels[playerNum].getAllPlayerOwnables();
        for(int n = 0; n < ejendomme.length; n++){
            fortune = fortune + ejendomme[n].getPrice() + (ejendomme[n].getNumOfBuildings() * (Integer)squarePrice.get(n));
        }
        return fortune;
    }

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

    public void setPosition(int newPosition, int playerNum) {
        int oldPosition = playerModels[playerNum].getCurPosition();
        playerModels[playerNum].setOldPosition(oldPosition);
        playerModels[playerNum].setCurPosition(newPosition);
    }

    public void broke(int ref) {
        if (playerModels[ref].getBalance() < 0) playerModels[ref].setBroke(true);
    }

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

    public int getPlayerNumFromName(String name) {
        int ref = -1;

        for(int n=0 ; n < playerModels.length ; n++) {
            if (name.equals(playerModels[n].getName()))
                ref = n;
        }

        return ref;
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

    public void updatePlayerBalance(int ref, int accountUpdate) {
        playerModels[ref].updateBalance(accountUpdate);
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

    public void addOwnable(Ownable ownable, int i){
        this.playerModels[i].addOwnable(ownable);
    }

    public void removeOwnable(Ownable ownable, int i){
        this.playerModels[i].removeOwnable(ownable);
    }
}