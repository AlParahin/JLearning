package org.example;

import java.util.*;

public class Account {
    private String ownerName;

    private final Map<Currency, Integer> currencyAmounts = new HashMap<>();
    private final Deque<Executable> saves = new ArrayDeque<>();

    public Account(String ownerName) {
        this.setOwnerName(ownerName);
    }

    public Map<Currency, Integer> getCurrencyAmounts() {
        return new HashMap<>(this.currencyAmounts);
    }
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if((ownerName == null) || ownerName.isBlank()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым!");
        }
        if(!(this.ownerName == null) && this.ownerName.equals(ownerName)) return;
        if(!(this.ownerName == null)){
            String tmp = this.ownerName;
            saves.push(() -> Account.this.ownerName = tmp);
        }
        this.ownerName = ownerName;
    }

    public void setCurrencyAmount(Currency currency, Integer amount){
        if(currency == null) {
            throw new IllegalArgumentException("Валюта должна быть указана!");
        }
        if(amount<0) {
            throw new IllegalArgumentException("Количество валюты не должно быть отрицательным!");
        }
        if(currencyAmounts.containsKey(currency)){
            Integer tmp = this.currencyAmounts.get(currency);
            saves.push(() -> currencyAmounts.put(currency, tmp));
        } else {
            saves.push(() -> currencyAmounts.remove(currency));
        }
        currencyAmounts.put(currency, amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                ", currencyAmounts=" + currencyAmounts +
                '}';
    }

    public void save(){
        new AccountSave();
    }

    public void undo() {
        try {
            saves.pop().make();
        } catch (Exception e) {
            if(e.toString().equals("NoSuchElementException")){
                return;
            }

        }
    }

    private class AccountSave implements Saveable{
        private String ownerName = Account.this.ownerName;
        private final Map<Currency, Integer> savings = new HashMap<>(Account.this.currencyAmounts);

        @Override
        public void save() {
            Account.this.ownerName = ownerName;
            Account.this.currencyAmounts.clear();
            Account.this.currencyAmounts.putAll(savings);
        }

    }

}
