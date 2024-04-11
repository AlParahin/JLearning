package org.example;

public class CurrencyAmount {
    private Currency currency;

    private Long amount;

    public CurrencyAmount(Currency currency, Long amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CurrencyAmount{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
