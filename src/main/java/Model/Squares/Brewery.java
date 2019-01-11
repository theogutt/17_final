package Model.Squares;


import Controller.PlayerController;

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
    public int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum){
        return -1;
    }
}
