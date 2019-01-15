package Model;

import Model.Squares.Ownable;
import Utilities.Copy;

import java.util.ArrayList;
import java.util.Arrays;



public class Account{
    private int balance;
    private int sumOfStreets;
    private Ownable[] playerOwnables = new Ownable[0];

    // private ArrayList <Square> playersStreets = new ArrayList <Square>();

    public Account(){
        startAccount();
    }

    public void startAccount(){
        balance = 30000;
    }

    //tilføjer et Ownable til playerownables
    public void addOwnable(Ownable ownable){
        Ownable [] newArray = Copy.of(this.playerOwnables,this.playerOwnables.length+1);
        newArray[this.playerOwnables.length] = ownable;
        this.playerOwnables = newArray;
    }
    public void removeOwnable(Ownable ownable){
        int x = 0;

        //Tjekker hvor grunden, der skal fernes er
        for(int i= 0;i < this.playerOwnables.length; i++){
            if (this.playerOwnables[i] == ownable){
                x=i;
            }
            break;
        }
        // Sætter alt på den nye plads i Arrayet
        for(int i = x; x < this.playerOwnables.length; i++){
            this.playerOwnables[x] = this.playerOwnables[x+1];
        }
        Copy.of(this.playerOwnables,this.playerOwnables.length-1);
    }

    public static Model.Squares.Ownable[] copyOf(Model.Squares.Ownable[] original, int newLength){
        Ownable [] newArray = copyOf(original,newLength);
        return newArray;
    }
    public void updateBalance(int accountUpdate) {
        balance += accountUpdate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
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
