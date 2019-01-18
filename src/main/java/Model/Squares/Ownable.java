package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;


public abstract class Ownable extends Square{
    private int owner;
    private boolean owned;
    private String name;
    private int numberOfBuildings;
    private int groupID;
    private int price;

    public Ownable(int positionOnBoard, int price, int numberOfBuildings, String name, int groupID, boolean owned, int owner){
        super(positionOnBoard);
        this.owned = owned;
        this.name = name;
        this.numberOfBuildings = numberOfBuildings;
        this.groupID = groupID;
        this.owner = owner;
        this.price = price;
    }

    public void landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC) {
        //spørger om spiller vil købe grunden
        if (!this.owned) {
            int ja = 1;
            int answer = guiHandler.buyStreet();
            if (ja == answer) {
                playerC.updatePlayerBalance(ref, this.price * -1);
                setOwned(true);
                setOwner(ref);
                Ownable curSquare = this;
                playerC.addOwnable(curSquare, ref);
                guiHandler.changeStreetColor(playerC, ref);
            }
        } else {
            if(this.owner!=ref) {
                int rent = rentC.retrieveRent(playerC, ref, this);
                playerC.updatePlayerBalance(ref, rent * -1);
                playerC.updatePlayerBalance(this.owner, rent);
                guiHandler.payRent(playerC, this.owner, ref, rent);
            }
            else{guiHandler.playersOwnSquare(playerC, ref);}
        }
    }
    public String getName() {
        return name;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setNumberOfBuildings(int numberOfBuildings){
        this.numberOfBuildings = numberOfBuildings;
    }

    public int getNumOfBuildings() {
        return numberOfBuildings;
    }

    public void setOwner(int ref) {
        this.owner = ref;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
