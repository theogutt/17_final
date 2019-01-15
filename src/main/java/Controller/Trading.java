package Controller;

import Model.Player;
import Model.Squares.Ownable;

public class Trading {
    public void trade(PlayerController playerC, int curRef, Ownable curOwnable, int curMoney,
                                                int othRef, Ownable othOwnable, int othMoney){

        // Ownable overførsel
        if (othOwnable != null){
            playerC.removeOwnable(othOwnable, othRef);
            playerC.addOwnable(othOwnable, curRef);
        }

        if (curOwnable != null){
            playerC.removeOwnable(curOwnable, curRef);
            playerC.addOwnable(curOwnable, othRef);
        }

        // Penge overførsel
        playerC.updatePlayerBalance(curRef, -curMoney);
        playerC.updatePlayerBalance(othRef, -othMoney);

        playerC.updatePlayerBalance(curRef, othMoney);
        playerC.updatePlayerBalance(othRef, curMoney);

    }
}
