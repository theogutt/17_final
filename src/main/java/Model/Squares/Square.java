package Model.Squares;

import Controller.PlayerController;

public abstract class Square {

    protected int positionOnBoard;

    //Constructor
    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public int getPositionOnBoard(){
        return positionOnBoard;
    }

    public abstract int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum);
}
