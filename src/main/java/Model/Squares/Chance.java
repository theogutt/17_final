package Model.Squares;


public class Chance extends Square{

    public Chance(int positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    @Override
    public int landOn(){
        return -1;
    }
}
