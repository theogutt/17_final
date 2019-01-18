package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class Tax extends Square {

    public Tax(int positionOnBoard) {
        super(positionOnBoard);
    }

    //@Override
    public void landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC) {
        int tax = 0;
        if (playerC.getPosition(playerNum) == 4) {
            int choice = guiHandler.procentOrFixed();
            if(choice == 1){
                tax = (int) (-1 * (playerC.getPlayerFortune(playerNum) * 0.1));
                playerC.updatePlayerBalance(playerNum, tax);
                tax = -tax;
            }
            else if (choice == 2){
                playerC.updatePlayerBalance(playerNum, -4000);
                tax = 4000;
            }
        } else {
            playerC.updatePlayerBalance(playerNum, -2000);
            tax = 2000;
        }
        guiHandler.tax(playerC, playerNum, tax);
        //return -1;
    }
}
