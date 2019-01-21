//**************************************************************************
// Trading.java       Author: Gruppe 17
//
// Overfører grunde og penge mellem to spiller som har lavet en byttehandel
//**************************************************************************

package Controller;

import Model.Squares.Ownable;

public class Trading {

    // Bytter antal penge og valgte Ownables af two spillere
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

    // Konverterer et String array af Ownable navne til et Ownable array af Ownables med de navne
    public Ownable[] convertOwnable(PlayerController playerC, int ref, String[] stringOwnable){
        Ownable[] newOwnables = new Ownable[stringOwnable.length];
        Ownable[] playerOwnables = playerC.getPlayerOwnables(ref);
        int nextID = 0;

        for (int n=0 ; n < newOwnables.length ; n++){
            for(int i=0 ; i < playerOwnables.length ; i++) {
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
