package Controller;

import Model.Player;
import Model.Squares.Ownable;

public class Trading {
    public void trade(PlayerController playerC, int initRef, String[] initOwnable, int initMoney,
                                                int receRef, String[] receOwnable, int receMoney){

        Ownable[] initOwnableConverted = convertOwnable(playerC, initRef, initOwnable);
        Ownable[] receOwnableConverted = convertOwnable(playerC, receRef, receOwnable);
        // Ownable overførsel
        if (receOwnableConverted.length != 0){
            for (Ownable n : receOwnableConverted) {
                playerC.removeOwnable(n, receRef);
                playerC.addOwnable(n, initRef);
            }
        }

        if (initOwnableConverted.length != 0){
            for (Ownable n : initOwnableConverted) {
                playerC.removeOwnable(n, initRef);
                playerC.addOwnable(n, receRef);
            }
        }

        // Penge overførsel
        playerC.updatePlayerBalance(initRef, -initMoney);
        playerC.updatePlayerBalance(receRef, -receMoney);

        playerC.updatePlayerBalance(initRef, receMoney);
        playerC.updatePlayerBalance(receRef, initMoney);

    }

    private Ownable[] convertOwnable(PlayerController playerC, int ref, String[] stringOwnable){
        Ownable[] newOwnables = new Ownable[stringOwnable.length];
        Ownable[] playerOwnables = playerC.getPlayerOwnables(ref);
        int nextID = 0;

        for (int n=0 ; n < newOwnables.length ; n++){
            for(int i=0 ; i < newOwnables.length ; i++) {
                if (stringOwnable[n].equals(playerOwnables[i].getName())) {
                    newOwnables[nextID] = playerOwnables[i];
                    nextID++;
                    break;
                }
            }
        }
        return newOwnables;
    }
}
