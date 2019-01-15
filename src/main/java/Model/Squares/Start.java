package Model.Squares;


import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class Start extends Square{

    //Constructor
    public Start(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC){

        playerC.updatePlayerBalance(playerNum, 4000);
        return -1;
    }
}
