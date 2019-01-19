//************************************************************************
// GameEngine.java       Author: Gruppe 17
//
// Opsætter spillet ud fra de andre klasser og kontrollerer spillets gang
//************************************************************************

package Controller;

import Model.Die;
import View.GUI_Handler;
import java.io.IOException;

public class GameEngine {
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private GameBoard gameBoard;
    private Building building;
    private Trading trading;
    private Die die1;
    private Die die2;
    private RentController rentC;
    private int pairs;

    public GameEngine() throws IOException {
        guiHandler = new GUI_Handler();
        die1 = new Die(6);
        die2 = new Die(6);
        gameBoard = new GameBoard();
        rentC = new RentController();
        building = new Building();
        trading = new Trading();
    }

    // Sætter spillet op og starter det
    public void start() throws IOException {
        setUpGame();
        playGame();
    }

    // Beder om at opsætte gui'en
    private void setUpGame() throws IOException {
        guiHandler.startGameGui();
        playerC = new PlayerController(guiHandler.chooseNumOfPlayers());
        guiHandler.setGameUpGui(playerC);
    }

    // Kører spillet og slutter det
    private void playGame() {
        int loser = turnFlow();
        endGame(loser);
    }

    // Kører turer indtil en spiller går fallit
    private int turnFlow() {
        //Normal turn
        int playerNum;
        int i = 0;

        // Kører en tur indtil en spiller går fallit
        do {
            playerNum = i % playerC.getNumOfPlayers(); // Finder hvis tur det er
            guiHandler.playerTurnGui(playerC, playerNum);
            playTurn(playerNum);
            guiHandler.updateGuiPlayerBalance(playerC);
            playerC.broke(playerNum);
            i++;
        }
        while (!playerC.getModelBroke(playerNum)); // Mens spilleren IKKE er fallit
        return playerNum;
    }

    // Kører én spillers tur
    private void playTurn(int playerNum) {
        int middlePosition;

        do {
            guiHandler.updateGuiPlayerBalance(playerC);

            // Hvis en spiller er i fængsel
            if (playerC.getInJail(playerNum)) {
                if (playerC.getJailCard(playerNum)) {
                    playerC.getOutOfJailFree(playerNum);
                } else {
                    int choice = guiHandler.payOrRoll();
                    playerC.wantOutOfJail(playerNum, choice, die1, die2);
                }
            } else {
                die1.roll();
                die2.roll();
            }
            guiHandler.removeAllCarsCurPos();

            // Hvis spilleren stadig ikke er kommet ud af fængslet
            if (!playerC.getInJail(playerNum))
                playerC.calcNewPosition(die1.getFaceValue(), die2.getFaceValue(), playerNum);

            guiHandler.setAllCarsCurPos(playerC);
            guiHandler.diceUpdateGui(die1, die2);

            // Hvis spilleren passerede start
            boolean passedStart = gameBoard.passedStart(playerC, playerNum);
            if (passedStart) {
                guiHandler.messageSquareGui(playerC, playerNum);
            }

            middlePosition = playerC.getPosition(playerNum);
            gameBoard.squareImpact(playerNum, playerC, guiHandler, rentC);

            // Hvis spilleren ramte et chancekort som ændrede hans position
            if (middlePosition != playerC.getPosition(playerNum))
                gameBoard.squareImpact(playerNum, playerC, guiHandler, rentC);

            guiHandler.updateGuiPlayerBalance(playerC);
             // Hvis spiller slog to ens får han en ekstra tur
        } while(extraTurn(playerNum));
        this.pairs = 0;
        guiHandler.menu(playerC, playerNum, building, trading);
    }

    // Finder spilleren med højest værdi og siger hvem tabte og hvem vandt
    private void endGame(int ref) {
        int x = playerC.playerWithHighestBalance(ref);
        guiHandler.gotBrokeGui(playerC, ref);
        guiHandler.playerWonGui(playerC, x);
    }

    // Giver spilleren en ekstra tur hvis han slår to ens, men sætter ham i fængsel hvis han slår to ens tre gange
    private boolean extraTurn(int playerNum){
        boolean getExtra = false;
        if (die1.getFaceValue() == die2.getFaceValue()){
            this.pairs++;
            if (this.pairs == 3){
                playerC.setPosition(10,playerNum);
                playerC.setInJail(playerNum, true);
            }
            else if(playerC.getInJail(playerNum)){} // Hvis spilleren kom i fængsel på et dobbelt slag
            else{
                getExtra = true;
                guiHandler.extraTurnGui();
            }
        }
        return getExtra;
    }
}
