package Model.Squares;

public abstract class Square{

    private int positionOnBoard;
    private int owner;
    private int numOfBuildings;

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public int getOwner() {
        return owner;
    }

    public int getNumOfBuildings() {
        return numOfBuildings;
    }
}