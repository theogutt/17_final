package Model.Squares;

public class Street extends Ownable{
    private final int price;
    private boolean owned;
    private int positionOnBoard;
    private final String name;
    private int numOfBuildings;
    private int groupID;

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned){
        this.price = price;
        this.owned = owned;
        this.positionOnBoard = positionOnBoard;
        this.name = name;
        this.numOfBuildings = numOfBuildings;
        this.groupID = groupID;
    }
}