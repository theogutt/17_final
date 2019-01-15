package Utilities;

import Controller.GameEngine;
import Controller.PlayerController;
import Controller.RentController;
import Model.Squares.Chance;
import Model.Squares.Square;
import View.GUI_Handler;

import java.util.Scanner;



public class Cheatkodes {

    private Square[] squares = new Square[40];

    public void cheats(PlayerController playerC, int playerNum, GameEngine gameEngine, GUI_Handler guiHandler, RentController rentC, Chance chance){

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
            int i = scan.nextInt();
            playerC.updatePlayerBalance(playerNum, i);
        }
        else if(input == 4){

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
        else if (input == 8){
            int[] chanceCards = new int[27];
            int i = scan.nextInt();
            if (i < 27){
                chanceCards[0] = i;
                chance.setChanceCards(chanceCards);
                squares[2].landOn(playerC,playerNum,guiHandler,rentC);
            }
        }
    }
}
