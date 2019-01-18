package Controller;

import Model.Squares.Ownable;
import Model.Squares.Street;
import Utilities.TextReader;
import View.GUI_Handler;

import java.io.IOException;
import java.util.HashMap;

public class Building {

    private HashMap buildningPrice;

    public Building() throws IOException{
        buildningPrice = TextReader.textReader(".\\src\\Resources\\BuildingPrice");
    }

    public void build(PlayerController playerC, int playerNum, GUI_Handler gui_handler){
        String bygningDerSkalÆndres = "";
        Ownable[] ejendomme = playerC.getPlayerOwnables(playerNum);
        String valg = gui_handler.chooseStreetToBuildOn();
        boolean forsæt = true;
        while(forsæt) {
            if (valg.equals("Lyseblå")) {
                if (ownAllID(ejendomme, 1)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Pink")) {
                if (ownAllID(ejendomme, 2)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Grøn")) {
                if (ownAllID(ejendomme, 3)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Grå")) {
                if (ownAllID(ejendomme, 4)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Rød")) {
                if (ownAllID(ejendomme, 5)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Hvid")) {
                if (ownAllID(ejendomme, 6)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Gul")) {
                if (ownAllID(ejendomme, 7)) {
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
                }else{gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Lilla")) {
                if (ownAllID(ejendomme, 8)) {
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
                }else{ gui_handler.notAllID(); forsæt = false;}
            } else if (valg.equals("Tilbage")) {
                forsæt = false;
            }

        }
        for(int i=0; i<ejendomme.length; i++){
            if (ejendomme[i] instanceof Street) {
                if (bygningDerSkalÆndres.equalsIgnoreCase(ejendomme[i].getName())) {
                    buildBuilding(ejendomme[i], gui_handler, playerC, playerNum);
                    break;
                }
            }
        }
    }
    private void buildBuilding(Ownable ownable, GUI_Handler gui_handler, PlayerController playerC, int playerNum){
        int numBuildBefore = ownable.getNumOfBuildings();

        int price = (Integer) buildningPrice.get(ownable.getPositionOnBoard());
        int valg = gui_handler.chooseNumBuildnings(ownable.getPositionOnBoard(), price);

        if (valg != -1) {
            ownable.setNumberOfBuildings(valg);

            if (numBuildBefore > ownable.getNumOfBuildings()) {
                int price2 = price * (numBuildBefore - valg);
                playerC.updatePlayerBalance(playerNum, price2 / 2);
            } else {
                int price2 = -price * (valg - numBuildBefore);
                playerC.updatePlayerBalance(playerNum, price2);
            }
        }
    }
    private boolean ownAllID(Ownable[] property, int ID){
        int numOfIDs = 0;
        for (int i = 0; i < property.length; i++) {
            if (property[i] instanceof Street) {
                if (property[i].getGroupID() == ID) {
                    numOfIDs++;
                }
            }
        }
        int numInIDGroup = 3;
        if( ID==1 || ID==8){ numInIDGroup = 2; }

        return (numOfIDs==numInIDGroup);
    }
}
