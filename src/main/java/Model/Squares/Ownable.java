package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Ownable extends Square{
    private int owner;
    private int price;
    private boolean owned;
    private int positionOnBoard;
    private String name;

    public Ownable(int positionOnBoard, int price, String name, boolean owned, int owner) {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.owner = owner;
    }

    public abstract int landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC);

    public int getOwner() {
        return owner;
    }
}
