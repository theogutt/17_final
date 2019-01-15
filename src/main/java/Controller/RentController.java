
package Controller;
import Model.Squares.*;
import Utilities.TextReader;

import java.io.IOException;
import java.util.HashMap;

public class RentController {
    private PlayerController playerC;
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

    public int getOwnableType(int position, GameBoard gameBoard) {
        int type=0;
        if (gameBoard.getSquare(position) instanceof Street) {
            type=1;
        }
        else if(gameBoard.getSquare(position) instanceof Ferry){
            type=2;
        }
        else if(gameBoard.getSquare(position) instanceof Brewery){
            type=3;
        }
        return type;
    }

        public void payRent (PlayerController playerC,int ref, GameBoard gameBoard){
            if(getOwnableType(playerC.getPosition(ref), gameBoard)==1) {
                int rent = retrieveRent(playerC, ref);
                for (int j = 0; j < playerC.getNumOfPlayers(); j++) {
                    if (playerC.getPlayerOwnables(j).contains(gameBoard.getSquare(playerC.getPosition(ref)))) {
                        playerC.updatePlayerBalance(ref, (-1 * rent));
                        playerC.updatePlayerBalance(j, rent);
                        break;
                    }
                }
            }
            else if(getOwnableType(playerC.getPosition(ref), gameBoard)==2){
                int rent = 0;
                int position = playerC.getPosition(ref);
                //en færge
                if (gameBoard.numOfOwned(playerC, ref) == 1) {
                    rent = baseRent(position);
                }
                //to færger
                else if (gameBoard.numOfOwned(playerC, ref) == 2) {
                    rent = baseRent(position) * 2;
                }
                //tre færger
                else if (gameBoard.numOfOwned(playerC, ref) == 3) {
                    rent = baseRent(position) * 4;
                }
                //fire færger
                else if (gameBoard.numOfOwned(playerC, ref) == 4) {
                    rent = baseRent(position) * 8;
                }
                for (int j = 0; j < playerC.getNumOfPlayers(); j++) {
                    if (playerC.getPlayerOwnables(j).contains(gameBoard.getSquare(playerC.getPosition(ref)))) {
                        playerC.updatePlayerBalance(ref, (-1 * rent));
                        playerC.updatePlayerBalance(j, rent);
                        break;
                    }
                }
            }
            else if(getOwnableType(playerC.getPosition(ref), gameBoard)==3){
                int rent = 0;
                if (gameBoard.numOfOwned(playerC, ref) == 1) {
                    rent = playerC.oldRollSum * 100;
                } else if (gameBoard.numOfOwned(playerC, ref) == 2) {
                    rent = playerC.oldRollSum * 200;
                }
                for (int j = 0; j < playerC.getNumOfPlayers(); j++) {
                    if (playerC.getPlayerOwnables(j).contains(gameBoard.getSquare(playerC.getPosition(ref)))) {
                        playerC.updatePlayerBalance(ref, (-1 * rent));
                        playerC.updatePlayerBalance(j, rent);
                        break;
                    }
                }
            }
        }

        public int retrieveRent (PlayerController playerC,int ref){
            int position = playerC.getPosition(ref);
            //indsæt getnumberofbuildings når den virker
            int buildings = 0;
            int rent = 0;
            if (buildings == 1) {
                rent = oneHouseRent(position);
            } else if (buildings == 2) {
                rent = twoHouseRent(position);
            } else if (buildings == 3) {
                rent = threeHouseRent(position);
            } else if (buildings == 4) {
                rent = fourHouseRent(position);
            } else if (buildings == 5) {
                rent = HotelRent(position);
            } else {
                    rent = baseRent(position);
            }
            return rent;
        }
        public int getRentInt0 ( int index){
            return (Integer) baseRent.get(index);
        }
        public int getRentInt1 ( int index){
            return (Integer) oneHouseRent.get(index);
        }
        public int getRentInt2 ( int index){
            return (Integer) twoHouseRent.get(index);
        }
        public int getRentInt3 ( int index){
            return (Integer) threeHouseRent.get(index);
        }
        public int getRentInt4 ( int index){
            return (Integer) fourHouseRent.get(index);
        }
        public int getRentInt5 ( int index){
            return (Integer) hotelRent.get(index);
        }

        public int baseRent ( int position){
            return getRentInt0(position);
        }
        public int oneHouseRent ( int position){
            return getRentInt1(position);
        }
        public int twoHouseRent ( int position){
            return getRentInt2(position);
        }
        public int threeHouseRent ( int position){
            return getRentInt3(position);
        }
        public int fourHouseRent ( int position){
            return getRentInt4(position);
        }
        public int HotelRent ( int position){
            return getRentInt5(position);
        }
    }

