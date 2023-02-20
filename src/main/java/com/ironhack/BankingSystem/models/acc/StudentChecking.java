package com.ironhack.BankingSystem.models.acc;

import com.ironhack.BankingSystem.models.Money;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import com.ironhack.BankingSystem.models.acc.Account;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class StudentChecking extends Account {

    // Fields specific to StudentChecking accounts
    private BigDecimal monthlyMaintenanceFee;
    private BigDecimal dailyTransactionLimit;

    // Constructor
    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        this.monthlyMaintenanceFee = BigDecimal.ZERO;
        this.dailyTransactionLimit = new BigDecimal("500.00");
    }

    // Getters and setters for the fields specific to StudentChecking accounts
    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public BigDecimal getDailyTransactionLimit() {
        return dailyTransactionLimit;
    }

    public void setDailyTransactionLimit(BigDecimal dailyTransactionLimit) {
        this.dailyTransactionLimit = dailyTransactionLimit;
    }
}


