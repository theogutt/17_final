package Test;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import Model.Squares.*;
import View.GUI_Handler;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GameBoardTest {
    GUI_Handler gui;
    GameBoard gameBoard;
    PlayerController playerC;
    RentController rent;

    @Before
    public void initialize() throws IOException {
        gui = new GUI_Handler();
        gameBoard = new GameBoard();
        playerC = new PlayerController(3);
        rent = new RentController();
        for (int i = 0; i < 3; i++) {
            assertEquals(0, playerC.getPosition(i));
            assertEquals(30000, playerC.getBalance(i));
        }
    }
/*
    @Test
    public void getGroupID() {
        //start
        assertEquals(0, gameBoard.getGroupID(0));
        //Carlsberg
        assertEquals(10, gameBoard.getGroupID(28));
        //Danmark
        assertEquals(9, gameBoard.getGroupID(15));
        //Rådhuspladsen
        assertEquals(8, gameBoard.getGroupID(39));
    }*/

    @Test
    public void instantiateSquares() {
        int numOfStart = 0;
        int numOfSquareParking = 0;
        int numOfSquareGoToPrison = 0;
        int numOfSquareChance = 0;
        int numOfProperty = 0;
        int numOfBreweries = 0;
        int numOfFerries = 0;

        for (int i = 0; i < 40; i++) {
            Square square = gameBoard.getSquare(i);
            if (square instanceof Start) numOfStart++;
            else if (square instanceof Parking) numOfSquareParking++;
            else if (square instanceof GoToPrison) numOfSquareGoToPrison++;
            else if (square instanceof Chance) numOfSquareChance++;
            else if (square instanceof Street) numOfProperty++;
            else if (square instanceof Brewery) numOfBreweries++;
            else if (square instanceof Ferry) numOfFerries++;
        }

        assertEquals(1, numOfStart);
        assertEquals(2, numOfSquareParking);
        assertEquals(1, numOfSquareGoToPrison);
        assertEquals(6, numOfSquareChance);
        assertEquals(22, numOfProperty);
        assertEquals(2, numOfBreweries);
        assertEquals(4, numOfFerries);
    }

    @Test
    public void passedStart() {
        playerC.setPosition(39, 0);
        playerC.setPosition(1, 0);
        gameBoard.passedStart(playerC, 0);
        assertEquals(34000, playerC.getBalance(0));
    }
}