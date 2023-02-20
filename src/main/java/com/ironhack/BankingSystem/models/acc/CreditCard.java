package com.ironhack.BankingSystem.models.acc;

import com.ironhack.BankingSystem.models.Money;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import com.ironhack.BankingSystem.models.acc.Account;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class CreditCard extends Account {
    private static final BigDecimal MAX_CREDIT_LIMIT = new BigDecimal("100000");
    private static final BigDecimal DEFAULT_CREDIT_LIMIT = new BigDecimal("100");
    private static final BigDecimal MIN_INTEREST_RATE = new BigDecimal("0.1");
    private static final BigDecimal MAX_INTEREST_RATE = new BigDecimal("0.2");
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCard() {
        super();
        this.creditLimit = DEFAULT_CREDIT_LIMIT;
        this.interestRate = MAX_INTEREST_RATE;
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = DEFAULT_CREDIT_LIMIT;
        this.interestRate = MAX_INTEREST_RATE;
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        if (creditLimit.compareTo(MAX_CREDIT_LIMIT) > 0) {
            this.creditLimit = MAX_CREDIT_LIMIT;
        } else if (creditLimit.compareTo(DEFAULT_CREDIT_LIMIT) < 0) {
            this.creditLimit = DEFAULT_CREDIT_LIMIT;
        } else {
            this.creditLimit = creditLimit;
        }

        if (interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            this.interestRate = MAX_INTEREST_RATE;
        } else if (interestRate.compareTo(MIN_INTEREST_RATE) < 0) {
            this.interestRate = MIN_INTEREST_RATE;
        } else {
            this.interestRate = interestRate;
        }
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        if (creditLimit.compareTo(MAX_CREDIT_LIMIT) > 0) {
            this.creditLimit = MAX_CREDIT_LIMIT;
        } else if (creditLimit.compareTo(DEFAULT_CREDIT_LIMIT) < 0) {
            this.creditLimit = DEFAULT_CREDIT_LIMIT;
        } else {
            this.creditLimit = creditLimit;
        }
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        if (interestRate.compareTo(MAX_INTEREST_RATE) > 0) {
            this.interestRate = MAX_INTEREST_RATE;
        } else if (interestRate.compareTo(MIN_INTEREST_RATE) < 0) {
            this.interestRate = MIN_INTEREST_RATE;
        } else {
            this.interestRate = interestRate;
        }
    }
}
