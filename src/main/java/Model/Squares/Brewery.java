//*******************************************************************
// Brewery.java       Author: Gruppe 17
//
// Repræsenterer et bryggeri felt som man kan eje
//*******************************************************************

package Model.Squares;

public class Brewery extends Ownable {
    public Brewery(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) {
        super(positionOnBoard, price, numOfBuildings, name, groupID, owned, owner);
    }
}

