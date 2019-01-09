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
    public int landOn(PlayerController playerNum){
        /*
        Retunere værdi som en controller bruger
        til at finde ud af hvad den skal gøre
        */
        return -1;
    }
}
