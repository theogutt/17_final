package Controller;

import Model.Die;
import Model.Squares.Chance;
import Model.Squares.Square;
import Utilities.Cheatkodes;
import View.GUI_Handler;

import java.io.IOException;

import java.io.IOException;

public class GameEngine {
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private GameBoard gameBoard;
    private Cheatkodes cheatkodes;
    private Chance chance;
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
        int playerNum;
        int i = 0;
        do {
            playerNum = calcTurn(i);
            guiHandler.playerTurnGui(playerC, playerNum);
            if (true) {
                playTurn(playerNum,cheatkodes);
            }
            guiHandler.showScore(playerC, playerNum);
            i++;
        }
        while(true);
    }
    public void playTurn(int playerNum, Cheatkodes cheatkodes) {

        cheatkodes.cheats(playerC, playerNum, this,guiHandler,rentC,chance);

        guiHandler.updateGuiPlayerBalance(playerC);

        if (playerC.getInJail(playerNum) == true){
            if (playerC.getJailCard(playerNum)) {
                playerC.getOutOfJailFree(playerNum);
            }
            else {
                int choice = guiHandler.payOrRoll();
                playerC.wantOutOfJail(playerNum, choice, die1, die2);
            }
        }
        else{
            die1.roll();
            die2.roll();
        }
        guiHandler.removeAllCarsCurPos(playerC);
        if (!playerC.getInJail(playerNum))
            playerC.calcNewPosition(die1.getFaceValue(), die2.getFaceValue(), playerNum);
        guiHandler.setAllCarsCurPos(playerC);
        guiHandler.diceUpdateGui(playerC, die1, die2);
        boolean passedStart = gameBoard.didPlayerPassStart(playerC, playerNum);
        if(passedStart==true){guiHandler.messageSquareGui(playerC, playerNum, gameBoard.getSquare(playerC.getPosition(playerNum)), passedStart);}
        gameBoard.squareImpact(playerNum, playerC, guiHandler, rentC);

        guiHandler.updateGuiPlayerBalance(playerC);
        extraTurn(playerNum);
        pairs = 0;
    }

    public int calcTurn(int j) {
        int currentTurn = j % playerC.getNumOfPlayers();
        return currentTurn;
    }

    public void extraTurn(int playerNum){

        if (die1 == die2){
            pairs++;
        }
        if (pairs == 3){
            playerC.setPosition(10,playerNum);
            playerC.setInJail(playerNum, true);
        }
        else{
            playTurn(playerNum, cheatkodes);
        }
    }


    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }

    public void setPairs(int pairs){
        this.pairs = pairs;
    }










}
