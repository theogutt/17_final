package Model.Squares;

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
    public int landOn(){
        return -1;
    }

    @Override
    public int getPositionOnBoard(){
        return super.getPositionOnBoard();
    }


        /*
        boolean playerOwnStreet = false;
        int numOfPlayers;

        // Paying rent
        if (owned){
            for (int i : playerC.getPlayerStreets(playerNum)){
                if (i == positionOnBoard)
                    playerOwnStreet = true;
            }

            // Who to pay rent to
            if (!playerOwnStreet){
                numOfPlayers = playerC.getNumOfPlayers();

                for (int newPlayerNum = 0 ; (newPlayerNum < numOfPlayers); newPlayerNum++){
                    for (int i : playerC.getPlayerStreets(newPlayerNum)){
                        if (i == positionOnBoard){
                            playerC.updatePlayerBalance(newPlayerNum, rent);
                            playerC.updatePlayerBalance(playerNum, -rent);
                        }
                    }
                }
            }
        }
        else if (!owned){

        }
        */


}
