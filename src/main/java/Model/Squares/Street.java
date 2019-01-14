package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

import java.io.IOException;

public class Street extends Ownable{
    private int owner;
    private int price;
    private boolean owned;
    private String name;
    private int numOfBuildings;
    private int groupID;

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard, price, name, owned, owner);
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
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
            } else {}
        }
        else{
            rentC.payRent(playerC, ref);
        }
        return -1;
    }

    public int getPrice(int positionOnBoard) {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getGroupID() {
        return groupID;
    }
    @Override
    public int getNumOfBuildings() {
        return numOfBuildings;
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