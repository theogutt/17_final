package View;

import Controller.Building;
import Controller.GameBoard;
import Controller.PlayerController;
import Controller.Trading;
import Model.Player;
import Utilities.Copy;
import Utilities.TextReader;
import Model.Die;
import Model.Squares.Square;
import gui_codebehind.GUI_Center;
import gui_fields.*;
import gui_main.GUI;


import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import static gui_fields.GUI_Car.Type.*;

public class GUI_Handler {
    private GUI gui;
    private MessageHandler message;
    private static GUI_Field[] fields;
    private GUI_Player[] gui_Players;
    private GUI_Car[] gui_cars;
    private HashMap chanceDesc;
    private GUI_Street gui_street;


    public GUI_Handler() throws IOException {
        message = new MessageHandler();
        fields = new GUI_Field[40];
        /*for (int i = 0; i < fields.length; i++) {
            fields[i] = new GUI_Street((String) streetNames.get(i), "", (String) streetDesc.get(i), "", Color.YELLOW, Color.BLACK);
        }*/
        chanceDesc = TextReader.textReader(".\\src\\Resources\\ChanceCards");
        setSpecificFields();
        gui = new GUI(fields);
    }

    public void menu(PlayerController playerC, int playerNum, Building building, Trading trading){
        boolean aktivTur = true;
        while (aktivTur) {
            String valg = gui.getUserButtonPressed("Menu", "Handel", "Bygge", "Pantsæt", "Afslut tur");
            if (valg == "Handel") {
                trade(playerC, playerNum, trading);
            } else if (valg == "Bygge") {
                building.build(playerC, playerNum, this);
            } else if (valg == "Pantsæt") {
                //indsæt pantsæt metode :)
            } else if (valg == "Afslut tur") {
                aktivTur = false;
            }
        }
    }

    public void playerWonGui(PlayerController playerC, int i) {
        gui.showMessage(message.playerWon(playerC, i));
    }

    public void gotBrokeGui(PlayerController playerC, int i) {
        gui.showMessage(message.gotBroke(playerC, i));
    }

    public void startGameGui() {
        gui.showMessage(message.startGame1());
        gui.showMessage(message.startGame2());
        gui.showMessage(message.startGame3());
        gui.showMessage(message.startGame4());
    }

    public void setGameUpGui(PlayerController playerC) {
        int numOfPlayers = playerC.getNumOfPlayers();
        gui_cars = new GUI_Car[numOfPlayers];
        gui_Players = new GUI_Player[numOfPlayers];
        CarColor carColor = new CarColor();

        for (int i = 0; i < playerC.getNumOfPlayers(); i++) {
            enterNamePlayer(playerC, i);
            GUI_Car car = chosePlayerCar(carColor, playerC, i);
            addGuiPlayer(playerC, i, car);
            setSpecificCar(playerC, i);
        }
    }

    public void addGuiPlayer(PlayerController playerC, int ref, GUI_Car car) {
        gui_Players[ref] = new GUI_Player(playerC.getName(ref), playerC.getBalance(ref), car);
        gui.addPlayer(gui_Players[ref]);
    }

    public void setSpecificCar(PlayerController playerC, int ref) {
        fields[(playerC.getPosition(ref))].setCar(getGuiPlayer(ref), true);
    }

    public GUI_Player getGuiPlayer(int i) {
        GUI_Player guiPlayer = gui_Players[i];
        return guiPlayer;
    }

    public void enterNamePlayer(PlayerController playerC, int ref) {
        while (true) {
            String input = gui.getUserString(message.turnMessage(playerC, ref, "26") + " " + (ref + 1));
            if (input.length() > 0) {
                playerC.setName(input, ref);
                break;
            } else {
                gui.showMessage(message.turnMessage(playerC, ref, "27") + " " + (ref + 1));
            }
        }
    }
    public void messageSquareGui(PlayerController playerC, int ref, Square square, boolean passedStart) {
        if (passedStart) {
            gui.showMessage(message.messageSquare(playerC, ref));
        }
        gui.showMessage(message.messageSquare(playerC, ref));
    }

