package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class StarterApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Account account1 = new Account("Chuck Berry");
        account1.save();
        System.out.println(account1);
        account1.setCurrencyAmount(Currency.RUB, 1000);
        System.out.println(account1);
        account1.setCurrencyAmount(Currency.RUB, 2000);
        System.out.println(account1);
        account1.setCurrencyAmount(Currency.CNY, 5000);
        System.out.println(account1);
        account1.undo();
        System.out.println(account1);
        account1.undo();
        System.out.println(account1);
        account1.undo();
        System.out.println(account1);
        account1.undo();
        System.out.println(account1);
        account1.undo();
        System.out.println(account1);

        Account account2 = new Account("Bob Marley");
        System.out.println(account2);
        account2.setCurrencyAmount(Currency.RUB, 1000);
        //account2.setOwnerName("");
        System.out.println(account2);
        account2.undo();
        System.out.println(account2);
        account2.undo();
        System.out.println(account2);
        account2.undo();
        System.out.println(account2);
    }

    public static void test(List<Saveable> lst) {
        for(Saveable s : lst) s.save();
    }
}
