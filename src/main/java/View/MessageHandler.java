package View;

import Utilities.TextReader;

import java.io.IOException;
import java.util.HashMap;

public class MessageHandler {
    private HashMap hashMapTurnMessages;
    private String returnString;

    public MessageHandler() throws IOException {
        hashMapTurnMessages = (TextReader.textReader(".\\src\\Resources\\TurnMessages"));
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
}
