//*******************************************************************
// OwnableTets.java       Author: Gruppe 17
//
// Tester Ownable klassen
//*******************************************************************

package Test;

import Model.Squares.Street;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnableTest {

    // Tester om et felt får det korrekte navn når det laves
    @Test
    public void getName() {
        Street allegade = new Street(0,0,0,"allegade", 0,false,99);
        assertEquals("allegade", allegade.getName());
    }

    /*@Test
    public void getPrice() throws IOException {
        Street allegade = new Street(0,1000,0,"", 0,false,99);
        assertEquals(1000, allegade.getPrice());
    }*/

    // Tester om et felt får det korrekte gruppe ID når det laves
    @Test
    public void getGroupID() {
        Street allegade = new Street(0,0,0,"", 1,false,99);
        assertEquals(1, allegade.getGroupID());
    }

    // Tester om der kan bygges huse på en felt
    @Test
    public void setNumberOfBuildings() {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(0, allegade.getNumOfBuildings());
        allegade.setNumberOfBuildings(4);
        assertEquals(4, allegade.getNumOfBuildings());
    }

    // Tester om et felt kan returnerer det korrekte antal huse
    @Test
    public void getNumOfBuildings() {
        Street allegade = new Street(0,0,4,"", 0,false,99);
        assertEquals(4, allegade.getNumOfBuildings());
    }

    /*  @Test
    public void isOwned() throws IOException {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(false, allegade.isOwned());
        allegade.setOwned(true);
        assertEquals(true, allegade.isOwned());
    }*/

    // Tester om et felt kan ændre ejer
    @Test
    public void setOwner() {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(99, allegade.getOwner());
        allegade.setOwner(1);
        assertEquals(1, allegade.getOwner());
    }

    // Tester om et felt returnerer den korrekte ejer
    @Test
    public void getOwner() {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(99, allegade.getOwner());
    }

    /*    @Test
    public void setOwned() throws IOException {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(false, allegade.isOwned());
        allegade.setOwned(true);
        assertEquals(true, allegade.isOwned());
    }*/
}