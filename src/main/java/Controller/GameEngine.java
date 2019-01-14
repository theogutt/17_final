package Controller;

import Model.Die;
import View.GUI_Handler;

import java.io.IOException;

import java.io.IOException;

public class GameEngine {
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private GameBoard gameBoard;
    private Die die1;
    private Die die2;
    private RentController rentC;

    public GameEngine() throws IOException {
        guiHandler = new GUI_Handler();
        die1 = new Die(6);
        die2 = new Die(6);
        gameBoard = new GameBoard();
        rentC = new RentController();
    }
    public void start() {
        setUpGame();
        playGame();
    }

    public void setUpGame() {
        guiHandler.startGameGui();
        playerC = new PlayerController(guiHandler.choseNumOfPlayers());
        guiHandler.setGameUpGui(playerC);
    }

    public void playGame() {
        //Normal turn
        int ref;
        int i = 0;
        do {
            ref = calcTurn(i);
            guiHandler.playerTurnGui(playerC, ref);
            if (true) {
                playTurn(ref);
            }
            guiHandler.showScore(playerC, ref);
            i++;
        }
        while(true);
    }
    public void playTurn(int ref) {
            guiHandler.removeAllCarsCurPos(playerC);
            playerC.calcNewPosition(die1.roll(), die2.roll(), ref);
            guiHandler.setAllCarsCurPos(playerC);
            guiHandler.diceUpdateGui(playerC, die1, die2);
            gameBoard.squareImpact(ref, playerC, guiHandler, rentC);
    }
    public int calcTurn(int j) {
        int currentTurn = j % playerC.getNumOfPlayers();
        return currentTurn;
    }

    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }
}
