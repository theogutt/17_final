package Controller;

public class RentController {
    private GameEngine engine;

    public int getFerryRent(){

        //Skal tjekke hvor mange færger spiller x har

        int numbersOfOwnedFerrys =
        this.rent = (int)(250 * Math.pow(2,numbersOfOwnedFerrys));
        return rent;

    }

    public int getBreweryRent() {

        //Skal tjekke hvor mange redderier spiller x har

        int numberOfBrewerys =
        int facevalueSum = engine.getDie1().getFaceValue() + engine.getDie2().getFaceValue();
        int rent = facevalueSum * 100 * numberOfBrewerys;
        return rent;
    }

    //Skal også have en metode, der udregner husleje på Streets

}
