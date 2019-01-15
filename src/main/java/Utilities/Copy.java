package Utilities;
import Model.Squares.Ownable;
import Model.Squares.Street;

import java.util.Arrays;

public class Copy {
    public static Ownable[] of(Ownable[] original, int newLength){
        Ownable[] newArray = new Ownable[newLength];
        int stop;

        if (original.length < newArray.length)
            stop = original.length;
        else
            stop = newArray.length;

        for (int i=0 ; i < stop ; i++)
            newArray[i] = original[i];

        return newArray;
    }


    public static Street[] of(Street[] original, int newLength){
        Street[] newArray = new Street[newLength];
        int stop;

        if (original.length < newArray.length)
            stop = original.length;
        else
            stop = newArray.length;

        for (int i=0 ; i < stop ; i++)
            newArray[i] = original[i];

        return newArray;
    }

    public static String[] of(String[] original, int newLength){
        String[] newArray = new String[newLength];
        int stop;

        if (original.length < newArray.length)
            stop = original.length;
        else
            stop = newArray.length;

        for (int i=0 ; i < stop ; i++)
            newArray[i] = original[i];

        return newArray;
    }

}
