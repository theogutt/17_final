package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private Street street;
    private int positionOnBoard;
    private int owner;
    private int numOfBuildings;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){
        try {
            street.landOn(playerC, ref, guiHandler, rentC);
        }
        catch (NullPointerException ex){}
    }

    public int getOwner() {
        return owner;
    }

    public int getNumOfBuildings() {
        int numOfBuildings = street.getNumOfBuildings();
        return numOfBuildings;
    }
}