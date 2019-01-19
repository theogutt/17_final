//*******************************************************************
// AccountTest.java       Author: Gruppe 17
//
// Tester Account klassen
//*******************************************************************

package Test;

import Model.Account;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AccountTest {
    Account accountPlayers;

    @Before
    public void initialize(){
        accountPlayers = new Account();
    }

    // Tester om spilleren starter med det rigtige antal penge
    @Test
    public void startAccount() {
        assertEquals(30000, accountPlayers.getBalance());
    }

    // Tester om spillerens pengebeholdning opdateres korrekt
    @Test
    public void updateBalance() {
        assertEquals(30000, accountPlayers.getBalance());
        accountPlayers.updateBalance(2050);
        assertEquals(32050, accountPlayers.getBalance());
        accountPlayers.updateBalance(-2050);
        assertEquals(30000, accountPlayers.getBalance());
    }
}