package Model.Squares;

import Controller.PlayerController;

public class Brewery extends Ownable{

    public Brewery(int positionOnBoard, int price, int rent, boolean owned){
        super(positionOnBoard, price, rent, owned);
    }


    @Override
    public int landOn(PlayerController playerNum) {
        return 0;
    }

}
