package Controller;
import Controller.PlayerController;

public class ChanceController {
    private int[] chanceCards = new int[12];
    private int[] chanceCards2 = new int[12];
    private int positionOnBoard;

    public ChanceController(int positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        intantiateCards();
    }

    public int landedOnChance(PlayerController playerC, int playerNum){
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

            case 15: // Move to Rådhuspladsen.
                playerC.setPosition(playerNum, 39);
                returnInt = 15;
                break;

            case 16: // Pay for houses and Hotels
                returnInt = 16;
                break;

            case 17: // Jailcard.
                playerC.setJailCard(playerNum, true);
                returnInt = 17;
                break;



        }
        return returnInt;
    }


    public void mixCards(){
        //chanceCards[chanceCards.length-1] = chanceCards[0];
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

    public int[] getChanceCards2() {
        return chanceCards2;
    }

    public void setChanceCards(int[] chanceCards) {
        this.chanceCards = chanceCards;
    }

}
