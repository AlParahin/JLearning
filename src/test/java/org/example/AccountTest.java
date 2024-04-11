package org.example;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

    public void testGetOwnerName() {
        Account account = new Account("Asdfgh");
        assertNotNull(account.getOwnerName());
        assertEquals(account.getOwnerName(), "Asd"+"fgh");
        assertFalse(account.getOwnerName() == "asdfgh");
    }

    public void testSetOwnerName() {
        Account account = new Account("Bob");
        try {account.setOwnerName("");}
        catch(Exception e){
            assertNotNull(e);
            assertEquals(e.getMessage(), "Имя владельца не может быть пустым!");
        }
    }

    public void testGetSavings() {
        Account account = new Account("Bob");
        assertNull(account.getSavings());
        account.setCurrencyAmount(Currency.KZT, Long.valueOf(1000));
        assertNotNull(account.getSavings());
    }

    public void testSetCurrencyAmount() {
        Account account = new Account("Bob");
        account.setCurrencyAmount(Currency.KZT, Long.valueOf(1000));
        account.setCurrencyAmount(Currency.KZT, Long.valueOf(0));
        assertNotNull(account.getSavings().toString());
        account.setCurrencyAmount(Currency.BLR, Long.valueOf(0));
        assertNotNull(account.getSavings().toString());
    }

    public void testTestToString() {
        Account account1 = new Account("Bob");
        Account account2 = new Account("Bob");
        Account account3 = new Account("Alx");
        assertNotNull(account1.toString());
        assertEquals(account1.toString(), account2.toString());
        assertFalse(account1.toString() == account3.toString());
    }
}