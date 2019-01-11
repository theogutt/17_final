package Model.Squares;


import Controller.PlayerController;

public class Start extends Square{

    //Constructor
    public Start(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum){
        return -1;
    }
}
