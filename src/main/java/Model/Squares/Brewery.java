package Model.Squares;


public class Brewery extends Ownable{

    public Brewery(int positionOnBoard, int price, int rent, boolean owned){
        super(positionOnBoard, price, rent, owned);
    }

    // Udregner leje
    public int getRent(int facevalueSum, int numberOfBrewerys){
        int rent = facevalueSum * 100 * numberOfBrewerys;
        return rent;
    }

    @Override
    public int landOn(){
        return -1;
    }
}
