//*******************************************************************
// Account.java       Author: Gruppe 17
//
// Repræsenterer en spillers konto af penge og ejendomme
//*******************************************************************

package Model;

import Model.Squares.Ownable;
import Utilities.Copy;

public class Account {
    private int balance;
    private int sumOfStreets;
    private Ownable[] playerOwnables = new Ownable[0];

    // Sætter en spillers startbalance til 30.000
    public Account() {
        this.balance = 30000;
    }

    //tilføjer et Ownable til playerOwnables arrayet og sætter Ownable'ens Owner til denne spiller og Owned til true
    public void addOwnable(Ownable ownable, int playerNum) {
        ownable.setOwner(playerNum);
        ownable.setOwned(true);
        Ownable[] newArray = Copy.of(this.playerOwnables, this.playerOwnables.length + 1);
        newArray[this.playerOwnables.length] = ownable;
        this.playerOwnables = newArray;
    }

    // Fjerner en ownable fra playerOwnables arrayet og sætter Ownable'ens owner til -1 (ingen) og owned til false
    public void removeOwnable(Ownable ownable) {
        int x = 0;
        ownable.setOwner(-1);
        ownable.setOwned(false);

        //Tjekker hvor grunden, der skal fjernes er
        for (int i = 0; i < this.playerOwnables.length; i++) {
            if (this.playerOwnables[i] == ownable) {
                x = i;
                break;
            }

        }
        // Sætter alt på den nye plads i Arrayet
        for(int i = x; i < this.playerOwnables.length-1; i++){
            this.playerOwnables[i] = this.playerOwnables[i+1];
        }
        this.playerOwnables = Copy.of(this.playerOwnables, this.playerOwnables.length - 1);
    }

    // Tilføjer et antal penge til spillerens pengebeholdning
    public void updateBalance(int accountUpdate) {
        balance += accountUpdate;
    }

    // Getters og setters
    public int getBalance() {
        return balance;
    }

    public int getSumOfStreets() {
        return sumOfStreets;
    }

    public void setSumOfStreets(int sumOfStreets) {
        this.sumOfStreets = sumOfStreets;
    }

    public Ownable[] getPlayerOwnables() {
        return playerOwnables;
    }
}