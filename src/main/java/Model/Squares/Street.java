package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import Model.Player;
import View.GUI_Handler;

import java.io.IOException;

public class Street extends Ownable{
    private int owner;
    private int price;
    private boolean owned;
    private int positionOnBoard;
    private String name;
    private int numOfBuildings;
    private int groupID;
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private RentController rentC;

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
        this.owner = owner;
    }

    public int landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC){
            //spørger om spiller vil købe grunden
        if(isOwned()==false) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                int price = getPrice(positionOnBoard);
                playerC.updatePlayerBalance(playerNum, price * -1);
                setOwner(playerNum);
                setOwned(true);
            } else {}
        }
        else{
            rentC.payRent(playerC, playerNum);
        }
        return -1;
    }

    public int getPrice(int positionOnBoard) {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getGroupID() {
        return groupID;
    }
    @Override
    public int getNumOfBuildings() {
        return numOfBuildings;
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

    public void setOwner(int playerNum) {
        this.owner = playerNum;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}