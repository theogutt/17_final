package Model.Squares;

import Controller.PlayerController;

public class Parking extends Square{

    public Parking(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(PlayerController playerNum){

        //Retur værdi som en controller skal bruge til at finde ud af hvad den skal gøre
        //Selve værdien kan sagtens ændres
        return -1;
    }
}
