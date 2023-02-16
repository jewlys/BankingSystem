package com.ironhack.BankingSystem.models;

import com.ironhack.BankingSystem.models.Checking;

public class StudentChecking extends Checking {
    @Override
    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        // Override the parent class setter and throw an exception
        throw new UnsupportedOperationException("Student checking accounts do not have a monthly maintenance fee");
    }

    @Override
    public void setMinimumBalance(BigDecimal minimumBalance) {
        // Override the parent class setter and throw an exception
        throw new UnsupportedOperationException("Student checking accounts do not have a minimum balance");
    }
}

