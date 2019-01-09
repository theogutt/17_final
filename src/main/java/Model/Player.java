package Model;

public class Player {
    private String name = "";
    private int playerNum;
    private Account account;

    // Husk bil og farve

    private int position = 0;

    public Player(int playerNum){
        this.playerNum = playerNum;
        this.account = new Account();
    }





    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
