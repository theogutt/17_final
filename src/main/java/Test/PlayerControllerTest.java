//*******************************************************************
// PlayerControllerTest.java       Author: Gruppe 17
//
// Tester PlayerControlleren
//*******************************************************************

package Test;

import Controller.PlayerController;
import Model.Die;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerControllerTest {
    private PlayerController playerC;
    private Die die1;
    private Die die2;

    @Before
    public void initialize() throws IOException {
        playerC = new PlayerController(4);
        die1 = new Die(6);
        die2 = new Die(6);
        // Tester om en spiller starter på start og har den korrekte start pengebeholdning
        for (int i = 0; i < 4; i++) {
            assertEquals(0, playerC.getPosition(i));
            assertEquals(30000, playerC.getBalance(i));
        }
    }

    // Tester om en spiller rykker det rigtige antal felter når der slås med terningerne
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

    // Tester når spilleren er i fængsel
    @Test
    public void wantOutOfJail() {
        // paying to get out of jail

        // Tester om spiller er i fængsel til start
        assertEquals(30000, playerC.getBalance(0));
        assertFalse(playerC.getInJail(0));

        // Tester om spiller er i fængsel efter at blive sat i fængsel, og om han kommer ud hvis han betaler sig ud
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

        assertEquals(2, playerC.playerWithHighestBalance(1));
    }

    // Tester om spiller går fallit når han har negativ pengebeholdning.
    @Test
    public void broke() {
        assertFalse(playerC.getModelBroke(0));
        assertEquals(30000, playerC.getBalance(0));

        playerC.updatePlayerBalance(0, -35000);
        playerC.broke(0);

        assertTrue(playerC.getModelBroke(0));
    }
}