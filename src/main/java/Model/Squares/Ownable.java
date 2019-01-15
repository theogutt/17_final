package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Ownable extends Square{
    public Ownable(int positionOnBoard) {
        super(positionOnBoard);
    }

    public abstract int landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC);


    public int getOwner() {
        return getOwner();
    }
}
