package Model.Squares;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

import java.io.IOException;


public abstract class Ownable extends Square{
    private int owner;
    private boolean owned;
    private int positionOnBoard;
    private String name;
    private int numOfBuildings;
    private int groupID;
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private RentController rentC;
    private int price;
    private GameBoard gameBoard;
    private Square[] squares = new Square[40];

    public Ownable(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard);
        this.owned = owned;
        this.name = name;
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
        this.owner = owner;
        this.price = price;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC, GameBoard gameBoard) {
        //spørger om spiller vil købe grunden
        if (isOwned() == false) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                int price = getPrice();
                playerC.updatePlayerBalance(ref, price * -1);
                setOwned(true);
                setOwner(ref);
                Square curSquare = this;
                playerC.addOwnable((Ownable) curSquare, ref);
                guiHandler.changeStreetColor(playerC, ref);
            }
            else {}
        } else {
            int rent = rentC.retrieveRent(playerC, ref, gameBoard);
            playerC.updatePlayerBalance(ref, rent*-1);
            playerC.updatePlayerBalance(this.getOwner(), rent);
        }
    }
    public String getName() {
        return name;
    }
    public int getPrice(){return price;}
    public int getGroupID() {
        return groupID;
    }
    public int getNumOfBuildings() {
        return numOfBuildings;
    }
    public void setNumOfBuildings(int numOfBuildings){
        this.numOfBuildings = numOfBuildings;
    }

    public int getPositionOnBoard() {
        return positionOnBoard;
    }
    public int getOwner() {
        return this.owner;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwner(int ref) {
        this.owner = ref;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
