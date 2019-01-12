package Model.Squares;

import Controller.PlayerController;

public class Street extends Ownable{
    private int owner;
    private final int price;
    private boolean owned;
    private int positionOnBoard;
    private final String name;
    private int numOfBuildings;
    private int groupID;

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner){
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
        this.name = name;
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
        this.owner = owner;
    }

    public int getPrice() {
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

    public int getPositionOnBoard() {
        return positionOnBoard;
    }
    @Override
    public int getOwner() {
        return owner;
    }
}