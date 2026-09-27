package edu.miu.cs590de.lab5.product.domain;

import java.math.BigDecimal;

/**
 * Value object. Immutable, equal by value, stored as a nested sub-document.
 */
public class Money {

    private BigDecimal amount;
    private String currency;

    protected Money() {
    }

    public Money(BigDecimal amount, String currency) {
        if (amount == null || amount.signum() < 0) {
            throw new IllegalArgumentException("amount must not be negative");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money multiply(int factor) {
        return new Money(amount.multiply(BigDecimal.valueOf(factor)), currency);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
