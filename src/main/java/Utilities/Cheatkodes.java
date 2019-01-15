package Utilities;

import Controller.GameEngine;
import Controller.PlayerController;
import Controller.RentController;
import Model.Squares.Square;
import View.GUI_Handler;

import java.util.Scanner;



public class Cheatkodes {

    private Square[] squares = new Square[40];

    public void cheats(PlayerController playerC, int playerNum, GameEngine gameEngine, GUI_Handler guiHandler, RentController rentC){

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input == 1){
            playerC.setJailCard(playerNum, true);
        }
        else if(input == 2){
            playerC.setInJail(playerNum, true);
            playerC.setPosition(10, playerNum);
        }
        else if(input == 3){
            playerC.updatePlayerBalance(playerNum, -50000);
        }
        else if(input == 4){
            playerC.updatePlayerBalance(playerNum, 50000);
        }
        else if(input == 5){
            gameEngine.setPairs(3);
        }
        else if(input == 6){
            gameEngine.setPairs(1);
        }
        else if(input == 7){
            int i = scan.nextInt();
            if (i < 40){
                playerC.setPosition(i, playerNum);
                squares[i].landOn(playerC,playerNum,guiHandler,rentC);
            }
        }
    }
}
