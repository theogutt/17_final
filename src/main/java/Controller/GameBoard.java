package Controller;

import Model.Squares.*;
import Utilities.TextReader;
import View.GUI_Handler;

import java.io.IOException;
import java.util.HashMap;

public class GameBoard {

    public static Square[] squares = new Square[40];
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

    public int getOwner(int position){
        Square curSquare = squares[position];
        return curSquare.getOwner();
    }

    public void squareImpact(int ref, PlayerController playerC, GUI_Handler guiHandler, RentController rentC, GameBoard gameBoard){
        int curPosition = playerC.getPosition(ref);
        Square curSquare = squares[curPosition];
        curSquare.landOn(playerC, ref, guiHandler, rentC, gameBoard);
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

// Opretter felter med pris og rent
    public void instantiateSquares() throws IOException {
        for (int i = 0; i < 40; i++) {
            if (i == 0){ squares[i]= new Start(i);}                                                                        //Start
            else if (i == 10 || i == 20 ){ squares[i]= new Parking(i);}                                                    //Parking
            else if (i == 30 ){ squares[i]= new GoToPrison(i);}                                                            //Jail
            else if (i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36) {squares[i]= new Chance(i);}            //Chance
            else if (i == 4 || i == 38){squares[i]= new Tax(i);}                                                           //Tax
            else if (i == 5 || i == 15 ||i == 25 ||i == 35) {squares[i] = new Ferry(i,4000,0,(String)StreetName.get(i),(Integer)groupID.get(i), false, 98);} //Ferry
            else if (i == 12 || i == 28){squares[i] = new Brewery(i,3000,0,(String)StreetName.get(i), (Integer)groupID.get(i), false, 98);}            //Brew
            else {squares[i]= new Street(i,(Integer)squarePrice.get(i),0,(String)StreetName.get(i),(Integer)groupID.get(i),false, 98); //Street
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
    public void changeBuilding(Street street, int numOfBuildings){
        street.setNumOfBuildings(numOfBuildings);
    }
}
