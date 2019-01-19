//*******************************************************************
// Textreader.java       Author: Gruppe 17
//
// Laver et HashMap ud fra en given fil
//*******************************************************************

package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextReader {

    // Laver et HashMap fra en fil og splitter hver linje på "=" tegn
    public static HashMap textReader(String file) throws IOException {
        BufferedReader br = new BufferedReader((new FileReader(file)));
        String line;
        if (file.equals(".\\src\\Resources\\SquarePrice")||file.equals(".\\src\\Resources\\1HouseRent")||file.equals(".\\src\\Resources\\2HousesRent")||file.equals(".\\src\\Resources\\3HousesRent")||file.equals(".\\src\\Resources\\4HousesRent")||file.equals(".\\src\\Resources\\BaseRent")||file.equals(".\\src\\Resources\\HotelRent")||file.equals(".\\src\\Resources\\groupID")||file.equals(".\\src\\Resources\\BuildingPrice")) {
            HashMap<Integer, Integer> hashMapINT = new HashMap<Integer, Integer>();
            while ((line = br.readLine()) != null) {
                String[] keyAndPairs = line.split("=");
                hashMapINT.put(Integer.valueOf(keyAndPairs[0]), Integer.valueOf(keyAndPairs[1]));
            }
            return hashMapINT;

        } else {
            HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
            while ((line = br.readLine()) != null) {
                String[] keyAndPairs = line.split("=");
                hashMap.put(Integer.valueOf(keyAndPairs[0]), keyAndPairs[1]);
            }
            return hashMap;
        }
    }
}
