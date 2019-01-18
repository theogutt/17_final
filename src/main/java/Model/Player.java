package Model;

import Model.Squares.Ownable;

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

    // Giver spilleren et ID og laver en account til dem
    public Player(int playerNum){
        this.playerNum = playerNum;
        this.account = new Account();
    }

    // Tilføjer et antal penge til spillerens pengebeholdning
    public void updateBalance(int amount) {
        this.account.updateBalance(amount);
    }

    // Se account
    public void addOwnable(Ownable ownable) {
        this.account.addOwnable(ownable, this.playerNum);
    }

    // Se account
    public void removeOwnable(Ownable ownable){
        this.account.removeOwnable(ownable);
    }

    // Getters og setters
    public int getSumOfProperties(){
        return account.getSumOfStreets();
    }

    public int getBalance() {
        return account.getBalance();
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

    public Ownable[] getAllPlayerOwnables(){
       return this.account.getPlayerOwnables();
    }
}
