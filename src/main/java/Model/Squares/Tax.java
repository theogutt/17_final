package Model.Squares;


import Controller.PlayerController;

public class Tax extends Square{

    public Tax(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.positionOnBoard;
    }

    @Override
    public int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum){
        return -1;
    }
}
