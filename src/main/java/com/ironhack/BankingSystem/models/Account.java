package com.ironhack.BankingSystem.models;

import com.ironhack.BankingSystem.AccountStatus;
import com.ironhack.BankingSystem.Person;

import java.math.BigDecimal;

public class Account {

        private BigDecimal balance;
        private String secretKey;
        private Person primaryOwner;
        private Person secondaryOwner;
        private BigDecimal minimumBalance;
        private BigDecimal penaltyFee;
        private BigDecimal monthlyMaintenanceFee;
        private LocalDate creationDate;
        private AccountStatus status;

        // Getters and setters for the above fields
    }

}
