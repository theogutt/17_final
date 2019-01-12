package Model.Squares;

public class Brewery extends Ownable{
    private boolean owned;
    private int price;
    public Brewery(int positionOnBoard, int price, boolean owned) {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
    }

    public int getPrice() {
        return price;
    }
}