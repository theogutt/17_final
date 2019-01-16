package Controller;

import Model.Squares.Ownable;
import Model.Squares.Street;
import View.GUI_Handler;

public class Building {

    public void build(PlayerController playerC, int playerNum, GUI_Handler gui_handler, GameBoard gameBoard){
        String bygningDerSkalÆndres = "";
        Ownable[] ejendomme = playerC.getPlayerOwnables(playerNum);
        String valg = gui_handler.chooseStreetToBuildOn();
        boolean forsæt = true;
        while(forsæt) {
            if (valg == "Lyseblå") {
                if (ownAllID(ejendomme, 1, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[2];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 1) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Pink") {
                if (ownAllID(ejendomme, 2, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[3];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 2) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Gørn") {
                if (ownAllID(ejendomme, 3, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[3];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 3) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Grå") {
                if (ownAllID(ejendomme, 4, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[3];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 4) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Rød") {
                if (ownAllID(ejendomme, 5, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[3];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 5) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Hvid") {
                if (ownAllID(ejendomme, 6, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[3];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 6) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Gul") {
                if (ownAllID(ejendomme, 7, gameBoard)) {
                    forsæt = false;
                    int k = 0;
                    String[] streets = new String[3];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 7) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Lilla") {
                if (ownAllID(ejendomme, 8, gameBoard)) {
                    int k = 0;
                    String[] streets = new String[2];
                    for (int i = 0; i < ejendomme.length; i++) {
                        if (ejendomme[i] instanceof Street) {
                            if (ejendomme[i].getGroupID() == 8) {
                                streets[k] = ejendomme[i].getName();
                                k++;
                            }
                        }
                    }
                    forsæt = false;
                    bygningDerSkalÆndres = gui_handler.chooseSepecificStreet(streets);
                }else{forsæt = false;}
            } else if (valg == "Tilbage") {
                forsæt = false;
            }

        }
        for(int i=0; i<ejendomme.length; i++){
            if(bygningDerSkalÆndres.equalsIgnoreCase(ejendomme[i].getName())){
             buildBuilding((Street) ejendomme[i], gui_handler, gameBoard);
                break;
            }
        }
    }
    private void buildBuilding(Street street, GUI_Handler gui_handler, GameBoard gameBoard){
        int valg = gui_handler.chooseNumBuildnings(street.getPositionOnBoard());
        gameBoard.changeBuildning(street, valg);
    }
    public boolean ownAllID(Ownable[] property, int ID, GameBoard gameBoard){
        boolean ownAll = false;
        int numOfIDs = 0;
        for (int i = 0; i < property.length; i++) {
            if (property[i].getGroupID()==ID){
                numOfIDs++;
            }
        }
        if (numOfIDs==gameBoard.numberOfGroupIDs(ID)){
            ownAll = true;
        }
        return ownAll;
    }
}