    public void updateGuiPlayerBalance(PlayerController playerC) {
        for (int i = 0; i < gui_Players.length; i++) {
            gui_Players[i].setBalance(playerC.getBalance(i));
        }
    }
    public int buyStreet(){
        String answer = gui.getUserSelection("Vil du købe grunden?","ja", "nej");
        if(answer.equalsIgnoreCase("ja")){return 1;}
        else{return 0;}
    }
    public int payOrRoll(){
        String choice = gui.getUserSelection("Betal 1000 kr. eller slå to ens", "Betal", "Slå");
        if (choice.equalsIgnoreCase("Betal")){ return 1; }
        else{ return 2; }
    }
    public int procentOrFixed(PlayerController playerC, int playerNum){
        String choice = gui.getUserSelection("Betal 20% eller 4.000 kr.", "20%", "4.000 kr.");
        if (choice.equalsIgnoreCase("20%")){ return 1; }
        else { return 2; }
    }

    public String chooseStreetToBuildOn(){
        String valg = gui.getUserSelection("Vælg grundens farve","Lyseblå","Pink","Grøn","Grå","Rød","Hvid","Gul","Lilla","Tilbage");
        return valg;
    }
    public String chooseSepecificStreet(String[] streets){
        String valg = gui.getUserSelection("Vælg grund",streets);
        return valg;
    }

    public int chooseNumBuildnings(){
        String valg = gui.getUserButtonPressed("Antal huse på grund","1","2","3","4","Hotel","Tilbage");
        int i = 0;
        if (valg == "1")        i=1;
        else if (valg == "2")   i=2;
        else if (valg == "3")   i=3;
        else if (valg == "4")   i=4;
        else if (valg == "Hotel")  i=5;
        else                    i=0;

        if (i==0){}
        else if(i==5){gui_street.setHotel(true);}
        else {gui_street.setHouses(i);}
        return i;
    }
    public Color chooseCarColor(CarColor carColorObj, PlayerController playerC, int ref) {
        String[] chooseColorStrings = carColorObj.colorsToChooseFrom().split(" ");
        String carColorS;
        String vælgFarve = "Vælg bilens farve";
        for (int i = 0; i < chooseColorStrings.length; i++) {
            System.out.println(chooseColorStrings[i]);
        }
        if(chooseColorStrings.length == 6) {
            carColorS = gui.getUserSelection(vælgFarve, chooseColorStrings[0], chooseColorStrings[1], chooseColorStrings[2], chooseColorStrings[3], chooseColorStrings[4], chooseColorStrings[5]);
        }
          else if (chooseColorStrings.length == 5) {
            carColorS = gui.getUserSelection(vælgFarve, chooseColorStrings[0], chooseColorStrings[1], chooseColorStrings[2], chooseColorStrings[3], chooseColorStrings[4]);
        }
        else if (chooseColorStrings.length == 4) {
            carColorS = gui.getUserSelection(vælgFarve, chooseColorStrings[0], chooseColorStrings[1], chooseColorStrings[2], chooseColorStrings[3]);
        } else if (chooseColorStrings.length == 3) {
            carColorS = gui.getUserSelection(vælgFarve, chooseColorStrings[0], chooseColorStrings[1], chooseColorStrings[2]);
        } else if (chooseColorStrings.length == 2) {
            carColorS = gui.getUserSelection(vælgFarve, chooseColorStrings[0], chooseColorStrings[1]);
        } else {
            gui.showMessage(playerC.getName(ref) + "'s farve er " + chooseColorStrings[0]);
            carColorS = chooseColorStrings[0];
        }
        Color carColorChoice = carColorObj.colorChosen(carColorS);

        return carColorChoice;
    }
    public int choseNumOfPlayers() {
        //int players = gui.getUserInteger("How many players is participating in the game?");
        int numOfPlayers;
        while (true) {
            String input = gui.getUserString(message.gameMessage("33"));
            if (input.matches("^[3-6]$") && input.length() > 0) {
                numOfPlayers = Integer.parseInt(input);
                break;
            } else {
                gui.showMessage(message.gameMessage("34"));
            }
        }
        return numOfPlayers;
    }

