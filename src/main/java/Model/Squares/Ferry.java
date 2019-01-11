package Model.Squares;


public class Ferry extends Ownable{

    public Ferry(int positionOnBoard, int price, int rent, boolean owned){
        super(positionOnBoard, price, rent, owned);
    }

// Ændrer leje i forhold til antal færger
    public void changeRent(int numbersOfOwnedFerrys){

        this.rent = (int)(250 * Math.pow(2,numbersOfOwnedFerrys));
    }

    @Override
    public int landOn(){
        return -1;
    }
}
