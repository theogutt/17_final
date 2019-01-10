package Model.Squares;
import Controller.PlayerController;

public class Property extends Ownable {


    public Property (int positionOnBoard, int price, boolean owned, int rent){
        super(positionOnBoard, price, owned, rent);

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

    public int landOn(PlayerController playerC, int playerNum){
        boolean playerOnwStreet = false;

        // Paying rent
        if (owned == true){
            for (PlayerC.getPlayerStreets(playerNum)){


            }

        }


    }

}
