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
        String bygningDerSkalÆndres = "";
        Ownable[] ejendomme = playerC.getPlayerOwnables(playerNum);
        String valg = guiHandler.chooseStreetToBuildOn();
        if(valg=="Lyseblå"){
            if(gameBoard.ownAllID(playerC,1)){
                int k=0;
                String[] streets = new String[2];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==1){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres=guiHandler.chooseSepecificStreet(streets);
            }
            else{
                guiHandler.menu(playerC,playerNum);
            }
        }else if(valg=="Pink"){
            if(gameBoard.ownAllID(playerC,6)){
                int k=0;
                String[] streets = new String[3];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==2){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres = guiHandler.chooseSepecificStreet(streets);
            }else{
                guiHandler.menu(playerC,playerNum);
            }
        }else if(valg=="Gørn"){
            if(gameBoard.ownAllID(playerC,13)){
                int k=0;
                String[] streets = new String[3];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==3){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres=guiHandler.chooseSepecificStreet(streets);
            }else{
                guiHandler.menu(playerC,playerNum);
            }

        }else if(valg=="Grå"){
            if(gameBoard.ownAllID(playerC,18)){
                int k=0;
                String[] streets = new String[3];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==4){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres=guiHandler.chooseSepecificStreet(streets);
            }else{
                guiHandler.menu(playerC,playerNum);
            }
        }else if(valg=="Rød"){
            if(gameBoard.ownAllID(playerC,23)){
                int k=0;
                String[] streets = new String[3];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==5){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres=guiHandler.chooseSepecificStreet(streets);
            }else{
                guiHandler.menu(playerC,playerNum);
            }
        }else if(valg=="Hvid"){
            if(gameBoard.ownAllID(playerC,29)){
                int k=0;
                String[] streets = new String[3];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==6){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres=guiHandler.chooseSepecificStreet(streets);
        }else{
                guiHandler.menu(playerC,playerNum);
        }
        }else if(valg=="Gul"){
            if(gameBoard.ownAllID(playerC,34)){
                int k=0;
                String[] streets = new String[3];
                for (int i=0; i<ejendomme.length; i++){
                    if(ejendomme[i] instanceof Street){
                        if(ejendomme[i].getGroupID()==7){
                            streets[k] = ejendomme[i].getName();
                            k++;
                        }
                    }
                }
                bygningDerSkalÆndres=guiHandler.chooseSepecificStreet(streets);
            }else{
                guiHandler.menu(playerC,playerNum);
            }
        }else if(valg=="Lilla"){
            if(gameBoard.ownAllID(playerC,39)){

            }else{
                guiHandler.menu(playerC,playerNum);
            }
        }else if(valg=="Tilbage"){
            guiHandler.menu(playerC,playerNum);
        }
        for(int i=0; i<ejendomme.length; i++){
            if(bygningDerSkalÆndres.equalsIgnoreCase(ejendomme[i].getName())){
             buildBuilding((Street) ejendomme[i]);
                break;
            }
        }
    }
    private void buildBuilding(Street street){
        int valg = guiHandler.chooseNumBuildnings();
        gameBoard.changeBuildning(street, valg);
    }
}
