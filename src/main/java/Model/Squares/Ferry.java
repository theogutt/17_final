package Model.Squares;

import Controller.PlayerController;

public class Ferry extends Ownable{

    public Ferry(int positionOnBoard, int price, int rent, boolean owned){
        super(positionOnBoard, price, rent, owned);
    }

    @Override
    public int landOn(PlayerController playerNum) {
        return 0;
    }
}
