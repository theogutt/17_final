package Model.Squares;

import Controller.PlayerController;
import Controller.RentController;
import View.GUI_Handler;

public abstract class Square{
    private Street street;
    private int positionOnBoard;
    private int owner;
    private int numOfBuildings;
import static Controller.GameBoard.squares;

public abstract class Square {

    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public int landOn(PlayerController playerC, int ref, GUI_Handler guiHandler, RentController rentC){
        try {
        }
        catch (NullPointerException ex){}
        return -1;
    }

    public int getOwner(int ref) {
        return this.owner;
    }
    public abstract int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum, int ref);

    public int buy(){ // Skal have et andet navn
        int boardPos = getPositionOnBoard();
        int n;
        n = 0;
        //Getposition

        for (int i=0 ; 1 < squares.length; i++){
            if (boardPos == squares[i].getPositionOnBoard()){
            n = i;
        }}
        return n;
    }
public String buy2{ //Skal have et andet navn

        if (squares[buy()].getOwned()){


        }

        else {




        }







    }






}

    public int getNumOfBuildings() {
        int numOfBuildings = street.getNumOfBuildings();
        return numOfBuildings;
    }
    public int getPositionOnBoard(){
        return positionOnBoard;
    }
    }