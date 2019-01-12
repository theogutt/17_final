package Model.Squares;

import Controller.PlayerController;
import Model.Player;
import View.GUI_Handler;

import java.io.IOException;

public class Street extends Ownable{
    private int owner;
    private final int price;
    private boolean owned;
    private int positionOnBoard;
    private final String name;
    private int numOfBuildings;
    private int groupID;
    private GUI_Handler guiHandler;
    private PlayerController playerC;

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
        this.owner = owner;
        guiHandler = new GUI_Handler();
    }

    @Override
    public void landOn(int ref){
        if(isOwned()==false){
            //spørger om spiller vil købe grunden
            guiHandler.
            if(answer==yes){
                int square = playerC.getPosition(ref);
                int price = getPrice(square);
                playerC.updatePlayerBalance(ref, price*-1);

            }
        }
        else{

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
    @Override
    public int getOwner() {
        return owner;
    }

    public boolean isOwned() {
        return owned;
    }
}