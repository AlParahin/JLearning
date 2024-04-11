package org.example;

import junit.framework.TestCase;

public class CurrencyAmountTest extends TestCase {

    public void testGetCurrency() {
        CurrencyAmount currencyAmount = new CurrencyAmount(Currency.KZT, Long.valueOf(5000));
        assertNotNull(currencyAmount.getCurrency());
        assertSame(currencyAmount.getCurrency(), Currency.KZT);
        assertNotSame(currencyAmount.getCurrency(), Currency.INR);
    }

    public void testGetAmount() {
        CurrencyAmount currencyAmount = new CurrencyAmount(Currency.KZT, Long.valueOf(2000));
        assertNotNull(currencyAmount.getAmount());
        assertEquals(currencyAmount.getAmount(), Long.valueOf(2000));
        assertFalse(currencyAmount.getAmount() == Long.valueOf(2001));
    }

    public void testSetAmount() {
        CurrencyAmount currencyAmount = new CurrencyAmount(Currency.KZT, Long.valueOf(2000));
        currencyAmount.setAmount(Long.valueOf(3000));
        assertNotNull(currencyAmount.getAmount());
        assertEquals(currencyAmount.getAmount(), Long.valueOf(3000));
        assertFalse(currencyAmount.getAmount() == Long.valueOf(3002));
    }

    public void testTestToString() {
        CurrencyAmount currencyAmount1 = new CurrencyAmount(Currency.KZT, Long.valueOf(2000));
        CurrencyAmount currencyAmount2 = new CurrencyAmount(Currency.KZT, Long.valueOf(2000));
        CurrencyAmount currencyAmount3 = new CurrencyAmount(Currency.TRL, Long.valueOf(2000));
        assertEquals(currencyAmount1.toString(), currencyAmount2.toString());
        assertNotSame(currencyAmount1.toString(), currencyAmount3.toString());
    }
}