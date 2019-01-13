package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public class Brewery extends Ownable{
    private boolean owned;
    private int price;
    public Brewery(int positionOnBoard, int price, boolean owned) {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
    }

    public int getPrice() {
        return price;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC) {

    }
}