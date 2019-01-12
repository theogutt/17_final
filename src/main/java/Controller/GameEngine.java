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

    public GameEngine() throws IOException {
        guiHandler = new GUI_Handler();
        die1 = new Die(6);
        die2 = new Die(6);
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
    }
    public int calcTurn(int j) {
        int currentTurn = j % playerC.getNumOfPlayers();
        return currentTurn;
    }
}
