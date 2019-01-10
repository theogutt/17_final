package Controller;

import Model.Squares.*;

public class GameBoard {

    private Square[] squares = new Square[40];
    private PlayerController PlayerC = new PlayerController();




    public void instantiateSquares(){
        for (int i = 0; i < 24; i++) {
            if (i == 0){ squares[i]= new Start(i);}                                                                 //Start
            else if(i == 10 || i == 20 ){ squares[i]= new Parking(i);}                                              //Parking
            else if(i == 30 ){ squares[i]= new GoToPrison(i);}                                                      //Jail
            else if (i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36) {squares[i]= new Chance(i);}     //Chance
            else{squares[i]= new Street(i, (Integer)squarePrice.get(i),false);                                      //Street
            }
        }
    }



    public void landOnEffect(int playerNum){

        int i = Square.landOn();

        if (i == -1){
            PlayerC.updatePlayerBalance(playerNum, 4000);

        }
        else if (i == -2){

        }
        else if (i == -3){

        }
        else if (i == -4){

        }
        else if (i == -5){

        }
        else if (i == -6){

        }
        else if (i == -7){

        }

    }


}
