package Controller;

import Model.Player;
import Model.Squares.*;
import Utilities.TextReader;
import View.GUI_Handler;

import java.io.IOException;
import java.util.HashMap;

public class GameBoard {

    private Square[] squares = new Square[40];
    private HashMap squarePrice;
    private HashMap StreetName;
    private HashMap groupID;
    private PlayerController PlayerC;

    public GameBoard() throws IOException {
        squarePrice = TextReader.textReader(".\\src\\Resources\\SquarePrice");
        StreetName = TextReader.textReader(".\\src\\Resources\\StreetName");
        groupID = TextReader.textReader(".\\src\\Resources\\groupID");
        instantiateSquares();
    }

    public void squareImpact(int ref, PlayerController playerC, GUI_Handler guiHandler, RentController rentC){
        int curPosition = playerC.getPosition(ref);
        Square curSquare = squares[curPosition];
        curSquare.landOn(playerC, ref, guiHandler, rentC);
    }
    public int getSquareOwner(int ref, PlayerController playerC){
        int curPosition = playerC.getPosition(ref);
        Square curSquare = squares[curPosition];
        int owner = curSquare.getOwner(ref);
        return owner;
    }
    public int getGroupID(int index) {
        return (Integer) groupID.get(index);
    }
    public int numberOfGroupIDs(int index){
        int numberOfGroupIDs=0;
        for(int i = 0; i<40; i++){
            if(index==getGroupID(i)){
                numberOfGroupIDs++;
            }
        }
        return numberOfGroupIDs;
    }
    public boolean ownAllID(PlayerController playerC, int squarePos){
        boolean ownAll;
        Square curSquare = squares[squarePos];
        int thisGroupID = curSquare.getGroupID(squarePos);
        int numOfIDs = numberOfGroupIDs(thisGroupID);
        int sameOwner=0;
        for(int i = 0; i<40; i++){
            Square otherSquares = squares[i];
            if(otherSquares.getOwner(squarePos)==curSquare.getOwner(squarePos)){
                sameOwner = +1;
            }
        }
        if(sameOwner==numOfIDs){ownAll=true;}
        else{ownAll=false;}
        return ownAll;
    }
    public int numOfOwned(PlayerController playerC, int ref){
            int curPosition = playerC.getPosition(ref);
            Square curSquare = squares[curPosition];
            int numOfOwned=0;
            for(int i = 0; i<40; i++){
                Square otherSquares = squares[i];
                if(otherSquares.getOwner(ref)==curSquare.getOwner(ref)){
                    numOfOwned = +1;
                }
            }
        return numOfOwned;
    }
// Opretter felter med pris og rent
    public void instantiateSquares() throws IOException {
        for (int i = 0; i < 40; i++) {
            if (i == 0){ squares[i]= new Start(i);}                                                                        //Start
            else if (i == 10 || i == 20 ){ squares[i]= new Parking(i);}                                                    //Parking
            else if (i == 30 ){ squares[i]= new GoToPrison(i);}                                                            //Jail
            else if (i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36) {squares[i]= new Chance(i);}            //Chance
            else if (i == 4 || i == 38){squares[i]= new Tax(i);}                                                           //Tax
            else if (i == 5 || i == 15 ||i == 25 ||i == 35) {squares[i] = new Ferry(i,4000,(String)StreetName.get(i), false, 99, (Integer)groupID.get(i));} //Ferry
            else if (i == 12 || i == 27){squares[i] = new Brewery(i,3000,(String)StreetName.get(i), false, 99, (Integer)groupID.get(i));}            //Brew
            else {squares[i]= new Street(i,(Integer)squarePrice.get(i),0,(String)StreetName.get(i),(Integer)groupID.get(i),false, 99); //Street
            }
        }
    }
    public boolean didPlayerPassStart(PlayerController playerC, int ref){
        boolean passedStartBool = passedStart(playerC, ref);
        return passedStartBool;
    }
    public boolean passedStart(PlayerController playerC, int ref){
        boolean passedStart = false;
        if (playerC.getOldPosition(ref) == 30 && playerC.getPosition(ref) == 10){
            // From GoToPrison to Prison
        }
        else if (playerC.getPlayerOldPosition(ref)>playerC.getPosition(ref)){
            playerC.updatePlayerBalance(ref,4000);
            passedStart = true;
        }
        return passedStart;
    }

    public Square getSquare(int i){
        return squares[i];
    }
    public void changeBuildning(int numOfBuildnings){

    }
}
