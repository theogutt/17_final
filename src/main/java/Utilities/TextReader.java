package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextReader {

    public static HashMap textReader(String file) throws IOException {
        BufferedReader br = new BufferedReader((new FileReader(file)));
        String line;
        if (file.equals(".\\src\\Resources\\SquarePrice")||file.equals(".\\src\\Resources\\BaseRent")) {
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
