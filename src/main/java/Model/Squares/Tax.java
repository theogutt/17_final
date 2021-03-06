//*******************************************************************
// Tax.java       Author: Gruppe 17
//
// Repræsenterer et skatte felt hvor spilleren skal betale skat
//*******************************************************************

package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class Tax extends Square {

    public Tax(int positionOnBoard) {
        super(positionOnBoard);
    }

    //Når en spiller lander på et af de to skatte felter ser metoden først, hvilket af de to felter spilleren er landet på
    public void landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC) {
        int tax = 0;
        //Hvis det er "Betal 10% eller 4.000 kr., får spilleren muligheden for at vælge, om de vil betale 10% af samlede værdi eller 4.000 kr.
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

            //Hvis det er det andet skatte felt betaler spilleren bare 2.000 kr.
        } else {
            playerC.updatePlayerBalance(playerNum, -2000);
            tax = 2000;
        }
        guiHandler.tax(playerC, playerNum, tax);
        //return -1;
    }
}
