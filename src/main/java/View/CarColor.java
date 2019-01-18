package View;

import java.awt.*;

public class CarColor {
    private Color[] colorArray = new Color[6];
    private int colorsChosen;
    private int numOfColors = 6;
    private String[] colorStringArray;
    private String[] colorStringArray2;

    public CarColor() {
        instaColorArray();
        instaColorStringArray();
    }

    public Color colorChosen(String colorChoiceString) {
        Color returnColor;
        if (colorChoiceString.equalsIgnoreCase("rød")) {
            returnColor = colorArray[0];
        } else if (colorChoiceString.equalsIgnoreCase("grøn")) {
            returnColor = colorArray[1];
        } else if (colorChoiceString.equalsIgnoreCase("blå")) {
            returnColor = colorArray[2];
        }
        else if (colorChoiceString.equalsIgnoreCase("lila")) {
            returnColor = colorArray[3];
        }
        else if (colorChoiceString.equalsIgnoreCase("gul")) {
            returnColor = colorArray[4];
        }
        else {
            //If choice is white
            returnColor = colorArray[5];
        }
        colorsChosen++;
        updateColorStringArray(colorChoiceString);
        return returnColor;
    }

    private void updateColorStringArray(String lastChosen) {
        colorStringArray2 = new String[colorStringArray.length];


        for (int i = 0; i < colorStringArray.length; i++) {
            colorStringArray2[i] = colorStringArray[i];
        }
        colorStringArray = new String[(numOfColors - colorsChosen)];
        for (int i = 0; i < colorStringArray.length; i++) {
            if (!colorStringArray2[i].equalsIgnoreCase(lastChosen)) {
                colorStringArray[i] = colorStringArray2[i];
            }
            if (colorStringArray2[i].equalsIgnoreCase(lastChosen)) {
                colorStringArray[i] = colorStringArray2[i + 1];
                for (int j = i; j < colorStringArray.length; j++) {
                    colorStringArray[j] = colorStringArray2[j + 1];
                }
                break;
            }
        }
    }
    public String colorsToChooseFrom() {
        String returnString = "";
        for (int i = 0; i < colorStringArray.length; i++) {
            returnString = returnString + colorStringArray[i] + " ";
        }
        return returnString;
    }
    private void instaColorArray() {
        colorArray[0] = Color.red;
        colorArray[1] = Color.GREEN;
        colorArray[2] = Color.BLUE;
        colorArray[3] = Color.MAGENTA;
        colorArray[4] = Color.yellow;
        colorArray[5] = Color.white;
    }
    private void instaColorStringArray() {
        colorStringArray = new String[6];
        colorStringArray[0] = "rød";
        colorStringArray[1] = "grøn";
        colorStringArray[2] = "blå";
        colorStringArray[3] = "lila";
        colorStringArray[4] = "gul";
        colorStringArray[5] = "hvid";
    }
}