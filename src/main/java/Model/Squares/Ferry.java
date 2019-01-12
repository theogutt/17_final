package Model.Squares;

public class Ferry extends Ownable{
    private boolean owned;
    private int price;
    public Ferry(int positionOnBoard, int price, boolean owned) {
        super(positionOnBoard);
        this.price = price;
        this.owned = owned;
    }

    public int getPrice() {
        return price;
    }
}
