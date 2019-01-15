package Model;

import Model.Squares.Ownable;
import Model.Squares.Square;
import Model.Squares.Street;

import java.util.ArrayList;
import java.util.Arrays;



public class Account{
    private int balance;
    private int sumOfStreets;
    private ArrayList <Ownable> playersOwnables = new ArrayList <Ownable>();


    // private ArrayList <Square> playersStreets = new ArrayList <Square>();

    public Account(){
        startAccount();
    }

    public void startAccount(){
        balance = 30000;
    }


    public void updateBalance(int accountUpdate) {
        balance += accountUpdate;
    }

    public void addOwnables(Ownable ownable){
        playersOwnables.add(ownable);
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

    public ArrayList<Ownable> getPlayersOwnables() {
        return playersOwnables;
    }

}