    public GUI_Car chosePlayerCar(CarColor carColorObj, PlayerController playerC, int ref) {
        GUI_Car car;
        Color carColor = chooseCarColor(carColorObj, playerC, ref);

            car = new GUI_Car(carColor, Color.blue, CAR, GUI_Car.Pattern.FILL);
            gui_cars[ref] = car;

        return car;
    }
    public void removeAllCarsCurPos(PlayerController playerC) {
        for (int i = 0; i < 40; i++) {
            fields[i].removeAllCars();
        }
    }
    public void setAllCarsCurPos(PlayerController playerC) {
        for (int i = 0; i < gui_Players.length; i++) {
            fields[(playerC.getPosition(i))].setCar(getGuiPlayer(i), true);
        }
    }
    public void playerTurnGui(PlayerController player, int ref) {
        gui.showMessage(message.playerTurn(player, ref));
    }
    public void diceUpdateGui(PlayerController player, Die die1, Die die2) {
        setDiceGui(die1, die2);
    }
    public void setDiceGui(Die die1, Die die2) {
        gui.setDice(die1.getFaceValue(), die2.getFaceValue());
    }
    public void updateGuiplayerBalance(PlayerController playerC){
        for (int balancePlayer = 0; balancePlayer <gui_Players.length ; balancePlayer++){
            gui_Players[balancePlayer].setBalance(playerC.getBalance(balancePlayer));
        }
    }
    public void showScore(PlayerController player, int i) {
        gui.showMessage(message.playerEndTurn(player, i));
    }
    public void changeStreetColor(PlayerController player, int ref){
        GUI_Field field;
        GUI_Ownable ownable;
        Color carColor = getGuiPlayer(ref).getCar().getPrimaryColor();
        field = gui.getFields()[player.getPosition(ref)];
        ownable = (GUI_Ownable) field;
        ownable.setBorder(carColor);
    }

