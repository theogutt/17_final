package Model.Squares;

import Controller.GameBoard;
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

    public int landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){
        //spørger om spiller vil købe grunden
        if(!isOwned()) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                playerC.updatePlayerBalance(ref, this.price * -1);
                setOwner(ref);
                setOwned(true);
            }
        }
        else{
            rentC.payRent(playerC, ref);
        }
        return -1;
    };

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getOwner() {
        return this.owner;
    }

    public boolean isOwned() {
        return this.owned;
    }

    public void setOwner(int ref) {
        this.owner = ref;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public int getPrice(){return price;}
}
