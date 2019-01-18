package Test;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import Model.Squares.Street;
import View.GUI_Handler;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class OwnableTest {

    @Test
    public void getName() throws IOException {
        Street allegade = new Street(0,0,0,"allegade", 0,false,99);
        assertEquals("allegade", allegade.getName());
    }

    /*@Test
    public void getPrice() throws IOException {
        Street allegade = new Street(0,1000,0,"", 0,false,99);
        assertEquals(1000, allegade.getPrice());
    }*/

    @Test
    public void getGroupID() throws IOException {
        Street allegade = new Street(0,0,0,"", 1,false,99);
        assertEquals(1, allegade.getGroupID());
    }

    @Test
    public void setNumberOfBuildings() throws IOException {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(0, allegade.getNumOfBuildings());
        allegade.setNumberOfBuildings(4);
        assertEquals(4, allegade.getNumOfBuildings());
    }

    @Test
    public void getNumOfBuildings() throws IOException {
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

    @Test
    public void setOwner() throws IOException {
        Street allegade = new Street(0,0,0,"", 0,false,99);
        assertEquals(99, allegade.getOwner());
        allegade.setOwner(1);
        assertEquals(1, allegade.getOwner());
    }

    @Test
    public void getOwner() throws IOException {
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