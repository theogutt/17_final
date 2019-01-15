package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

import java.io.IOException;

public class Ferry extends Ownable{
    private int owner;
    private int price;
    private boolean owned;
    private int positionOnBoard;
    private String name;
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private RentController rentC;

    public Ferry(int positionOnBoard, int price, String name, boolean owned, int owner) throws IOException {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.owner = owner;
    }

    public int getPrice() {
        return price;
    }

    public int landOn(PlayerController playerC, int playerNum, GUI_Handler guiHandler, RentController rentC) {
        //spørger om spiller vil købe grunden
        if(isOwned()==false) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                int price = getPrice(positionOnBoard);
                playerC.updatePlayerBalance(playerNum, price * -1);
                setOwner(playerNum);
                setOwned(true);
            } else {}
        }
        else{
            rentC.payRentFerry(playerC, playerNum);
        }
        return -1;
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

    public void setOwner(int playerNum) {
        this.owner = playerNum;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
