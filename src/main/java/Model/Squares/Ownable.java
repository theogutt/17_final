package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;


public abstract class Ownable extends Square{
    private int price;

    public Ownable(int positionOnBoard, int price) {
        super(positionOnBoard);
        this.price = price;
    }

    public abstract void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC);


    public int getOwner() {
        return getOwner();
    }

    public int getPrice(){return price;}
}
