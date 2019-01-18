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

    public void start() {
        setUpGame();
        playGame();
    }

    private void setUpGame() {
        guiHandler.startGameGui();
        playerC = new PlayerController(guiHandler.chooseNumOfPlayers());
        guiHandler.setGameUpGui(playerC);
    }

    private void playGame() {
        int loser = turnFlow();
        endGame(loser);
    }

    private int turnFlow() {
        //Normal turn
        int playerNum;
        int i = 0;

        do {
            playerNum = i % playerC.getNumOfPlayers(); // Calculates turn
            guiHandler.playerTurnGui(playerC, playerNum);
            playTurn(playerNum);
            guiHandler.updateGuiPlayerBalance(playerC);
            playerC.broke(playerNum);
            i++;
        }
        // while(true);
        while (!playerC.getModelBroke(playerNum));
        return playerNum;
    }

    private void playTurn(int playerNum) {
        int middlePosition;

        guiHandler.updateGuiPlayerBalance(playerC);

        if (playerC.getInJail(playerNum)){
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
        guiHandler.removeAllCarsCurPos();
        if (!playerC.getInJail(playerNum))
            playerC.calcNewPosition(die1.getFaceValue(), die2.getFaceValue(), playerNum);
        guiHandler.setAllCarsCurPos(playerC);
        guiHandler.diceUpdateGui(die1, die2);
        boolean passedStart = gameBoard.passedStart(playerC, playerNum);
        if(passedStart){guiHandler.messageSquareGui(playerC, playerNum, passedStart);}
        middlePosition = playerC.getPosition(playerNum);
        gameBoard.squareImpact(playerNum, playerC, guiHandler, rentC);
        if (middlePosition != playerC.getPosition(playerNum))
            gameBoard.squareImpact(playerNum, playerC, guiHandler, rentC);
        guiHandler.updateGuiPlayerBalance(playerC);
        extraTurn(playerNum);
        this.pairs = 0;
        guiHandler.menu(playerC, playerNum, building, trading);
    }

    private void endGame(int ref) {
        int x = playerC.playerWithHighestBalance();
        guiHandler.gotBrokeGui(playerC, ref);
        guiHandler.playerWonGui(playerC, x);
    }

    private void extraTurn(int playerNum){

        if (die1.getFaceValue() == die2.getFaceValue()){
            this.pairs++;
            System.out.println(this.pairs);
            if (this.pairs == 3){
                playerC.setPosition(10,playerNum);
                playerC.setInJail(playerNum, true);
            }
            else{
                playTurn(playerNum);
            }
        }
    }
}
