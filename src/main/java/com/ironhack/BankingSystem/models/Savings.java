package com.ironhack.BankingSystem.models;

import com.ironhack.BankingSystem.models.Account;

import java.math.BigDecimal;

public class Savings extends Account {
    private BigDecimal interestRate;

    @Override
    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        // Override the parent class setter and throw an exception
        throw new UnsupportedOperationException("Savings accounts do not have a monthly maintenance fee");
    }

    // Getters and setters for the above fields
}

