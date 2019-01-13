package Model.Squares;

import Controller.PlayerController;

import static Controller.GameBoard.squares;

public abstract class Square {

    protected int positionOnBoard;

    //Constructor
    public Square(int positionOnBoard){
        this.positionOnBoard = positionOnBoard;
    }

    public int getPositionOnBoard(){
        return positionOnBoard;
    }

    public abstract int landOn(PlayerController playerC, int positionOnBoard, int faceValueSum, int ref);

    public int buy(){
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
public String buy2{

        if (squares[buy()].getOwned()){


        }

        else {




        }







    }






}
