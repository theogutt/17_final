package Controller;

import Model.Player;
import Model.Squares.Ownable;

public class Trading {
    Ownable[] curPlayerOwnables; //SLET DISSE
    Ownable[] othPlayerOwnables;

    public Trading(PlayerController playerC, int curRef, int othRef){
        this.curPlayerOwnables = playerC.getPlayerOwnables(curRef);
        this.othPlayerOwnables = playerC.getPlayerOwnables(othRef);
    }

    public void trade(PlayerController playerC, int curRef, Ownable curOwnable, int curMoney,
                                                int othRef, Ownable othOwnable, int othMoney){

        // Ownable overførsel
        playerC.removeOwnable(curOwnable, curRef);
        playerC.removeOwnable(othOwnable, othRef);

        playerC.addOwnable(othOwnable, curRef);
        playerC.addOwnable(curOwnable, othRef);


        // Penge overførsel
        playerC.updatePlayerBalance(curRef, -curMoney);
        playerC.updatePlayerBalance(othRef, -othMoney);

        playerC.updatePlayerBalance(curRef, othMoney);
        playerC.updatePlayerBalance(othRef, curMoney);

    }

    private void removeNull(PlayerController playerC, int ref){
        Ownable[] ownables = playerC.getPlayerOwnables(ref);
        if (ownables[ownables.length-1] == null){

        }

    }
}
