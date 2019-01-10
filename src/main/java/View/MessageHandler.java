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
    public String turnMessage(PlayerController playerC, int ref, String kindOfSquare) {
        String playerMessage = playerC.getName(ref) + getSquareMessage(Integer.parseInt(kindOfSquare));
        return playerMessage;
    }
    public String getSquareMessage(int index) {
        return (String) hashMapTurnMessages.get(index);
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
        String playerMessage = getSquareMessage(Integer.parseInt(messageNum));
        return playerMessage;
    }
    public String playerTurn(PlayerController playerC, int i) {
        returnString = "Det er " + playerC.getName(i) + "'s tur! Tryk enter for at kaste terningerne!";
        return returnString;
    }
}
