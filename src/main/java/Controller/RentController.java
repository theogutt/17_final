
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

    public int getOwnableType(Ownable ownable) {
        int type = 0;
        if (ownable instanceof Street) {
            type = 1;
        } else if (ownable instanceof Ferry) {
            type = 2;
        } else if (ownable instanceof Brewery) {
            type = 3;
        }
        return type;
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

    public int getNumberOfFerries(PlayerController playerC, Ownable curOwnable, int ref) {
        int ferries = 0;
        Ownable[] playerOwnables = playerC.getPlayerOwnables(ref);
        for (int i = 0; i < playerOwnables.length; i++) {
            if (playerOwnables[i].getOwner() == curOwnable.getOwner() && playerOwnables[i] instanceof Ferry) {
                ferries++;
            }
        }
        return ferries;
    }

    public int getNumberOfBreweries(PlayerController playerC, Ownable curOwnable, int ref) {
        int breweries = 0;
        Ownable[] playerOwnables = playerC.getPlayerOwnables(ref);
        for (int i = 0; i < playerOwnables.length; i++) {
            if (playerOwnables[i].getOwner() == curOwnable.getOwner() && playerOwnables[i] instanceof Brewery) {
                breweries++;
            }
        }
        return breweries;
    }

    public boolean ownAll(PlayerController playerC, int ref, Ownable curOwnable) {
        boolean ownAll = false;
        int owned = 0;
        int groupID = curOwnable.getGroupID();
        Ownable[] playerOwnables = playerC.getPlayerOwnables(ref);
        int amountInGroup = 3;

        if ( groupID==1 || groupID==8 || groupID==10)
            amountInGroup = 2;
        if ( groupID==9 )
            amountInGroup = 4;

        for (int n=0 ; n < playerOwnables.length ; n++){
            if (playerOwnables[n].getGroupID() == groupID)
                owned++;
        }

        if (owned == amountInGroup)
            ownAll = true;

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

