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

    //Siger at en spiller får 4.000 kr. for lande eller passere start
    public String messageSquare(PlayerController playerC, int ref) {
        returnString = playerC.getName(ref) + getSquareMessage(0);
        return returnString;
    }

    //Giver spillerens navn og en besked
    public String turnMessage(PlayerController playerC, int ref, String kindOfSquare) {
        return playerC.getName(ref) + getSquareMessage(Integer.parseInt(kindOfSquare));
    }


    //Siger at en spiller er gået fallit
    public String gotBroke(PlayerController playerC, int i) {
        returnString = turnMessage(playerC, i, "28");
        return returnString;
    }

    //Disse forklare spillets regler
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


    //Retunere en besked
    public String gameMessage(String messageNum){
        return getSquareMessage(Integer.parseInt(messageNum));
    }

    //Siger hvilken spillers tur det
    public String playerTurn(PlayerController playerC, int i) {
        returnString = "Det er " + playerC.getName(i) + "'s tur! Tryk enter for at kaste terningerne!";
        return returnString;
    }

    //Siger hvilken spiller, der har vundet
    public String playerWon(PlayerController playerC, int i) {
        returnString = playerC.getName(i) + " har vundet spillet! Med en total værdi på " + playerC.getPlayerFortune(i) + "kr!!!";
        return returnString;
    }

    //Fortæller at en spiller ikke ejen alle ejendomme af samme farve
    public String notAllID(){
        returnString = "Du ejer ikke alle felter i denne farve.";
        return returnString;
    }
    public String taxes(PlayerController playerC, int i, int tax){
        returnString = playerC.getName(i) + " har betalt " + tax + "kr. i skat";
        return returnString;
    }

    //Getter en besked fra hashmappet TurnMessages
    public String getSquareMessage(int index) {
        return (String) hashMapTurnMessages.get(index);
    }
}
