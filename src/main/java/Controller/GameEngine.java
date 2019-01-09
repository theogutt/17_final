package Controller;

import Model.Die;
import View.GUI_Handler;

import java.io.IOException;

public class GameEngine {
    private GUI_Handler guiHandler;
    private PlayerController playerC;

    public GameEngine() throws IOException {
        guiHandler = new GUI_Handler();
    }
    public void start() {
        setUpGame();
    }
    public void setUpGame() {
        guiHandler.startGameGui();
        playerC = new PlayerController(guiHandler.choseNumOfPlayers());
        guiHandler.setGameUpGui(playerC);
    }
}
