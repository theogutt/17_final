package Model;

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


    @Test
    public void roll() {
        // can the die roll faceValues smaller than 1 or bigger than 6.
        for (int i = 1; i <= 1000; i++){
            die.roll();
            assertTrue(1 <= die.getFaceValue() && die.getFaceValue() <= 6);
        }

        // is the die over 60000 rolls according to the theoretical
        // probability. We accept if the faceValue is evenly spread
        // - (10000 each) - among 1 to 6, plus/minus 400.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 1; j <= 60000; j++){
            die.roll();
            list.add(die.getFaceValue());
        }
        for (int j = 1; j<=6; j++){
            int test = Collections.frequency(list, j);
            assertTrue(9600 <= test && test <= 10400);
        }
    }
}