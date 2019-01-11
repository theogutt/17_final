/*
package Controller;
import Model.Squares.Square;
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
    private Square[] squares = new Square[40];

    public RentController() throws IOException {
        oneHouseRent = TextReader.textReader(".\\src\\Resources\\1HouseRent");
        twoHouseRent = TextReader.textReader(".\\src\\Resources\\2HouseRent");
        threeHouseRent = TextReader.textReader(".\\src\\Resources\\3HouseRent");
        fourHouseRent = TextReader.textReader(".\\src\\Resources\\4HouseRent");
        hotelRent = TextReader.textReader(".\\src\\Resources\\HotelRent");
    }

    public void payRent(PlayerController playerC, int ref){
        int rent = retrieveRent(playerC, ref);
        playerC.updatePlayerBalance(ref, rent*-1);
        int position = playerC.getPosition(ref);
        int owner=squares[position].getOwner();
        playerC.updatePlayerBalance(owner, rent);
    }

    public int retrieveRent(PlayerController playerC, int ref) {
        int position = playerC.getPosition(ref);
        int buildings = squares[position].getNumOfBuildings();
        switch (buildings) {
            case 1:
               return oneHouseRent(position);
                break;
            case 2:
               return twoHouseRent(position);
                break;
            case 3:
                return threeHouseRent(position);
                break;
            case 4:
               return fourHouseRent(position);
                break;
            default:
               return HotelRent(position);
        }
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
*/