package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class GoToPrison extends Square{
    public GoToPrison(int positionOnBoard) {
        super(positionOnBoard);
    }

    //Sætter spillerens position til at være på "I fængsel" feltet og sætter spillerens tilstand til at være "I fængsel"
    public void landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC) {
        playerC.setPosition(10,playerNum);
        playerC.setInJail(playerNum, true);
    }
}