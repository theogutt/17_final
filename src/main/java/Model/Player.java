package Model;

//import Model.Square.Street;
import java.util.ArrayList;

public class Player {

    private String name = "";
    private boolean broke = false;
    private int oldPosition;
    private int curPosition = 0;
    private int objectNumber;
    private Account account;
    private boolean inJail = false;
    private boolean jailCard = false;
    private boolean specialCard = false;

    public Player(int objectNumber, int numOfPlayers){
        this.objectNumber = objectNumber;
        this.account = new Account(numOfPlayers);
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

    public int getObjectNumber() {
        return objectNumber;
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

    public boolean getInJail(){
        return inJail;
    }

    public void setInJail(Boolean bool){
        inJail = bool;
    }

    public boolean getSpecialCard() {return specialCard;}

    public void setSpecialCard(Boolean bool) {specialCard = bool; }

  /*  public ArrayList getAllPlayersStreets(){
       return this.account.getPlayersStreets();
    }

    public boolean ownsStreetAheadOrBehind(int lfStreetPos){
        return account.ownsStreetAheadOrBehind(lfStreetPos);
    }*/
}
