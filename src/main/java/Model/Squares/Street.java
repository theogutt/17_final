package Model.Squares;
import Controller.PlayerController;
import Model.Squares.Ownable;

public class Street extends Ownable {


    public Street (int positionOnBoard, int price, boolean owned, int rent){
        super(positionOnBoard, price, rent, owned);

    }
    public void setOwned(boolean owned) {
        this.owned = owned;
    }
    public boolean getOwned(){
        return owned;
    }

    public int getPrice() {
        return price;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }
    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }

    public int landOn(PlayerController numPlayer){
        return 1;

    }

}
