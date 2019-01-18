package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class Start extends Square{


    public Start(int positionOnBoard){
        super(positionOnBoard);
    }

    //Giver spiller 4.000 kr.
    public void landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC){

        playerC.updatePlayerBalance(playerNum, 4000);
    }
}
