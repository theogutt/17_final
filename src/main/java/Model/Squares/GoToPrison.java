package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class GoToPrison extends Square{
    public GoToPrison(int positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public int landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC) {
        return super.landOn(playerC, ref, guiHandler, rentC);
    }
}