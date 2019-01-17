package Model.Squares;


import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class Tax extends Square {

    public Tax(int positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard() {
        return super.getPositionOnBoard();
    }

    //@Override
    public void landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC) {

        if (playerC.getPosition(playerNum) == 4) {
            int choice = guiHandler.procentOrFixed(playerC, playerNum);
            if(choice == 1){
                int t = (int) (-1 * (playerC.getBalance(playerNum) * 0.2));
                playerC.updatePlayerBalance(playerNum, t);
            }
            else if (choice == 2){
                playerC.updatePlayerBalance(playerNum, -4000);
            }
        } else {
            playerC.updatePlayerBalance(playerNum, -2000);
        }
        //return -1;
    }
}
