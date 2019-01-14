package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private Street street;
    private int positionOnBoard;
    private int owner;
    private int numOfBuildings;
    private int groupID;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){
        try {
        }
        catch (NullPointerException ex){}
    }

    public int getOwner(int ref) {
        return this.owner;
    }

    public int getNumOfBuildings() {
        int numOfBuildings = street.getNumOfBuildings();
        return numOfBuildings;
    }
    public int getGroupID(int ref) {
        return this.groupID;
    }

}