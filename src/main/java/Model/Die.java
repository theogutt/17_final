package Model;

import java.util.Random;

public class Die {

    private int faceValue;
    private int faceAmount;

    public Die(int faceAmount){
        this.faceAmount = faceAmount;
    }


    //Ruller terning og returner resultatet
    public int roll() {
        Random r = new Random();
        this.faceValue = r.nextInt(this.faceAmount) + 1;
        return this.faceValue;
    }


    //Getters og setters
    public int getFaceValue(){
        return this.faceValue;
    }

}
