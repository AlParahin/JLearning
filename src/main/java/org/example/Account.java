package org.example;

import java.util.ArrayList;

public class Account {
    private String ownerName;

    private ArrayList<CurrencyAmount> savings;

    public Account(String ownerName) {
        this.setOwnerName(ownerName);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if((ownerName == null) || ownerName.isEmpty()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым!");
        }
        this.ownerName = ownerName;
    }

    ArrayList<CurrencyAmount> getSavings() {
        return this.savings;
    }

    public void setCurrencyAmount(Currency currency, Long amount){
        if(currency == null) {
            throw new IllegalArgumentException("Валюта должна быть указана!");
        }
        if(amount<0) {
            throw new IllegalArgumentException("Количество валюты не должно быть отрицательным!");
        }
        if(this.savings == null){
            this.savings = new ArrayList<>();
            this.savings.add(new CurrencyAmount(currency, amount));
            return;
        }
        for(CurrencyAmount currencyAmount : savings){
            if(currencyAmount.getCurrency().equals(currency)) {
                currencyAmount.setAmount(amount);
                return;
            }
        }
        this.savings.add(new CurrencyAmount(currency, amount));
    }

    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                ", savings=" + savings +
                '}';
    }
}
