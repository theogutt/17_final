package Controller;

import Model.Squares.Street;
import View.GUI_Handler;
import Controller.GameBoard;
import Controller.PlayerController;

public class Building {
    private GUI_Handler guiHandler;
    private GameBoard gameBoard;


    public void build(PlayerController playerC, int playerNum){
        String valg = guiHandler.chooseStreetToBuildOn();
        if(valg=="Lyseblå"){
            if(gameBoard.ownAllID(playerC,1) {


            }else{
                guiHandler.menu;
            }
        }else if(valg=="Pink"){
            if(gameBoard.ownAllID(playerC,6)){

            }else{
                guiHandler.menu;
            }
        }else if(valg=="Gørn"){
            if(gameBoard.ownAllID(playerC,13)){

            }else{
                guiHandler.menu;
            }

        }else if(valg=="Grå"){
            if(gameBoard.ownAllID(playerC,18)){

            }else{
                guiHandler.menu;
            }
        }else if(valg=="Rød"){
            if(gameBoard.ownAllID(playerC,23)){

            }else{
                guiHandler.menu;
            }
        }else if(valg=="Hvid"){
            if(gameBoard.ownAllID(playerC,29)){

        }else{
            guiHandler.menu;
        }
        }else if(valg=="Gul"){
            if(gameBoard.ownAllID(playerC,34)){

            }else{
                guiHandler.menu;
            }
        }else if(valg=="Lilla"){
            if(gameBoard.ownAllID(playerC,39)){

            }else{
                guiHandler.menu;
            }
        }else if(valg=="Tilbage"){
            guiHandler.menu(playerC,playerNum);
        }
    }
    private void buildBuilding(Street street){
        int valg =
        gameBoard.changeBuildning();
    }


}
