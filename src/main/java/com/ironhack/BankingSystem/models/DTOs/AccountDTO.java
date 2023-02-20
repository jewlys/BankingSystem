package com.ironhack.BankingSystem.models.DTOs;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import org.jetbrains.annotations.NotNull;


import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountDTO {

    @NotNull
    private BigDecimal balance;

    @NotNull
    private String secretKey;

    private AccountHolder secondaryOwner;

    private BigDecimal minimumBalance;

    private LocalDate creationDate;

    private BigDecimal interestRate;

    private BigDecimal creditLimit;

    //constructor
    public AccountDTO(BigDecimal balance, String secretKey, AccountHolder secondaryOwner, BigDecimal minimumBalance, LocalDate creationDate, BigDecimal interestRate, BigDecimal creditLimit) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.secondaryOwner = secondaryOwner;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }


    //getters
    public BigDecimal getBalance() {
        return balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    //setters
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
