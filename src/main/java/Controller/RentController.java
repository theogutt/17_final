package Controller;

import static Controller.GameBoard.squares;

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

    public void getStreetRent() {
        // int rent = 0;
        //for (int i = 0; 1 < squares.length; i++) {
        //    if (squares[i].getPositionOnBoard() == 1 || 3) ;
        //     rent = 50;
        squares[1].setRent(50);
        squares[3].setRent(50);
        squares[6].setRent(100);
        squares[8].setRent(100);
        squares[9].setRent(150);
        squares[11].setRent(200);
        squares[13].setRent(200);
        squares[14].setRent(250);
        squares[16].setRent(300);
        squares[18].setRent(300);
        squares[19].setRent(350);
        squares[21].setRent(350);
        squares[23].setRent(350);
        squares[24].setRent(400);
        squares[26].setRent(450);
        squares[27].setRent(450);
        squares[29].setRent(500);
        squares[31].setRent(550);
        squares[32].setRent(550);
        squares[34].setRent(600);
        squares[37].setRent(700);
        squares[39].setRent(1000);

        if (squares[1].getOwned() && squares[3].getOwned()) {
            squares[1].setRent(100);
            squares[3].setRent(100);
        }
        if (squares[6].getOwned() && squares[8].getOwned() && squares[9].getOwned()) {
            squares[6].setRent(200);
            squares[8].setRent(200);
            squares[9].setRent(200);
        }
        if (squares[11].getOwned() && squares[13].getOwned() && squares[14].getOwned()) {
            squares[11].setRent(400);
            squares[13].setRent(400);
            squares[14].setRent(500);
        }
        if (squares[16].getOwned() && squares[18].getOwned() && squares[19].getOwned()) {
            squares[16].setRent(600);
            squares[18].setRent(600);
            squares[19].setRent(700);
        }
        if (squares[21].getOwned() && squares[23].getOwned() && squares[24].getOwned()) {
            squares[21].setRent(700);
            squares[23].setRent(700);
            squares[24].setRent(800);
        }
        if (squares[26].getOwned() && squares[27].getOwned() && squares[29].getOwned()) {
            squares[26].setRent(900);
            squares[27].setRent(900);
            squares[29].setRent(1000);
        }
        if (squares[31].getOwned() && squares[32].getOwned() && squares[34].getOwned()) {
            squares[31].setRent(1100);
            squares[32].setRent(1100);
            squares[34].setRent(1200);
        }
        if (squares[37].getOwned() && squares[39].getOwned()) {
            squares[37].setRent(1400);
            squares[39].setRent(2000);
        }
    }}