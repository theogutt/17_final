package Test;

import Controller.PlayerController;
import Model.Die;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerControllerTest {
    private PlayerController playerC;
    private Die die1;
    private Die die2;
    @Before
    public void initialize() {
        playerC = new PlayerController(4);
        die1 = new Die(6);
        die2 = new Die(6);
        for (int i = 0; i < 4; i++) {
            assertEquals(0, playerC.getPosition(i));
            assertEquals(30000, playerC.getBalance(i));
        }
    }
    @Test
    public void calcNewPosition() {
        // Gameboard indexes from 0 to 39 and has 40 fields.
        playerC.setPosition(38, 0);
        playerC.calcNewPosition(1,1, 0);
        assertEquals(0, playerC.getPosition(0));

        playerC.setPosition(0, 1);
        playerC.calcNewPosition(3,2, 1);
        assertEquals(5, playerC.getPosition(1));
    }

    @Test
    public void wantOutOfJail() {
        // paying to get out of jail
        assertEquals(30000, playerC.getBalance(0));
        assertFalse(playerC.getInJail(0));

        playerC.setInJail(0, true);
        assertTrue(playerC.getInJail(0));
        playerC.wantOutOfJail(0, 1, die1, die2);

        assertEquals(29000, playerC.getBalance(0));
        assertFalse(playerC.getInJail(0));
    }
    @Test
    public void playerWithHighestBalance() {
        playerC.updatePlayerBalance(0, 4000);
        playerC.updatePlayerBalance(1, 2000);
        playerC.updatePlayerBalance(2, 100000);
        playerC.updatePlayerBalance(3, 10000);

        assertEquals(2, playerC.playerWithHighestBalance());
    }

    @Test
    public void broke() {
        assertFalse(playerC.getModelBroke(0));
        assertEquals(30000, playerC.getBalance(0));

        playerC.updatePlayerBalance(0, -35000);
        playerC.broke(0);

        assertTrue(playerC.getModelBroke(0));
    }
}