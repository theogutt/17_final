
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

    private int getOwnableType(Ownable ownable) {
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

        public int retrieveRent (PlayerController playerC,int ref , Ownable curOwnable){
            int rent=0;
            int position = playerC.getPosition(ref);
            int ownableType = getOwnableType(curOwnable);
            int homeOwner = curOwnable.getOwner();
            if(ownableType==1) {
                int buildings=curOwnable.getNumOfBuildings();
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
                    if (ownAll(playerC, homeOwner, curOwnable)) {
                        rent = baseRent(position) * 2;
                    } else {
                        rent = baseRent(position);

                    }
                }
            }
            else if(ownableType==3){
                        //Slaget der er slået * Rent   * (1 || 2)
                rent = (playerC.getPosition(ref)-playerC.getOldPosition(ref)) * 100 * getNumberOfBreweries(playerC, curOwnable);
            }
            else if(ownableType==2){
                //           250 * 2^(antalFærger) = altidDetRigtigeSvar
                rent = (int)(250 * Math.pow(2,getNumberOfFerries(playerC, curOwnable)));
            }
                return rent;
        }

    private int getNumberOfFerries(PlayerController playerC, Ownable curOwnable) {
        int ferries = 0;
        Ownable[] playerOwnables = playerC.getPlayerOwnables(curOwnable.getOwner());
        for (int i = 0; i < playerOwnables.length; i++) {
            if (playerOwnables[i] instanceof Ferry) {
                ferries++;
            }
        }
        return ferries;
    }

    private int getNumberOfBreweries(PlayerController playerC, Ownable curOwnable) {
        int breweries = 0;
        Ownable[] playerOwnables = playerC.getPlayerOwnables(curOwnable.getOwner());
        for (int i = 0; i < playerOwnables.length; i++) {
            if (playerOwnables[i] instanceof Brewery) {
                breweries++;
            }
        }
        return breweries;
    }

    private boolean ownAll(PlayerController playerC, int ref, Ownable curOwnable) {
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
        return (owned == amountInGroup);
    }



    private int getRentInt0 ( int index){
        return (Integer) baseRent.get(index);
    }
    private int getRentInt1 ( int index){
        return (Integer) oneHouseRent.get(index);
    }
    private int getRentInt2 ( int index){
        return (Integer) twoHouseRent.get(index);
    }
    private int getRentInt3(int index){
        return (Integer) threeHouseRent.get(index);
    }
    private int getRentInt4(int index){
        return (Integer) fourHouseRent.get(index);
    }
    private int getRentInt5(int index){
        return (Integer) hotelRent.get(index);
    }

    private int baseRent(int position){
        return getRentInt0(position);
    }
    private int oneHouseRent(int position){
        return getRentInt1(position);
    }
    private int twoHouseRent(int position){
        return getRentInt2(position);
    }
    private int threeHouseRent(int position){
        return getRentInt3(position);
    }
    private int fourHouseRent(int position){
        return getRentInt4(position);
    }
    private int HotelRent(int position){
        return getRentInt5(position);
    }
}

