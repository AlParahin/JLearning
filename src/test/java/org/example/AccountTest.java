package org.example;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

    public void testGetOwnerName() {
        Account account = new Account("Asdfgh");
        assertNotNull(account.getOwnerName());
        assertEquals(account.getOwnerName(), "Asd"+"fgh");
        assertNotSame("asdfgh", account.getOwnerName());
    }

    public void testSetOwnerName() {
        try {
            Account account = new Account("");
        }
        catch(Exception e){
            assertNotNull(e);
            assertEquals(e.getMessage(), "Имя владельца не может быть пустым!");
        }

        try {
            Account account = new Account(null);
        }
        catch(Exception e){
            assertNotNull(e);
            assertEquals("Имя владельца не может быть пустым!", e.getMessage());
        }

        Account account = new Account("Bob");
        try {account.setOwnerName("");}
        catch(Exception e){
            assertNotNull(e);
            assertEquals("Имя владельца не может быть пустым!", e.getMessage());
        }
        try {account.setOwnerName(null);}
        catch(Exception e){
            assertNotNull(e);
            assertEquals("Имя владельца не может быть пустым!", e.getMessage());
        }
    }

    public void testGetSavings() {
        Account account = new Account("Bob");
        account.setCurrencyAmount(Currency.KZT, 1000);
        assertNotNull(account.getCurrencyAmounts());
    }

    public void testSetCurrencyAmount() {
        Account account = new Account("Bob");
        account.setCurrencyAmount(Currency.KZT, 1000);
        account.setCurrencyAmount(Currency.KZT, 0);
        assertNotNull(account.getCurrencyAmounts().toString());
        account.setCurrencyAmount(Currency.BLR, 0);
        assertNotNull(account.getCurrencyAmounts().toString());

        try {account.setCurrencyAmount(null, 6540);}
        catch(Exception e){
            assertNotNull(e);
            assertEquals("Валюта должна быть указана!", e.getMessage());
        }
        try {account.setCurrencyAmount(Currency.valueOf(""), 1000);}
        catch(Exception e){
            assertNotNull(e);
            assertEquals("No enum constant org.example.Currency.", e.getMessage());
        }
        try {account.setCurrencyAmount(Currency.RUB, -5000);}
        catch(Exception e){
            assertNotNull(e);
            assertEquals("Количество валюты не должно быть отрицательным!", e.getMessage());
        }
    }

    public void testTestToString() {
        Account account1 = new Account("Bob");
        Account account2 = new Account("Bob");
        Account account3 = new Account("Alx");
        assertNotNull(account1.toString());
        assertEquals(account1.toString(), account2.toString());
        assertNotSame(account1.toString(), account3.toString());
    }
}