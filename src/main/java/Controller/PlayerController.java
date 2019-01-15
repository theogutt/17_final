package Controller;

import Model.Player;
import Model.Squares.Ownable;
import Model.Squares.Street;

import java.util.ArrayList;

public class PlayerController {
    private int numOfPlayers;
    private GUI gui;
    private GameEngine gameEngine;

    private int roll1;
    private int roll2;

    private Player[] playerModels;
    int oldRollSum;

    public PlayerController(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        playerModels = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            playerModels[i] = new Player(i, numOfPlayers);
        }
    }

    public void wantOutOfJail(int ref, int choice, Die die1, Die die2) {
        if (choice == 1){
            getRef(ref).updateBalance(-1000);
            getRef(ref).setOutOfJailTries(0);
            setInJail(ref, false);
        }
        else if (choice == 2){

            roll1 = die1.roll();
            roll2 = die2.roll();

            if (roll1 == roll2){
                setInJail(ref, false);
                getRef(ref).setOutOfJailTries(0);
            }
            else {
                getRef(ref).setOutOfJailTries(getRef(ref).getOutOfJailTries() + 1);
                if (getRef(ref).getOutOfJailTries() == 3){
                    getRef(ref).updateBalance(-1000);
                    getRef(ref).setOutOfJailTries(0);
                    setInJail(ref, false);
                }
            }
        }
    }

    public void getOutOfJailFree(int playerNum){
        getRef(playerNum).setJailCard(false);
        setInJail(playerNum, false);
    }

    public int playerWithHighestBalance() {
        int max = 0;
        int ref = 0;
        int sumOfProp;

        for (int i = 0; i < numOfPlayers; i++) {
            //Finds the player with the highest balance
            if (max < getRef(i).getBalance()) {
                max = getRef(i).getBalance();
                ref = getRef(i).getPlayerNum();
            }

            //If equal amount, the winner is the one with the greatest amount of property value
            else if (max == getRef(i).getBalance()) {
                if (getRef(ref).getSumOfProperties() < getRef(i).getSumOfProperties()) {
                    ref = i;
                }
            }
        }
        return ref;
    }

    public int calcNewPosition(int rollSum1, int rollSum2, int i) {
        int oldPosition = getRef(i).getCurPosition();
        getRef(i).setOldPosition(oldPosition);

        int newPosition;
        if (rollSum1+rollSum2 + oldPosition == 39) {
            getRef(i).setCurPosition(39);
        } else if ((rollSum1+rollSum2 + oldPosition) > 39) {
            newPosition = ((rollSum1+rollSum2 + oldPosition) % 40);
            getRef(i).setCurPosition((newPosition));

        } else {
            newPosition = (rollSum1+rollSum2 + oldPosition);
            getRef(i).setCurPosition((newPosition));
        }
        getRef(i).setOldRollSum(rollSum1+rollSum2);
        return oldRollSum = rollSum1+rollSum2;
    }

    public void setPosition(int newPosition, int playerNum) {
        int oldPosition = playerModels[playerNum].getCurPosition();
        getRef(playerNum).setOldPosition(oldPosition);
        playerModels[playerNum].setCurPosition(newPosition);
    }

    private Player getRef(int i) {
        return playerModels[i];
    }

    public void broke(int ref) {
        if (playerModels[ref].getBalance() < 0) setBroke(true, ref);
    }

    public boolean getInJail(int ref) {
        return getRef(ref).getInJail();
    }

    public void setInJail(int i, boolean bool) {
        getRef(i).setInJail(bool);
    }

    public void setJailCard(int i, boolean bool) {
        getRef(i).setJailCard(bool);
    }

    public void setSpecialCard(int i, boolean bool) {
        getRef(i).setSpecialCard(bool);
    }

    public boolean getJailCard(int ref) {
        return getRef(ref).getJailCard();
    }

    public boolean getSpecialCard(int ref) {
        return getRef(ref).getSpecialCard();
    }

    public int getPlayerOldPosition(int ref) {
        return getRef(ref).getOldPosition();
    }

    public int getPlayerPlayerNum(int ref) {
        return getRef(ref).getPlayerNum();
    }

    public int getPosition(int i) {
        return playerModels[i].getCurPosition();
    }

    public int getOldPosition(int i) {
        return playerModels[i].getOldPosition();
    }

    public void setSumOfStreets(int ref, int sumOfStreets) {
        playerModels[ref].setSumOfProperties(sumOfStreets);
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

    public void setBroke(boolean bool, int i) {
        playerModels[i].setBroke(bool);
    }

    public void setBalance(int newBalance, int i) {
        playerModels[i].setBalance(newBalance);
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public boolean getModelBroke(int i) {
        return playerModels[i].getBroke();
    }

    public Ownable[] getPlayerOwnables(int ref) {
        return getRef(ref).getAllPlayerOwnables();
    }

    public void addOwnable(Ownable ownable, int i){
        this.playerModels[i].addOwnable(ownable);
    }
    /*public Ownable[] getPlayerOwnables(int playerNum){
        return playerModels[playerNum].getPlayerOwnables();
    }*/

    public void removeOwnable(Ownable ownable, int i){
        this.playerModels[i].removeOwnable(ownable);
    }

   /* public ArrayList getPlayerStreets(int ref) {
        return getRef(ref).getAllPlayersStreets();

    }



/*
    public boolean ownsStreetsAheadOrBehind(int ref, int lfPos) {
        return getRef(ref).ownsStreetAheadOrBehind(lfPos);
    }
*/
    public Player[] getPlayerModels() {
        return playerModels;
    }

    public int getOldRollSum() {
        return oldRollSum;
    }

    public void setOldRollSum(int oldRollSum) {
        this.oldRollSum = oldRollSum;
    }
}
