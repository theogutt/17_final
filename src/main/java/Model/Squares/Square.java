package Model.Squares;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private int positionOnBoard;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public int landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){
        try {
        }
        catch (NullPointerException ex){}
        return -1;
    }

    public int getPositionOnBoard(){
        return positionOnBoard;
    }
    public int getGroupID(int ref) {
        return this.groupID;
    }

}