package Model.Squares;


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
    public int landOn(){
        return -1;
    }
}
