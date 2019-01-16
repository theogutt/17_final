package Model.Squares;

import java.io.IOException;

public class Brewery extends Ownable {
    public Brewery(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) throws IOException {
        super(positionOnBoard, price, numOfBuildings, name, groupID, owned, owner);
    }
}

