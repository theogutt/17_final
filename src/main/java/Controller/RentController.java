
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

        public int retrieveRent (PlayerController playerC,int ref, Ownable curOwnable){
            int rent=0;
            int position = playerC.getPosition(ref);
            int ownableType = getOwnableType(curOwnable);
            if(ownableType==1) {
                int buildings=curOwnable.getNumOfBuildings();
                if (buildings == 1) {
                    rent = (Integer) oneHouseRent.get(position);
                } else if (buildings == 2) {
                    rent = (Integer) twoHouseRent.get(position);
                } else if (buildings == 3) {
                    rent = (Integer) threeHouseRent.get(position);
                } else if (buildings == 4) {
                    rent = (Integer) fourHouseRent.get(position);
                } else if (buildings == 5) {
                    rent = (Integer) hotelRent.get(position);
                } else {
                    if (ownAll(playerC, ref, curOwnable)) {
                        rent = (Integer) baseRent.get(position) * 2;
                    } else {
                        rent = (Integer) baseRent.get(position);

                    }
                }
            }
            else if(ownableType==3){
                if (getNumberOfBreweries(playerC, curOwnable) == 1) {
                    rent = (playerC.getPosition(ref)-playerC.getOldPosition(ref)) * 100;
                } else if (getNumberOfBreweries(playerC, curOwnable) == 2) {
                    rent = (playerC.getPosition(ref)-playerC.getOldPosition(ref)) * 200;
                }
            }
            else if(ownableType==2){
                if (getNumberOfFerries(playerC, curOwnable) == 1) {
                    rent = (Integer) baseRent.get(position);
                }
                //to færger
                else if (getNumberOfFerries(playerC, curOwnable) == 2) {
                    rent = (Integer) baseRent.get(position) * 2;
                }
                //tre færger
                else if (getNumberOfFerries(playerC, curOwnable) == 3) {
                    rent = (Integer) baseRent.get(position) * 4;
                }
                //fire færger
                else if (getNumberOfFerries(playerC, curOwnable) == 4) {
                    rent = (Integer) baseRent.get(position) * 8;
                }
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
}

