package Model.Squares;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private int positionOnBoard;
    private int owner;
    private int numberOfBuildings;
    private int groupID;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC, GameBoard gameBoard){
        try {
        }
        catch (NullPointerException ex){}
        //return -1;
    }
    public int getPositionOnBoard(){
        return positionOnBoard;
    }
    public int getOwner(){
        return this.owner;
    }
    public int getNumOfBuildings(){
        return numberOfBuildings;
     }
    public int getGroupID(){return groupID;}
    public void setNumOfBuildings(int numberOfBuildings){
        this.numberOfBuildings = numberOfBuildings;
    }
}