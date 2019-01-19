package Utilities;

import Controller.GameBoard;
import Controller.GameEngine;
import Controller.PlayerController;
import Controller.RentController;
import Model.Squares.Chance;
import View.GUI_Handler;
import java.util.Scanner;


public class Cheatkodes {


    public void cheats(PlayerController playerC, int playerNum, GameEngine gameEngine, GUI_Handler guiHandler, RentController rentC, GameBoard gameBoard){

        Chance chance = new Chance(playerNum);

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();


        //Giver spilleren et get out of jail free card
        if (input == 1){
            playerC.setJailCard(playerNum, true);
        }

        //Sætter spilleren i fængsel
        else if(input == 2){
            playerC.setInJail(playerNum, true);
            playerC.setPosition(10, playerNum);
        }

        //Tilføj penge til spillerens konto
        else if(input == 3){
            int i = scan.nextInt();
            playerC.updatePlayerBalance(playerNum, i);
        }

        else if(input == 4){

        }

        //
        else if(input == 5){

        }

        //Sætter antal par slag spilleren har slået
        else if(input == 6){
            int i = scan.nextInt();
            if (i < 4){
                gameEngine.setPairs(i);
            }
        }

        //Sætter spillerens position og kører landOn metoden for det felt
        else if(input == 7){
            int i = scan.nextInt();
            if (i < 40){
                playerC.setPosition(i, playerNum);
                guiHandler.removeAllCarsCurPos();
                guiHandler.setAllCarsCurPos(playerC);
                GameBoard.squares[i].landOn(playerC,playerNum,guiHandler,rentC);
            }
        }

        //Trækker et chancekort og udfører dets effekt
        else if (input == 8){
            int[] chanceCards = new int[27];
            int i = scan.nextInt();
            if (i < 27){
                chance.setChanceCards(i);
                GameBoard.squares[2].landOn(playerC,playerNum,guiHandler,rentC);
            }
        }
    }
}
