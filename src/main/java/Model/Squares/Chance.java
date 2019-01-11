package Model.Squares;


import Controller.PlayerController;

public class Chance extends Square{

    public Chance(int positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum, int ref){
        return -1;
    }
}
