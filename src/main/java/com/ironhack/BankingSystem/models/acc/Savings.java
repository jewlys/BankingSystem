package com.ironhack.BankingSystem.models.acc;

import com.ironhack.BankingSystem.models.Money;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import com.ironhack.BankingSystem.models.acc.Account;

import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "account_id")
public class Savings extends Account {
    private static final BigDecimal DEFAULT_INTEREST_RATE = new BigDecimal("0.0025");
    private static final BigDecimal MAX_INTEREST_RATE = new BigDecimal("0.5");
    private static final BigDecimal MINIMUM_BALANCE = new BigDecimal("1000");

    private BigDecimal interestRate;
    private BigDecimal minimumBalance;

    @Column(name = "secret_key")
    private String secretKey;

    public Savings() {
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.minimumBalance = MINIMUM_BALANCE;
    }

    public Savings(Money balance, AccountHolder primaryOwner) {
        super(balance, primaryOwner);
        this.interestRate = DEFAULT_INTEREST_RATE;
        this.minimumBalance = MINIMUM_BALANCE;
    }

    public Savings(Money balance, AccountHolder primaryOwner, BigDecimal interestRate) {
        super(balance, primaryOwner);
        if (interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            this.interestRate = MAX_INTEREST_RATE;
        } else {
            this.interestRate = interestRate;
        }
        this.minimumBalance = MINIMUM_BALANCE;
    }

    public Savings(Money balance, AccountHolder primaryOwner, BigDecimal interestRate, BigDecimal minimumBalance) {
        super(balance, primaryOwner);
        if (interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            this.interestRate = MAX_INTEREST_RATE;
        } else {
            this.interestRate = interestRate;
        }
        if (minimumBalance.compareTo(MINIMUM_BALANCE) < 0) {
            this.minimumBalance = MINIMUM_BALANCE;
        } else {
            this.minimumBalance = minimumBalance;
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            this.interestRate = MAX_INTEREST_RATE;
        } else {
            this.interestRate = interestRate;
        }
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (minimumBalance.compareTo(MINIMUM_BALANCE) < 0) {
            this.minimumBalance = MINIMUM_BALANCE;
        } else {
            this.minimumBalance = minimumBalance;
        }
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void addInterest() {
        BigDecimal interest = getBalance().multiply(getInterestRate());
        creditBalance(interest);
    }

    private void creditBalance(BigDecimal interest) {
    }

    @Override
    public void withdraw(Money amount) {
        if (getBalance().subtract(amount.getAmount()).compareTo(minimumBalance) < 0) {
            throw new IllegalArgumentException("Insufficient funds. Savings account balance cannot go below the minimum balance.");
        } else {
            super.withdraw(amount);
        }
    }
}

