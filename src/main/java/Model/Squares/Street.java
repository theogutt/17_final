package Model.Squares;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import Model.Player;
import View.GUI_Handler;
import gui_fields.GUI_Street;

import java.awt.*;
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
    private GameBoard gameBoard;

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
        this.owner = owner;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){
            //spørger om spiller vil købe grunden
        if(isOwned()==false) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                int price = getPrice(positionOnBoard);
                playerC.updatePlayerBalance(ref, price * -1);
                setOwner(ref);
                setOwned(true);
                int position = playerC.getPosition(ref);
                guiHandler.changeStreetColor(playerC, ref);
            } else {}
        }
        else{
            rentC.payRent(playerC, ref);
        }
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

    public void setOwner(int ref) {
        this.owner = ref;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}