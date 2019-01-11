package Model.Squares;


public class Tax extends Square{

    public Tax(int positionOnBoard){
        super(positionOnBoard);
    }

    @Override
    public int getPositionOnBoard(){
        return super.positionOnBoard;
    }

    @Override
    public int landOn(){
        return -1;
    }
}
