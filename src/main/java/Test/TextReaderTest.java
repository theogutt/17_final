//*******************************************************************
// TextReaderTest.java       Author: Gruppe 17
//
// Tester TextReader klassen
//*******************************************************************

package Test;

import Utilities.TextReader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TextReaderTest {

    // Tester om der hentes det rigtige dokument med de rigtige værdier
    @Test
    public void textReader() throws IOException {
        int[] fieldsPrice = {0,1200,0,1200,0,4000,2000,0,2000,2400,0,2800,3000,2800,3200,4000,3600,0,3600,4000,0,4400,0,4400,4800,4000,5200,5200,3000,5600,0,6000,6000,0,6400,4000,0,7000,0,8000};
        String file = ".\\src\\Resources\\SquarePrice";
        HashMap fieldPricesFile = TextReader.textReader(file);

        assertEquals(fieldsPrice.length, fieldPricesFile.size());

        for (int price = 0; price < fieldsPrice.length; price++) {
            assertEquals(fieldsPrice[price], fieldPricesFile.get(price));
        }
    }
}
