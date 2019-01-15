package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

import java.io.IOException;

public class Brewery extends Ownable{
    private int owner;
    private int price;
    private boolean owned;
    private String name;

    public Brewery(int positionOnBoard, int price, String name, boolean owned, int owner) throws IOException {
        super(positionOnBoard, price, name, owned, owner);
    }
}
