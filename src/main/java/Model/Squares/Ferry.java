package Model.Squares;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

import java.io.IOException;

public class Ferry extends Ownable{
    private int owner;
    private boolean owned;
    private int positionOnBoard;
    private String name;
    private GUI_Handler guiHandler;
    private PlayerController playerC;
    private RentController rentC;
    private int groupID;
    private GameBoard gameBoard;
    private Square[] squares = new Square[40];

    public Ferry(int positionOnBoard, int price, String name, boolean owned, int owner, int groupID) throws IOException {
        super(positionOnBoard, price);
        this.owned = owned;
        this.name = name;
        this.owner = owner;
        this.groupID = groupID;
    }


    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC) {
        //spørger om spiller vil købe grunden
        if(isOwned()==false) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                int price = getPrice();
                playerC.updatePlayerBalance(ref, price * -1);
                setOwner(ref);
                setOwned(true);
                int position = playerC.getPosition(ref);
                Square curSquare = squares[position];
                playerC.addOwnables(ref, (Ownable) curSquare);
                guiHandler.changeStreetColor(playerC, ref);
            } else {}
        }
        else{
            rentC.payRentFerry(playerC, ref);
        }
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

    public int getGroupID() {
        return groupID;
    }
}
