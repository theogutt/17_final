package Model.Squares;
import Controller.PlayerController;
import Model.Squares.Ownable;

public class Street extends Ownable {


    public Street (int positionOnBoard, int price, boolean owned, int rent){
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
        boolean playerOwnStreet = false;

        // Paying rent
        if (owned == true){
            for (int i : playerC.getPlayerStreets(playerNum)){
                if (i == positionOnBoard){
                    playerOwnStreet = true;
                }
            }

            // Who to pay rent to
            if (playerOwnStreet == false){
                int numOfPlayers;
                numOfPlayers = playerC.getNumOfPlayers();
                for (int j = 0 ; (j < numOfPlayers); j++){

                }
            }
        }

    }

}
