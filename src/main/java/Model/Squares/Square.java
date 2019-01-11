package Model.Squares;

public abstract class Square {

    protected int positionOnBoard;

    //Constructor
    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public int getPositionOnBoard(){
        return positionOnBoard;
    }
}
