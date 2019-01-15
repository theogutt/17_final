package Model;

//import Model.Square.Street;
import Model.Squares.Ownable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private String name = "";
    private boolean broke = false;
    private int oldPosition;
    private int curPosition = 0;
    private int playerNum;
    private Account account;
    private boolean inJail = false;
    private int outOfJailTries;
    private boolean jailCard = false;
    private boolean specialCard = false;
    private int oldRollSum;
    private int numOfPlayers;

    public Player(int playerNum, int numOfPlayers){
        this.playerNum = playerNum;
        this.account = new Account();
    }
    public int getSumOfProperties(){
        return account.getSumOfStreets();
    }
    public void setSumOfProperties(int sumOfProperties){
        account.setSumOfStreets(sumOfProperties);
    }
    /*public void addStreet(Street street){
        account.addStreet(street);
    }
*/
    public void setBalance(int newBalance){ account.setBalance(newBalance);}

    public int getBalance() {
        return account.getBalance();
    }

    public void updateBalance(int amount) {
        this.account.updateBalance(amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCurPosition() {
        return curPosition;
    }

    public void setCurPosition(int curPosition) {
        this.curPosition = curPosition;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public boolean getBroke(){
        return broke;
    }

    public void setBroke(boolean broke) {
        this.broke = broke;
    }

    public int getOldPosition() {
        return oldPosition;
    }
    public void setOldPosition(int oldPosition) {
        this.oldPosition = oldPosition;
    }

    public boolean getJailCard(){
        return jailCard;
    }

    public void setJailCard(Boolean bool){
        jailCard = bool;
    }

    public void setOutOfJailTries(int tries){
        outOfJailTries = tries;
    }

    public int getOutOfJailTries(){
        return outOfJailTries;
    }

    public boolean getInJail(){
        return inJail;
    }

    public void setInJail(Boolean bool){
        inJail = bool;
    }

    public boolean getSpecialCard() {return specialCard;}

    public void setSpecialCard(Boolean bool) {specialCard = bool; }


    public Ownable[] getAllPlayerOwnables(){
       return this.account.getPlayerOwnables();
    }

    public void addOwnable(Ownable ownable) {
        this.account.addOwnable(ownable);
    }

    public void removeOwnable(Ownable ownable){
        this.account.removeOwnable(ownable);
    }

    public void setOldRollSum(int oldRollSum) {
        this.oldRollSum = oldRollSum;
    }

    public int getOldRollSum() {
        return oldRollSum;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    /*  public ArrayList getAllPlayersStreets(){
       return this.account.getPlayersStreets();
    }

    public boolean ownsStreetAheadOrBehind(int lfStreetPos){
        return account.ownsStreetAheadOrBehind(lfStreetPos);
    }*/
}
