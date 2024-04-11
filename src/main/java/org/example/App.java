package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Account account1 = new Account("Alx Parahin");
        System.out.println(account1);
        account1.setCurrencyAmount(Currency.RUB, Long.valueOf(1000));
        System.out.println(account1);
        account1.setCurrencyAmount(Currency.RUB, Long.valueOf(2000));
        System.out.println(account1);
        account1.setCurrencyAmount(Currency.CNY, Long.valueOf(5000));
        System.out.println(account1);

        Account account2 = new Account("Bob Marley");
        System.out.println(account2);
        account2.setCurrencyAmount(Currency.RUB, Long.valueOf(1000));
        //account2.setOwnerName("");
        System.out.println(account2);
    }
}