    public void setSpecificFields(){
            //ejendomsfelter
            GUI_Street rødovrevej = new GUI_Street();
            fields[1] = rødovrevej;
            rødovrevej.setTitle("Rødovrevej");
            rødovrevej.setSubText("kr. 1.200");
            rødovrevej.setBorder(Color.BLACK);
            rødovrevej.setBackGroundColor(Color.cyan);
            GUI_Street hvidovrevej = new GUI_Street();
            fields[3] = hvidovrevej;
            hvidovrevej.setTitle("Hvidovrevej");
            hvidovrevej.setSubText("kr. 1.200");
            hvidovrevej.setBorder(Color.BLACK);
            hvidovrevej.setBackGroundColor(Color.cyan);
            GUI_Street roskildevej = new GUI_Street();
            fields[6] = roskildevej;
            roskildevej.setTitle("Roskildevej");
            roskildevej.setSubText("kr. 2.000");
            roskildevej.setBorder(Color.BLACK);
            roskildevej.setBackGroundColor(Color.pink);
            GUI_Street valby_Langgade = new GUI_Street();
            fields[8] = valby_Langgade;
            valby_Langgade.setTitle("Valby Langgade");
            valby_Langgade.setSubText("kr. 2.000");
            valby_Langgade.setBorder(Color.BLACK);
            valby_Langgade.setBackGroundColor(Color.pink);
            GUI_Street allégade = new GUI_Street();
            fields[9] = allégade;
            allégade.setTitle("Allégade");
            allégade.setSubText("kr. 2.400");
            allégade.setBorder(Color.BLACK);
            allégade.setBackGroundColor(Color.pink);
            GUI_Street frederiksberg_Allé = new GUI_Street();
            fields[11] = frederiksberg_Allé;
            frederiksberg_Allé.setTitle("Frederiksberg Allé");
            frederiksberg_Allé.setSubText("kr. 2.800");
            frederiksberg_Allé.setBorder(Color.BLACK);
            frederiksberg_Allé.setBackGroundColor(new Color(173, 255, 47));
            GUI_Street bülowsvej = new GUI_Street();
            fields[13] = bülowsvej;
            bülowsvej.setTitle("Bülowsvej");
            bülowsvej.setSubText("kr. 2.800");
            bülowsvej.setBorder(Color.BLACK);
            bülowsvej.setBackGroundColor(new Color(173, 255, 47));
            GUI_Street gl_Kongevej = new GUI_Street();
            fields[14] = gl_Kongevej;
            gl_Kongevej.setTitle("Gl. Kongevej");
            gl_Kongevej.setSubText("kr. 3.200");
            gl_Kongevej.setBorder(Color.BLACK);
            gl_Kongevej.setBackGroundColor(new Color(173, 255, 47));
            GUI_Street bernstorffsvej = new GUI_Street();
            fields[16] = bernstorffsvej;
            bernstorffsvej.setTitle("Bernstorffsvej");
            bernstorffsvej.setSubText("kr. 3.600");
            bernstorffsvej.setBorder(Color.BLACK);
            bernstorffsvej.setBackGroundColor(Color.gray);
            GUI_Street hellerupvej = new GUI_Street();
            fields[18] = hellerupvej;
            hellerupvej.setTitle("Hellerupvej");
            hellerupvej.setSubText("kr. 3.600");
            hellerupvej.setBorder(Color.BLACK);
            hellerupvej.setBackGroundColor(Color.gray);
            GUI_Street strandvej = new GUI_Street();
            fields[19] = strandvej;
            strandvej.setTitle("Strandvej");
            strandvej.setSubText("kr. 4.000");
            strandvej.setBorder(Color.BLACK);
            strandvej.setBackGroundColor(Color.gray);
            GUI_Street trianglen = new GUI_Street();
            fields[21] = trianglen;
            trianglen.setTitle("Trianglen");
            trianglen.setSubText("kr. 4.400");
            trianglen.setBorder(Color.BLACK);
            trianglen.setBackGroundColor(Color.red);
            GUI_Street østerbrogade = new GUI_Street();
            fields[23] = østerbrogade;
            østerbrogade.setTitle("Østerbrogade");
            østerbrogade.setSubText("kr. 4.400");
            østerbrogade.setBorder(Color.BLACK);
            østerbrogade.setBackGroundColor(Color.red);
            GUI_Street grønningen = new GUI_Street();
            fields[24] = grønningen;
            grønningen.setTitle("Grønningen");
            grønningen.setSubText("kr. 4.800");
            grønningen.setBorder(Color.BLACK);
            grønningen.setBackGroundColor(Color.red);
            GUI_Street bredgade = new GUI_Street();
            fields[26] = bredgade;
            bredgade.setTitle("Bredgade");
            bredgade.setSubText("kr. 5.200");
            bredgade.setBorder(Color.BLACK);
            bredgade.setBackGroundColor(Color.white);
            GUI_Street kgs_nytorv = new GUI_Street();
            fields[27] = kgs_nytorv;
            kgs_nytorv.setTitle("Kgs. nytorv");
            kgs_nytorv.setSubText("kr. 5.200");
            kgs_nytorv.setBorder(Color.BLACK);
            kgs_nytorv.setBackGroundColor(Color.white);
            GUI_Street østergade = new GUI_Street();
            fields[29] = østergade;
            østergade.setTitle("Østergade");
            østergade.setSubText("kr. 5.600");
            østergade.setBorder(Color.BLACK);
            østergade.setBackGroundColor(Color.white);
            GUI_Street amagertorv = new GUI_Street();
            fields[31] = amagertorv;
            amagertorv.setTitle("Amagertorv");
            amagertorv.setSubText("kr. 6.000");
            amagertorv.setBorder(Color.BLACK);
            amagertorv.setBackGroundColor(Color.yellow);
            GUI_Street vimmelskaftet = new GUI_Street();
            fields[32] = vimmelskaftet;
            vimmelskaftet.setTitle("Vimmelskaftet");
            vimmelskaftet.setSubText("kr. 6.000");
            vimmelskaftet.setBorder(Color.BLACK);
            vimmelskaftet.setBackGroundColor(Color.yellow);
            GUI_Street nygade = new GUI_Street();
            fields[34] = nygade;
            nygade.setTitle("Nygade");
            nygade.setSubText("kr. 6.400");
            nygade.setBorder(Color.BLACK);
            nygade.setBackGroundColor(Color.yellow);
            GUI_Street frederiksberggade = new GUI_Street();
            fields[37] = frederiksberggade;
            frederiksberggade.setTitle("Frederiksberggade");
            frederiksberggade.setSubText("kr. 7.000");
            frederiksberggade.setBorder(Color.BLACK);
            frederiksberggade.setBackGroundColor(new Color(139, 0, 139));
            GUI_Street rådhuspladsen = new GUI_Street();
            fields[39] = rådhuspladsen;
            rådhuspladsen.setTitle("Rådhuspladsen");
            rådhuspladsen.setSubText("kr. 8.000");
            rådhuspladsen.setBorder(Color.BLACK);
            rådhuspladsen.setBackGroundColor(new Color(139, 0, 139));
            //prøv lykken felter
            GUI_Chance felt3 = new GUI_Chance();
            fields[2] = felt3;
            GUI_Chance felt8 = new GUI_Chance();
            fields[7] = felt8;
            GUI_Chance felt18 = new GUI_Chance();
            fields[17] = felt18;
            GUI_Chance felt23 = new GUI_Chance();
            fields[22] = felt23;
            GUI_Chance felt34 = new GUI_Chance();
            fields[33] = felt34;
            GUI_Chance felt37 = new GUI_Chance();
            fields[36] = felt37;
            //færge felter
            GUI_Shipping lBfærgerne = new GUI_Shipping();
            fields[5] = lBfærgerne;
            lBfærgerne.setTitle("LB færgerne");
            lBfærgerne.setSubText("4.000");
            GUI_Shipping danmark = new GUI_Shipping();
            fields[15] = danmark;
            danmark.setTitle("Danmark");
            danmark.setSubText("4.000");
            GUI_Shipping mols_linien = new GUI_Shipping();
            fields[25] = mols_linien;
            mols_linien.setTitle("Mols-linien");
            mols_linien.setSubText("4.000");
            GUI_Shipping skandinavisk = new GUI_Shipping();
            fields[35] = skandinavisk;
            skandinavisk.setTitle("Skandinavisk");
            skandinavisk.setSubText("4.000");
            //fængsel felt
            GUI_Jail fængsel = new GUI_Jail();
            fields[10] = fængsel;
            fængsel.setSubText("I Fængsel");
            GUI_Jail defængsles = new GUI_Jail();
            fields[30] = defængsles;
            defængsles.setSubText("De Fængsles");
            //bryggeri felter
            GUI_Brewery carlsberg = new GUI_Brewery();
            fields[12] = carlsberg;
            carlsberg.setTitle("Carlsberg");
            carlsberg.setSubText("3.000");
            GUI_Field coca_Cola = new GUI_Street();
            fields[28] = coca_Cola;
            coca_Cola.setTitle("Coca Cola");
            coca_Cola.setSubText("3.000");
            coca_Cola.setBackGroundColor(Color.red);
            //start felt
            GUI_Start start = new GUI_Start();
            fields[0] = start;
            start.setBackGroundColor(Color.red);
            start.setSubText("modtag 4.000");
            start.setTitle("START");
            //skatte felter
            GUI_Tax indkomstskat = new GUI_Tax();
            fields[4] = indkomstskat;
            indkomstskat.setSubText("10% el. 4.000");
            indkomstskat.setTitle("Indkomstskat");
            indkomstskat.setBackGroundColor(Color.white);
            GUI_Tax statsskat = new GUI_Tax();
            fields[38] = statsskat;
            statsskat.setSubText("betal 2.000");
            statsskat.setTitle("Statsskat");
            statsskat.setBackGroundColor(Color.white);
            //parkering felt
            GUI_Refuge parkering = new GUI_Refuge();
            fields[20] = parkering;
            parkering.setSubText("Parkering");
        }



