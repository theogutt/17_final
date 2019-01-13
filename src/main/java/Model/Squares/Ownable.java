package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Ownable extends Square{
    public Ownable(int positionOnBoard) {
        super(positionOnBoard);
    }

    public abstract void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC);
}
