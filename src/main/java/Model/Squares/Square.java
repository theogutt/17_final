package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private int positionOnBoard;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){ }

    public int getPositionOnBoard(){
        return positionOnBoard;
    }
}