package Model;
import java.util.ArrayList;

//import Model.Square.Street;
//import Model.Square.Square;


public class Account{
    private int balance;
    private int sumOfStreets;
/*
    private ArrayList <Square> playersStreets = new ArrayList <Square>();
*/

    public Account(){
        startAccount();
    }

   /* public void addStreet(Street street){
        playersStreets.add(street);
        sumOfStreets += street.getPrice();
    }*/

    public void startAccount(){
        balance = 30000;
    }

   /* public boolean ownsStreetAheadOrBehind(int lfStreetPosition){
        boolean x = false;
        for (int i = 0; i < playersStreets.size(); i++) {
            if (playersStreets.get(i).getPositionOnBoard() == lfStreetPosition){
                x = true;
                break;
            }
        }
        return x;
    }*/
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

  /*  public ArrayList<Square> getPlayersStreets() {
        return playersStreets;
    }*/
}
