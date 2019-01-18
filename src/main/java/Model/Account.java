package Model;

import Model.Squares.Ownable;
import Utilities.Copy;

public class Account {
    private int balance;
    private int sumOfStreets;
    private Ownable[] playerOwnables = new Ownable[0];

    public Account() {
        this.balance = 30000;
    }

    //tilføjer et Ownable til playerownables
    public void addOwnable(Ownable ownable, int playerNum) {
        ownable.setOwner(playerNum);
        ownable.setOwned(true);
        Ownable[] newArray = Copy.of(this.playerOwnables, this.playerOwnables.length + 1);
        newArray[this.playerOwnables.length] = ownable;
        this.playerOwnables = newArray;
    }

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

    public void updateBalance(int accountUpdate) {
        balance += accountUpdate;
    }

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