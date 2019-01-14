package Model.Squares;


import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;
import gui_main.GUI;

public class Tax extends Square{

    private GUI gui;

    public Tax(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){

        if (playerC.getPlayerPlayerNum(ref) == 4){
            String chose = gui.getUserSelection("20% eller 4.000 kr.", "1", "2");

            if (chose == "1"){
                int t = -1 * ((playerC.getBalance(ref) * 100) / 20);
                playerC.updatePlayerBalance(ref, t);
            }
            else {
                playerC.updatePlayerBalance(ref, -4000);
            }
        }
        else{
            playerC.updatePlayerBalance(ref, -2000);
        }
        return -1;
    }
}
