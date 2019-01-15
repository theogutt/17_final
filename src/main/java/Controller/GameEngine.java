package Controller;

import Model.Die;
import Model.Squares.Square;
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
            guiHandler.updateGuiPlayerBalance(playerC);
            guiHandler.showScore(playerC, ref);
            i++;
        }
        while(true);
    }
    public void playTurn(int ref) {
        guiHandler.updateGuiPlayerBalance(playerC);
        guiHandler.removeAllCarsCurPos(playerC);
            playerC.calcNewPosition(die1.roll(), die2.roll(), ref);
            guiHandler.setAllCarsCurPos(playerC);
            guiHandler.diceUpdateGui(playerC, die1, die2);
            boolean passedStart = gameBoard.didPlayerPassStart(playerC, ref);
            if(passedStart==true){guiHandler.messageSquareGui(playerC, ref, gameBoard.getSquare(playerC.getPosition(ref)), passedStart);}
            gameBoard.squareImpact(ref, playerC, guiHandler, rentC, gameBoard);
            guiHandler.updateGuiPlayerBalance(playerC);
    }
    public int calcTurn(int j) {
        int currentTurn = j % playerC.getNumOfPlayers();
        return currentTurn;
    }
}
