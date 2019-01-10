package Model.Squares;

import Controller.PlayerController;

public class GoToPrison extends Square{

    public GoToPrison(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(PlayerController playerNum){

        /*

        Dette afsnit skal flyttes over i en controller

        //Sætter spillerens position til at være på fængselsfeltet
        playerNum.setPosition(6);

        //Sætter spillerens status til at være i fængsel
        playerNum.setInJail(true);

        */

        //Retur værdi som en controller skal bruge til at finde ud af hvad den skal gøre
        //Selve værdien kan sagtens ændres
        return -18;
    }


}
