//*******************************************************************
// Square.java       Author: Gruppe 17
//
// Abstrakt felt som repræsenterer et felt af hvilken som helst type
//*******************************************************************

package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private int positionOnBoard;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    //Metode til hvad der skal ske når en spiller lander på et felt. Andre klasser nedarver denne medtode
    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){ }

    //Getter
    public int getPositionOnBoard(){
        return positionOnBoard;
    }
}