//*******************************************************************
// Chance.java       Author: Gruppe 17
//
// Repræsenterer et chancekort felt og chancekortene
//*******************************************************************

package Model.Squares;


import Controller.PlayerController;
import View.GUI_Handler;
import Controller.RentController;

public class Chance extends Square{
    private static int[] chanceCards = new int[28];

    public Chance(int positionOnBoard) {
        super(positionOnBoard);
        intantiateCards();
    }

    // Aktiverer det næste chancekort og dets effect
    public void landOn(PlayerController playerC, int playerNum, GUI_Handler gui_handler, RentController rentC){
        int card = chanceCards[0];
        int oldPos = playerC.getPosition(playerNum);
        Ownable[] playerOwnabels = playerC.getPlayerOwnables(playerNum);


        switch (card){
            case 0: // Get 3.000 kr.
                playerC.updatePlayerBalance(playerNum, 3000);
                break;

            case 1: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                break;

            case 2: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                break;

            case 3: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                break;

            case 4: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                break;

            case 5: // Lose 200 kr.
                playerC.updatePlayerBalance(playerNum, -200);
                break;

            case 6: // Lose 200 kr.
                playerC.updatePlayerBalance(playerNum,-200);
                break;

            case 7: // Lose 1.000 kr.
                playerC.updatePlayerBalance(playerNum, -1000);
                break;

            case 8: // Lose 3.000 kr.
                playerC.updatePlayerBalance(playerNum,-3000);
                break;

            case 9: // Get 200 kr.
                playerC.updatePlayerBalance(playerNum,200);
                break;

            case 10: // Lose 3.000 kr.
                playerC.updatePlayerBalance(playerNum,-3000);
                break;

            case 11: // Lose 1.000 kr.
                playerC.updatePlayerBalance(playerNum,-1000);
                break;

            case 12: // Birthday.
                int payingPlayer = 0;
                playerC.updatePlayerBalance(playerNum, (playerC.getNumOfPlayers()-1)*200);
                while (payingPlayer < playerC.getNumOfPlayers()){
                    if (payingPlayer != playerNum)
                        playerC.updatePlayerBalance(payingPlayer, -200);
                    payingPlayer++;
                }
                break;

            case 13: // Get 40.000 if fortune < 15.000.
                if (playerC.getPlayerFortune(playerNum) < 15000)
                    playerC.updatePlayerBalance(playerNum, 40000);
                break;

            case 14: // Move to nearest brewery.
                if (playerC.getPosition(playerNum) > 12 && playerC.getPosition(playerNum) < 28)
                    playerC.setPosition(28, playerNum);
                else
                    playerC.setPosition(12, playerNum);
                break;

            case 15: // Move to nearest brewery
                if (playerC.getPosition(playerNum) > 12 && playerC.getPosition(playerNum) < 28)
                    playerC.setPosition(28, playerNum);
                else
                    playerC.setPosition(12, playerNum);
                break;

            case 16: // Move to Rådhuspladsen.
                playerC.setPosition(39, playerNum);
                break;

            case 17: // Pay for houses and hotels.
                for (int i = 0 ; playerOwnabels.length > i ; i++) {
                    if (playerOwnabels[i].getNumOfBuildings() == 5)
                        playerC.updatePlayerBalance(playerNum, -2000);
                    else
                        playerC.updatePlayerBalance(playerNum, -500 * playerOwnabels[i].getNumOfBuildings());
                }
                break;

            case 18: // Pay more for houses and hotels.
                for (int i = 0 ; playerOwnabels.length > i ; i++) {
                    if (playerOwnabels[i].getNumOfBuildings() == 5)
                        playerC.updatePlayerBalance(playerNum, -2300);
                    else
                        playerC.updatePlayerBalance(playerNum, -800 * playerOwnabels[i].getNumOfBuildings());
                }
                break;

            case 19: // Jailcard.
                playerC.setJailCard(playerNum, true);
                break;

            case 20: // Jailcard.
                playerC.setJailCard(playerNum, true);
                break;

            case 21: // Move 3 squares back.
                int newPosition;
                newPosition = playerC.getPosition(playerNum)-3;
                if (newPosition < 0)
                    playerC.setPosition(newPosition + 40, playerNum);
                else
                    playerC.setPosition(newPosition, playerNum);
                break;

            case 22: // Move to start.
                playerC.setPosition(0, playerNum);
                break;

            case 23: // Go to prison.
                playerC.setInJail(playerNum,true);
                playerC.setPosition(10,playerNum);
                break;

            case 24: // Go to prison.
                playerC.setInJail(playerNum,true);
                playerC.setPosition(10,playerNum);
                break;

            case 25: // Move to Grønningen.
                playerC.setPosition(24, playerNum);
                break;

            case 26: // Move to LB-ferry.
                playerC.setPosition(5,playerNum);
                break;

            case 27: // Move to Frederiksberg Alle.
                playerC.setPosition(11,playerNum);
                break;
        }
        // Tjekker om spilleren er passeret start, og giver penge hvis de er
        if (oldPos > playerC.getPosition(playerNum) && card != 23 && card != 24)
            playerC.updatePlayerBalance(playerNum,4000);
        gui_handler.guiChance(card, playerC);
        leftShiftCards();
    }

    // Sætter alle chancekort i dækket én gang til venstre (og sætter det øverste kort nederst)
    private void leftShiftCards(){
        int[] leftShifted = new int[chanceCards.length];
        for (int number = 0; number < chanceCards.length; number++) {
            int j = (number + 1) % chanceCards.length; // Når vi når enden af dækket, sættes det sidste kort forrest
            leftShifted[number] = chanceCards[j];
        }
        chanceCards = leftShifted;
    }

    // Laver et dæk af chanckort (int array) og blander det
    private void intantiateCards(){
        chanceCards = new int[chanceCards.length]; // Resetter chancecards, da den er static
        int[] cards = new int[chanceCards.length];
        int pos;

        // Her laves et sæt kort
        for (int i = 0; i < cards.length ; i++) {
            cards[i] = i;
        }

        // Her blandes kortsættet
        for (int card = 0; card < chanceCards.length; card++) {
            do {
                pos = (int) (Math.random() * chanceCards.length);
            } while(chanceCards[pos] != 0);

            chanceCards[pos] = cards[card];
        }
    }
}
