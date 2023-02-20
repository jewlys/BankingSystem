package com.ironhack.BankingSystem.models.acc;
import com.ironhack.BankingSystem.models.Money;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import com.ironhack.BankingSystem.models.acc.Account;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Checking extends Account {

    @NotNull
    private String secretKey;

    @NotNull
    private BigDecimal minimumBalance;

    @NotNull
    private BigDecimal monthlyMaintenanceFee;

    public Checking() {
    }
/*this implementation sets the minimum balance and monthly maintenance fee values in the constructor, so they cannot be modified. This provides additional safety and avoids unintended changes to these values in the future. */
    public Checking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, Date creationDate, Status status) {
        super(balance, primaryOwner, secondaryOwner, creationDate, status);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}

