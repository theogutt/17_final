//*******************************************************************
// DieTest.java       Author: Gruppe 17
//
// Tester Die klassen
//*******************************************************************

package Test;

import Model.Die;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class DieTest {
    Die die;

    @Before
    public void initialize(){
        die = new Die(6);
    }

    // Tester om terningen ruller det korrekte antal øjne (fra 1 til 6)
    @Test
    public void roll() {
        // can the die roll faceValues smaller than 1 or bigger than 6.
        for (int i = 1; i <= 1000; i++){
            die.roll();
            assertTrue(1 <= die.getFaceValue() && die.getFaceValue() <= 6);
        }
    }
}