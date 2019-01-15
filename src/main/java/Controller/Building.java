package Controller;

import Model.Squares.Ownable;
import Model.Squares.Street;
import View.GUI_Handler;
import Controller.GameBoard;
import Controller.PlayerController;

public class Building {
    private GUI_Handler guiHandler;
    private GameBoard gameBoard;

    public void build(PlayerController playerC, int playerNum){

        /*
        Ownable[] ejendomme = playerC.getPlayerOwnables(playerNum);
        for (int i=0; i<ejendomme.length; i++){
            if(ejendomme[i] instanceof Street){
            }
        }
        */

        String valg = guiHandler.chooseStreetToBuildOn();
        if(valg=="Lyseblå"){
            if(gameBoard.ownAllID(playerC,1)){
                Ownable[] ejendomme = playerC.getPlayerOwnables(playerNum);
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        Street[] bo = new Street[2];
                        = Street(ejendomme[i]);
                        if((Street)ejendomme[i].getGroupID()==1){
                        }
                    }
                }

            }
            else{
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
        int valg = guiHandler.chooseNumBuildnings();
        gameBoard.changeBuildning(valg);
    }


}
