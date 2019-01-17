
package Controller;
import Model.Squares.*;
import Utilities.TextReader;

import java.io.IOException;
import java.util.HashMap;

public class RentController {
    private HashMap oneHouseRent;
    private HashMap twoHouseRent;
    private HashMap threeHouseRent;
    private HashMap fourHouseRent;
    private HashMap hotelRent;
    private HashMap baseRent;

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
        public int getOwner(int position, GameBoard gameBoard){
            return gameBoard.getOwner(position);
        }

        public int retrieveRent (PlayerController playerC,int ref, GameBoard gameBoard){
            int rent=0;
            int position = playerC.getPosition(ref);
            if(getOwnableType(playerC.getPosition(ref), gameBoard)==1) {
                int buildings=getNumberOfBuildings(playerC, gameBoard, ref);
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
                    if (ownAll(playerC, ref, gameBoard)==true) {
                        rent = baseRent(position) * 2;
                    } else {
                        rent = baseRent(position);

                    }
                }
            }
            else if(getOwnableType(playerC.getPosition(ref), gameBoard)==3){
                if (getNumberOfBreweries(playerC, gameBoard, ref) == 1) {
                    rent = (playerC.getPosition(ref)-playerC.getOldPosition(ref)) * 100;
                } else if (getNumberOfBreweries(playerC, gameBoard, ref) == 2) {
                    rent = (playerC.getPosition(ref)-playerC.getPosition(ref)) * 200;
                }
            }
            else if(getOwnableType(playerC.getPosition(ref), gameBoard)==2){
                if (getNumberOfFerries(playerC, gameBoard, ref) == 1) {
                    rent = baseRent(position);
                }
                //to færger
                else if (getNumberOfFerries(playerC, gameBoard, ref) == 2) {
                    rent = baseRent(position) * 2;
                }
                //tre færger
                else if (getNumberOfFerries(playerC, gameBoard, ref) == 3) {
                    rent = baseRent(position) * 4;
                }
                //fire færger
                else if (getNumberOfFerries(playerC, gameBoard, ref) == 4) {
                    rent = baseRent(position) * 8;
                }
            }
                return rent;
        }

        public int getNumberOfFerries(PlayerController playerC, GameBoard gameBoard, int ref){
            int ferries=0;
            int pos = playerC.getPosition(ref);
            for(int i=0; i<40; i++) {
                if(gameBoard.getOwner(i)==getOwner(pos, gameBoard) && gameBoard.getSquare(i) instanceof Ferry){
                    ferries++;
                }
            }
            return ferries;
        }

        public int getNumberOfBreweries(PlayerController playerC, GameBoard gameBoard, int ref){
        int breweries=0;
            int pos = playerC.getPosition(ref);
            for(int i=0; i<40; i++) {
                if(gameBoard.getOwner(i)==getOwner(pos, gameBoard) && gameBoard.getSquare(i) instanceof Brewery){
                    breweries++;
            }
        }
        return breweries;
        }

        public int getNumberOfBuildings(PlayerController playerC,  GameBoard gameBoard, int ref){
        int pos = playerC.getPosition(ref);
        int numOfBuildings=gameBoard.getSquare(pos).getNumOfBuildings();
        return numOfBuildings;
        }

        public boolean ownAll(PlayerController playerC, int ref, GameBoard gameBoard){
            boolean ownAll = false;
            int pos = playerC.getPosition(ref);
            int groupID = gameBoard.getSquare(pos).getGroupID();
            int owned=0;
            for(int i = 0; i<40; i++){
                if(gameBoard.getSquare(i).getGroupID()==groupID && gameBoard.getSquare(i).getOwner()==getOwner(pos, gameBoard)){
                    owned++;
                }
            }
            int sameID=0;
            for(int i =0; i<40; i++){
                if(gameBoard.getSquare(i).getGroupID()==groupID){
                    sameID++;
                }
            }
            if(owned==sameID && owned!=0){
                ownAll = true;
            }
            return ownAll;
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

