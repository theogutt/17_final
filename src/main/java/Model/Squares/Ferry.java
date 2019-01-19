//*******************************************************************
// Ferry.java       Author: Gruppe 17
//
// Repræsenterer et færge felt som man kan eje
//*******************************************************************

package Model.Squares;

public class Ferry extends Ownable {
    public Ferry(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) {
        super(positionOnBoard, price, numOfBuildings, name, groupID, owned, owner);
    }
}