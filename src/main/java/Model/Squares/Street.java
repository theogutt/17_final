package Model.Squares;

import Controller.GameBoard;
import Controller.PlayerController;
import Controller.RentController;
import Model.Player;
import View.GUI_Handler;
import gui_fields.GUI_Street;

import java.awt.*;
import java.io.IOException;

public class Street extends Ownable{

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard, price, numOfBuildings, name, groupID, owned, owner);
    }
}