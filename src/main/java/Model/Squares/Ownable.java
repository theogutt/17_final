package Model.Squares;

import Controller.PlayerController;

public abstract class Ownable extends Square {

    protected final int price;
    protected boolean owned;
    protected int rent;

    public Ownable(int positionOnBoard, int price, int rent, boolean owned){
        super(positionOnBoard);
        this.owned = owned;
        this.price = price;
        this.rent = rent;
    }

    @Override
    public abstract int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum);

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
}