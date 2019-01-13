
package Controller;
import Model.Squares.Ownable;
import Model.Squares.Square;
import Model.Squares.Street;
import Utilities.TextReader;

import java.io.IOException;
import java.util.HashMap;

public class RentController {
    private PlayerController playerC;
    private GameBoard gameBoard;
    private HashMap oneHouseRent;
    private HashMap twoHouseRent;
    private HashMap threeHouseRent;
    private HashMap fourHouseRent;
    private HashMap hotelRent;
    private HashMap baseRent;
    Square[] squares = new Square[40];
    private Street street;

    public RentController() throws IOException {
        baseRent = TextReader.textReader(".\\src\\Resources\\BaseRent");
        oneHouseRent = TextReader.textReader(".\\src\\Resources\\1HouseRent");
        twoHouseRent = TextReader.textReader(".\\src\\Resources\\2HousesRent");
        threeHouseRent = TextReader.textReader(".\\src\\Resources\\3HousesRent");
        fourHouseRent = TextReader.textReader(".\\src\\Resources\\4HousesRent");
        hotelRent = TextReader.textReader(".\\src\\Resources\\HotelRent");
    }

    public void payRent(PlayerController playerC, int ref){
        int rent = retrieveRent(playerC, ref);
        playerC.updatePlayerBalance(ref, rent*-1);
        int position = playerC.getPosition(ref);
       // int owner=squares[position].getOwner();
        //playerC.updatePlayerBalance(owner, rent);
    }

    public int retrieveRent(PlayerController playerC, int ref) {
        int position = playerC.getPosition(ref);
        //indsæt getnumberofbuildings når den virker
        int buildings =0;
        int rent;
        if(buildings==1){rent=oneHouseRent(position);}
        else if(buildings==2){rent=twoHouseRent(position);}
        else if(buildings==3){rent=threeHouseRent(position);}
        else if(buildings==4){rent=fourHouseRent(position);}
        else if(buildings==5){rent=HotelRent(position);}
        else{rent=baseRent(position);}
        return rent;
    }
     public int getRentInt0(int index) {
        return (Integer) baseRent.get(index);
    }
    public int getRentInt1(int index) {
        return (Integer) oneHouseRent.get(index);
    }
    public int getRentInt2(int index) {
        return (Integer) twoHouseRent.get(index);
    }
    public int getRentInt3(int index) {
        return (Integer) threeHouseRent.get(index);
    }
    public int getRentInt4(int index) {
        return (Integer) fourHouseRent.get(index);
    }
    public int getRentInt5(int index) {
        return (Integer) hotelRent.get(index);
    }

    public int baseRent(int position){
        return getRentInt0(position);
    }
    public int oneHouseRent(int position){
        return getRentInt1(position);
    }
    public int twoHouseRent(int position){
        return getRentInt2(position);
    }
    public int threeHouseRent(int position){
        return getRentInt3(position);
    }
    public int fourHouseRent(int position){
        return getRentInt4(position);
    }
    public int HotelRent(int position){
        return getRentInt5(position);
    }
}
