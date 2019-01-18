package View;

import Controller.PlayerController;
import Utilities.TextReader;

import java.io.IOException;
import java.util.HashMap;

public class MessageHandler {
    private HashMap hashMapTurnMessages;
    private String returnString;

    public MessageHandler() throws IOException {
        hashMapTurnMessages = (TextReader.textReader(".\\src\\Resources\\TurnMessages"));
    }
    public String messageSquare(PlayerController playerC, int ref) {
        returnString = playerC.getName(ref) + getSquareMessage(0);
        return returnString;
    }
    public String turnMessage(PlayerController playerC, int ref, String kindOfSquare) {
        return playerC.getName(ref) + getSquareMessage(Integer.parseInt(kindOfSquare));
    }
    public String getSquareMessage(int index) {
        return (String) hashMapTurnMessages.get(index);
    }
    public String gotBroke(PlayerController playerC, int i) {
        returnString = turnMessage(playerC, i, "28");
        return returnString;
    }

    public String startGame1() {
        return getSquareMessage(996);
    }
    public String startGame2() {
        return getSquareMessage(997);
    }
    public String startGame3() {
        return getSquareMessage(998);
    }
    public String startGame4() {
        return getSquareMessage(999);
    }

    public String gameMessage(String messageNum){
        return getSquareMessage(Integer.parseInt(messageNum));
    }

    public String playerTurn(PlayerController playerC, int i) {
        returnString = "Det er " + playerC.getName(i) + "'s tur! Tryk enter for at kaste terningerne!";
        return returnString;
    }
    public String playerWon(PlayerController playerC, int i) {
        returnString = playerC.getName(i) + " har vundet spillet! Med et beløb på " + playerC.getBalance(i);
        return returnString;
    }
    public String notAllID(){
        returnString = "Du ejer ikke alle felter i denne farve.";
        return returnString;
    }
}
