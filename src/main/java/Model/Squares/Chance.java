package Model.Squares;


import Controller.PlayerController;
import View.GUI_Handler;
import Controller.RentController;

public class Chance extends Square{
    private int[] chanceCards = new int[27];
    private int[] chanceCards2 = new int[27];

    public Chance(int positionOnBoard) {
        super(positionOnBoard);
        intantiateCards();
    }

    public int landOn(PlayerController playerC, int playerNum, GUI_Handler gui_handler, RentController rentC){
        int card = chanceCards[0];
        int returnInt = -1;

        switch (card-1){
            case 0: // Get 3.000 kr.
                playerC.updatePlayerBalance(playerNum, 3000);
                returnInt = 0;
                break;

            case 1: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                returnInt = 1;
                break;

            case 2: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                returnInt = 2;
                break;

            case 3: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                returnInt = 3;
                break;

            case 4: // Get 1.000 kr.
                playerC.updatePlayerBalance(playerNum, 1000);
                returnInt = 4;
                break;

            case 5: // Lose 200 kr.
                playerC.updatePlayerBalance(playerNum, -200);
                returnInt = 5;
                break;

            case 6: // Lose 200 kr.
                playerC.updatePlayerBalance(playerNum,-200);
                returnInt = 6;
                break;

            case 7: // Lose 1.000 kr.
                playerC.updatePlayerBalance(playerNum, -1000);
                returnInt = 7;
                break;

            case 8: // Lose 3.000 kr.
                playerC.updatePlayerBalance(playerNum,-3000);
                returnInt = 8;
                break;

            case 9: // Get 200 kr.
                playerC.updatePlayerBalance(playerNum,200);
                returnInt = 9;
                break;

            case 10: // Lose 3.000 kr.
                playerC.updatePlayerBalance(playerNum,-3000);
                returnInt = 10;
                break;

            case 11: // Lose 1.000 kr.
                playerC.updatePlayerBalance(playerNum,-1000);
                returnInt = 11;
                break;

            case 12: // Birthday.
                int payingPlayer = 0;
                playerC.updatePlayerBalance(playerNum, (playerC.getNumOfPlayers()-1)*200);
                while (payingPlayer < playerC.getNumOfPlayers()){
                    if (payingPlayer != playerNum)
                        playerC.updatePlayerBalance(payingPlayer, -200);
                    payingPlayer++;
                }
                returnInt = 12;
                break;

            case 13: // Get 40.000 if balance < 3.000.
                if (playerC.getBalance(playerNum) < 3000){
                    playerC.updatePlayerBalance(playerNum, 40000);
                }
                returnInt = 13;
                break;

            case 14: // Move to nearest brewery.
                if (playerC.getPosition(playerNum) > 12 && playerC.getPosition(playerNum) < 28){
                    playerC.setPosition(playerNum, 28);
                }
                else{
                    playerC.setPosition(playerNum, 12);
                }
                returnInt = 14;
                break;

            case 15: // Move to nearest brewery
                if (playerC.getPosition(playerNum) > 12 && playerC.getPosition(playerNum) < 28){
                    playerC.setPosition(playerNum, 28);
                }
                else{
                    playerC.setPosition(playerNum, 12);
                }
                returnInt = 15;
                break;

            case 16: // Move to Rådhuspladsen.
                playerC.setPosition(playerNum, 39);
                returnInt = 16;
                break;

            case 17: // Pay for houses and hotels.
                returnInt = 17;
                break;

            case 18: // Pay more for houses and hotels.
                returnInt = 18;
                break;

            case 19: // Jailcard.
                playerC.setJailCard(playerNum, true);
                returnInt = 19;
                break;

            case 20: // Jailcard.
                playerC.setJailCard(playerNum, true);
                returnInt = 20;
                break;

            case 21: // Move 3 squares back.
                int newPosition;
                newPosition = playerC.getPosition(playerNum)-3;
                if (newPosition < 0){
                    playerC.setPosition(playerNum, newPosition + 40);
                }
                else{
                    playerC.setPosition(playerNum, newPosition);
                }
                returnInt = 21;
                break;

            case 22: // Move to start.
                playerC.setPosition(playerNum, 0);
                returnInt = 22;
                break;

            case 23: // Go to prison.
                playerC.setInJail(playerNum,true);
                playerC.setPosition(playerNum,10);
                returnInt = 23;
                break;

            case 24: // Go to prison.
                playerC.setInJail(playerNum,true);
                playerC.setPosition(playerNum,10);
                returnInt = 24;
                break;

            case 25: // Move to Grønningen.
                playerC.setPosition(playerNum, 24);
                returnInt = 25;
                break;

            case 26: // Move to LB-ferry.
                playerC.setPosition(playerNum,5);
                returnInt = 26;
                break;

            case 27: // Move to Frederiksberg Alle.
                playerC.setPosition(playerNum,11);
                returnInt = 27;
                break;

        }
        mixCards();
        return returnInt;
    }


    public void mixCards(){
        int[] leftShifted = new int[chanceCards.length];
        for (int number = 0; number < chanceCards.length; number++) {
            int j = (number + 1) % chanceCards.length;
            leftShifted[number] = chanceCards[j];
        }
        chanceCards = leftShifted;
    }
    public void intantiateCards(){
        for (int i = 1; i <= chanceCards.length ; i++) {
            chanceCards[i-1] = i;
        }

        for (int j = 0; j < chanceCards.length; j++) {
            int rand = (int) (Math.random() * chanceCards.length);

            while(chanceCards2[rand] != 0){
                rand = (int) (Math.random() * chanceCards.length);
            }
            chanceCards2[rand] = chanceCards[j];
        }
        for (int k = 0; k < chanceCards.length; k++) {
            chanceCards[k] = chanceCards2[k];
        }
    }

    public int[] getChanceCards() {
        return chanceCards;
    }

    public void setChanceCards(int[] chanceCards) {
        this.chanceCards = chanceCards;
    }
}
