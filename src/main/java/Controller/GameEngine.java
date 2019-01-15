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
        int loser = turnFlow();
        endGame(loser);
    }
    public int turnFlow() {
        //Normal turn
        int playerNum;
        int i = 0;
        do {
            playerNum = calcTurn(i);
            guiHandler.playerTurnGui(playerC, playerNum);
            if (true) {
                playTurn(playerNum);
            }
            guiHandler.showScore(playerC, playerNum);
            i++;
        }
        while(true);
    }
    public void playTurn(int playerNum) {
        if (playerC.getInJail(playerNum) == true){
            playerC.wantOutOfJail(playerNum);
        }
        else{
            die1.roll();
            die2.roll();
        }
            guiHandler.removeAllCarsCurPos(playerC);
            playerC.calcNewPosition(die1.getFaceValue(), die2.getFaceValue(), playerNum);
            guiHandler.setAllCarsCurPos(playerC);
            guiHandler.diceUpdateGui(playerC, die1, die2);
            boolean passedStart = gameBoard.didPlayerPassStart(playerC, playerNum);
            if(passedStart==true){guiHandler.messageSquareGui(playerC, playerNum, gameBoard.getSquare(playerC.getPosition(playerNum)), passedStart);}
            gameBoard.squareImpact(playerNum, playerC, guiHandler, rentC);
            guiHandler.menu(playerC, playerNum);
    }
    public int calcTurn(int j) {
        int currentTurn = j % playerC.getNumOfPlayers();
        return currentTurn;
    }

    public void endGame(int ref) {
        int x = playerC.playerWithHighestBalance();
        guiHandler.gotBrokeGui(playerC, ref);
        guiHandler.playerWonGui(playerC, x);
    }

        public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }
}
