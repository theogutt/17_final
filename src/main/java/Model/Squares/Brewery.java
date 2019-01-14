package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

import java.io.IOException;

public class Brewery extends Ownable{
    private int owner;
    private int price;
    private boolean owned;
    private int positionOnBoard;
    private String name;
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private RentController rentC;

    public Brewery(int positionOnBoard, int price, String name, boolean owned, int owner) throws IOException {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC) {
        //spørger om spiller vil købe grunden
        if(isOwned()==false) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                int price = getPrice(positionOnBoard);
                playerC.updatePlayerBalance(ref, price * -1);
                setOwner(ref);
                setOwned(true);
            } else {}
        }
        else{
            rentC.payRentBrewery(playerC, ref);
        }
    }
    public int getPrice(int positionOnBoard) {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getPositionOnBoard() {
        return positionOnBoard;
    }
    public int getOwner() {
        return this.owner;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwner(int ref) {
        this.owner = ref;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
