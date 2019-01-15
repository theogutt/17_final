package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;



public class GoToPrison extends Square{

    private PlayerController playerC;

    public GoToPrison(int positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public int landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC) {
        playerC.setPosition(10,playerNum);
        playerC.setInJail(playerNum, true);
        return -2;
    }
}