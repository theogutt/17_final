package Controller;

import Model.Player;
//import Model.Square.Street;
import java.util.ArrayList;

public class PlayerController {
    private int numOfPlayers;

    private Player[] playerModels;

    public PlayerController(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
        playerModels = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            playerModels[i] = new Player(i, numOfPlayers);
        }
    }

    public boolean wantOutOfJail(int ref) {
        boolean gotOutOfJail = false;

        if (getRef(ref).getJailCard()) {
            getRef(ref).setJailCard(false);
            gotOutOfJail = true;
            setInJail(ref, false);

        } else if (getRef(ref).getBalance() > 0) {
            getRef(ref).updateBalance(-1);
            gotOutOfJail = true;
            setInJail(ref, false);
        }
        return gotOutOfJail;
    }

    public int playerWithHighestBalance() {
        int max = 0;
        int ref = 0;
        int sumOfProp;

        for (int i = 0; i < numOfPlayers; i++) {
            //Finds the player with the highest balance
            if (max < getRef(i).getBalance()) {
                max = getRef(i).getBalance();
                ref = getRef(i).getObjectNumber();
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

    public void calcNewPosition(int rollSum, int i) {
        int oldPosition = getRef(i).getCurPosition();
        getRef(i).setOldPosition(oldPosition);

        int newPosition;
        if (rollSum + oldPosition == 23) {
            getRef(i).setCurPosition(23);
        } else if ((rollSum + oldPosition) > 23) {
            newPosition = ((rollSum + oldPosition) % 24);
            getRef(i).setCurPosition((newPosition));

        } else {
            newPosition = (rollSum + oldPosition);
            getRef(i).setCurPosition((newPosition));
        }
    }

    public void setPosition(int newPosition, int i) {
        int oldPosition = playerModels[i].getCurPosition();
        getRef(i).setOldPosition(oldPosition);
        playerModels[i].setCurPosition(newPosition);
    }

/*
    public void addPlayerStreet(int i, Street street) {
        getRef(i).addStreet(street);
    }
*/

    private Player getRef(int i) {
        return playerModels[i];
    }

    public void broke(int ref) {
        if (playerModels[ref].getBalance() < 0) setBroke(true, ref);
    }

    public boolean inJail(int ref) {
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

    public int getPlayerObjectNumber(int ref) {
        return getRef(ref).getObjectNumber();
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

   /* public ArrayList getPlayerStreets(int ref) {
        return getRef(ref).getAllPlayersStreets();
    }

    public boolean ownsStreetsAheadOrBehind(int ref, int lfPos) {
        return getRef(ref).ownsStreetAheadOrBehind(lfPos);
    }
*/
    public Player[] getPlayerModels() {
        return playerModels;
    }


}