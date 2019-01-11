package Model.Squares;


import Controller.PlayerController;

public class GoToPrison extends Square{

    private PlayerController PlayerC
    public GoToPrison(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum) {
        int p = PlayerC.getPlayerPlayerNum(playerC);
        PlayerC.setPosition(10,p);
        PlayerC.setInJail(playerNum, true);
        return 0;
    }

    @Override
    public int getPositionOnBoard(){

        return super.getPositionOnBoard();
    }

}
