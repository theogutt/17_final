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

    public int getNumOfBuildings() {
        return numOfBuildings;
    }
}