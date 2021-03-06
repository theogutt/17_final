//*******************************************************************
// Copy.java       Author: Gruppe 17
//
// Indeholder nogle hjælpemetoder til Arrays.
// Nogle af disse metoder findes i senere java-versioner, men kunne
// ikke bruges i dette projekt af diverse grunde.
//*******************************************************************

package Utilities;
import Model.Squares.Ownable;
import Model.Squares.Street;

public class Copy {

    // Laver en kopi af dit valgte Array, men en nyvalgt længde
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

    // Laver en kopi af dit valgte Array, men en nyvalgt længde
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

    // Laver en kopi af dit valgte Array, men en nyvalgt længde
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

    // Tjekker om et String array indeholder en bestemt String
    public static boolean contains(String[] arr, String element){
        boolean contains = false;

        for (int n=0 ; n < arr.length ; n++){
            if (element.equals(arr[n])){
                contains = true;
                break;
            }
        }

        return contains;
    }

    // Fjerner en String fra et String array
    public static String[] remove(String[] arr, String element){
        int x = 0;

        //Tjekker hvor den String som skal fjernes er
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) {
                x = i;
                break;
            }
        }
        // Sætter alt på den nye plads i Arrayet
        for(int i = x; i < arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr = of(arr, arr.length - 1);

        return arr;
    }
}
