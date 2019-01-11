package Model.Squares;


import Controller.PlayerController;
import Model.Player;

public class GoToPrison extends Square{

    private PlayerController PlayerC;
    public GoToPrison(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum, int ref) {
        int p = PlayerC.getPlayerPlayerNum(ref);
        PlayerC.setPosition(10,p);
        PlayerC.setInJail(p, true);
        return 0;
    }

    @Override
    public int getPositionOnBoard(){

        return super.getPositionOnBoard();
    }

}
