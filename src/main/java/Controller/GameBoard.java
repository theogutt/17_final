package Controller;

import Model.Squares.*;

import java.util.HashMap;

public class GameBoard {

    private Square[] squares = new Square[40];
    private PlayerController PlayerC;
    private HashMap squarePrice;
    private HashMap BaseRent;

// Opretter felter med pris og rent
    public void instantiateSquares(){
        for (int i = 0; i < 40; i++) {
            if (i == 0){ squares[i]= new Start(i);}                                                                        //Start
            else if (i == 10 || i == 20 ){ squares[i]= new Parking(i);}                                                    //Parking
            else if (i == 30 ){ squares[i]= new GoToPrison(i);}                                                            //Jail
            else if (i == 2 || i == 7 || i == 17 || i == 22 || i == 33 || i == 36) {squares[i]= new Chance(i);}            //Chance
            else if (i == 4 || i == 38){squares[i]= new Tax(i);}                                                           //Tax
            else if (i == 6 || i == 16 ||i == 26 ||i == 36) {squares[i] = new Ferry(i,4000,500,false);} //Ferry
            else if (i == 13 || i == 29){squares[i] = new Brewery(i,3000,111,false);}                   //Brew
            else {squares[i]= new Street(i,(Integer)squarePrice.get(i),(Integer)BaseRent.get(i),false);            //Street
            }
        }
    }

    public void streetImpact(PlayerController playerC, int position,int facevalueSum, int ref){
        squares[position].landOn(playerC,position,facevalueSum,ref);
    }
    /*
    public void landOnEffect(int playerNum){

    //Der kommer nok en nullPointerException på grund af Square Square. Men nu kan programmet køres.
    public void landOnEffect(int playerNum, PlayerController PlayerC, Square Square){

        // i er den reelle spiller position på brættet
        int i = PlayerC.getPosition(playerNum) + 1;


        //Start felt
        if (i == 1){

            PlayerC.updatePlayerBalance(playerNum, 4000);
        }

        //Chancekort
        else if (i == 3 || i == 8 || i == 18 || i == 23 || i == 34 || i == 37){


        }

        //Skatte felt
        else if (i == 39){
                PlayerC.updatePlayerBalance(playerNum, -2000);
        }
        else if (i == 5){
                //Mangler valgmulighed for at betale 10%
                PlayerC.updatePlayerBalance(playerNum, -4000);
        }


        //På besøg og gratis parkering
        else if (i == 11 || i == 21){

        }

        //Gå i fængsel
        else if (i == 31){
            PlayerC.setPosition(playerNum,10);
            PlayerC.setInJail(playerNum, true);
        }

        //Grunde
        else {

        }
    }
    */
}