    public void guiChance(int squareInt, PlayerController playerC) {
        gui.displayChanceCard((String) chanceDesc.get(squareInt));
        removeAllCarsCurPos(playerC);
        updateGuiplayerBalance(playerC);
        setAllCarsCurPos(playerC);
    }

    public void trade(PlayerController playerC, int playerNum, Trading trading){
        // init = initiator, rece = receiver
        String[] players = new String[playerC.getNumOfPlayers()];
        int init = playerNum, rece = playerNum; // rece sat lig playerNum som en safety measure
        String[] initOffer = new String[0], receOffer = new String[0];
        int initMoney = 0, receMoney = 0;

        // Liste over spiller navne
        for(int n=0 ; n < players.length ; n++)
            players[n] = playerC.getName(n);

        String playerSelect = gui.getUserSelection("Hvem vil du bytte med?", players);

        // Finder  referencen til spilleren som skal byttes med
        for(int n=0 ; n < players.length ; n++){
            if(playerSelect.equals(players[n]))
                rece = n;
        }

        // Starten af byttehandlen
        String invSelection;
        do {
            gui.showMessage(players[init] + "'s tilbud: " + Arrays.toString(initOffer) + "\n" +
                    players[rece] + "'s tilbud: " + Arrays.toString(receOffer));

            invSelection = gui.getUserButtonPressed("Vælg spiller inventar", players[init], "AFSLUT", players[rece]);

            String typeSelection;
            // INITIATOR
            if (invSelection.equals(players[init])) {
                typeSelection = gui.getUserButtonPressed("Ejendomme eller penge?", "EJENDOMME", "PENGE");
                if (typeSelection.equals("EJENDOMME"))
                    initOffer = getTradeOwnable(playerC, init);
                else if (typeSelection.equals("PENGE"))
                    initMoney = gui.getUserInteger("Hvor mange penge skal byttes?", 0, playerC.getBalance(init));
            }

            // RECEIVER
            else if (invSelection.equals(players[rece])) {
                typeSelection = gui.getUserButtonPressed("Ejendomme eller penge?", "EJENDOMME", "PENGE");
                if (typeSelection.equals("EJENDOMME"))
                    receOffer = getTradeOwnable(playerC, rece);
                else if (typeSelection.equals("PENGE"))
                    receMoney = gui.getUserInteger("Hvor mange penge skal byttes?", 0, playerC.getBalance(rece));
            }
        } while (!invSelection.equals("AFSLUT"));

        trading.trade(playerC, init, initOffer, initMoney,
                               rece, receOffer, receMoney);
    }

    private String[] getTradeOwnable(PlayerController playerC, int ref){
        String[] ownables = new String[playerC.getPlayerOwnables(ref).length+2]; // +2 for valg "AFSLUT" og "RESET"
        String[] offer = new String[0];
        String selected;

        for (int n = 0; n < playerC.getPlayerOwnables(ref).length; n++)
            ownables[n] = playerC.getPlayerOwnables(ref)[n].getName();
        ownables[ownables.length - 1] = "AFSLUT";
        ownables[ownables.length - 2] = "RESET";

        do {
            selected = gui.getUserSelection("Hvad skal byttes?", ownables);
            if (!selected.equals("AFSLUT") && !selected.equals("RESET")) {
                if (!Copy.contains(offer, selected)){
                    offer = Copy.of(offer, offer.length + 1);
                    offer[offer.length - 1] = selected;
                }
            }
            else if (selected.equals("RESET"))
                offer = new String[0];

            gui.showMessage("Ejendomme: " + Arrays.toString(offer));
        } while(!selected.equals("AFSLUT"));

        Copy.of(offer, offer.length-2); // sletter AFSLUT og RESET

        return offer;
    }
}