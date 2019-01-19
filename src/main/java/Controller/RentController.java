//*******************************************************************
// RentController.java       Author: Gruppe 17
//
// Udregner lejen for en bestemt grund
//*******************************************************************

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

    // Laver HashMaps af de forskellige filer som viser leje for grunde
    public RentController() throws IOException {
        baseRent = TextReader.textReader(".\\src\\Resources\\BaseRent");
        oneHouseRent = TextReader.textReader(".\\src\\Resources\\1HouseRent");
        twoHouseRent = TextReader.textReader(".\\src\\Resources\\2HousesRent");
        threeHouseRent = TextReader.textReader(".\\src\\Resources\\3HousesRent");
        fourHouseRent = TextReader.textReader(".\\src\\Resources\\4HousesRent");
        hotelRent = TextReader.textReader(".\\src\\Resources\\HotelRent");
    }

    // Finder lejen for et felt som kan ejes, baseret på hvilken type det er
    public int retrieveRent(PlayerController playerC, int ref, Ownable curOwnable) {
        int rent = 0;
        int position = playerC.getPosition(ref);
        int homeOwner = curOwnable.getOwner();

        // Hvis feltet er en grund
        if (curOwnable instanceof Street) {
            int buildings = curOwnable.getNumOfBuildings();
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
                if (ownAll(playerC, homeOwner, curOwnable)) {
                    rent = (Integer) baseRent.get(position) * 2;
                } else {
                    rent = (Integer) baseRent.get(position);

                }
            }

            // Hvis feltet er et bryggeri
        } else if (curOwnable instanceof Brewery) {
            // Udregner først hvad spilleren har rullet
            int playerRoll = playerC.getPosition(ref) - playerC.getOldPosition(ref);
            if (playerRoll < 0)
                playerRoll = playerRoll + 40; // Hvis spiller har passeret start

            // Slaget der er slået * Rent   * (1 || 2)
            rent = playerRoll * 100 * getNumberOfBreweries(playerC, curOwnable);

            // Hvis feltet er en færge
        } else if (curOwnable instanceof Ferry) {
            // 500(færgeleje) * 2^(antalFærger-1)
            rent = ((Integer) baseRent.get(position) * (int) Math.pow(2, (getNumberOfFerries(playerC, curOwnable)) - 1));
        }
        return rent;
    }

    // Tjekker hvor mange færge den spiller som ejer feltet ellers ejer
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

    // Tjekker hvor mange bryggerier den spiller som ejer feltet ellers ejer
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

    // Tjekker om en spiller ejer alle grunde af samme gruppeID (fx farve) og returnerer en boolean
    private boolean ownAll(PlayerController playerC, int ref, Ownable curOwnable) {
        int owned = 0;
        int groupID = curOwnable.getGroupID();
        Ownable[] playerOwnables = playerC.getPlayerOwnables(ref);
        int amountInGroup = 3;

        if (groupID == 1 || groupID == 8 || groupID == 10)
            amountInGroup = 2;
        if (groupID == 9)
            amountInGroup = 4;

        for (int n = 0; n < playerOwnables.length; n++) {
            if (playerOwnables[n].getGroupID() == groupID)
                owned++;
        }
        return (owned == amountInGroup);
    }
}

