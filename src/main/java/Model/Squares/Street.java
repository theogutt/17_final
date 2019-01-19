//*******************************************************************
// Street.java       Author: Gruppe 17
//
// Repræsenterer en grund som man kan eje
//*******************************************************************

package Model.Squares;

public class Street extends Ownable{

    public Street(int positionOnBoard, int price, int numOfBuildings, String name, int groupID, boolean owned, int owner) {
        super(positionOnBoard, price, numOfBuildings, name, groupID, owned, owner);
    }
}