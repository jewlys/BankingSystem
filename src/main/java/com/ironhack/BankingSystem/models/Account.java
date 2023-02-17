package com.ironhack.BankingSystem.models;

import com.ironhack.BankingSystem.AccountStatus;
import com.ironhack.BankingSystem.Person;
import jakarta.persistence.*;
import jakarta.transaction.Status;

import java.math.BigDecimal;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
        @Id
        public Integer accountId;

        public BigDecimal balance;

        @ManyToOne
        @JoinColumn(name = "primary_owner_id")
        public AccountHolder primaryOwner;

        @ManyToOne
        @JoinColumn(name = "secondary_owner_id")
        public AccountHolder secondaryOwner;

        public BigDecimal penaltyFee;

        public Date creationDate;

        public Date updateDate;

        @Enumerated(EnumType.STRING)
        public Status status;

        public Account() {
        }

        public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, Date creationDate, Date updateDate, Status status) {
                this.balance = balance;
                this.primaryOwner = primaryOwner;
                this.secondaryOwner = secondaryOwner;
                this.penaltyFee = penaltyFee;
                this.creationDate = creationDate;
                this.updateDate = updateDate;
                this.status = status;
        }

        public Integer getAccountId() {
                return accountId;
        }

        public void setAccountId(Integer accountId) {
                this.accountId = accountId;
        }

        public BigDecimal getBalance() {
                return balance;
        }

        public void setBalance(BigDecimal balance) {
                this.balance = balance;
        }

        public AccountHolder getPrimaryOwner() {
                return primaryOwner;
        }

        public void setPrimaryOwner(AccountHolder primaryOwner) {
                this.primaryOwner = primaryOwner;
        }

        public AccountHolder getSecondaryOwner() {
                return secondaryOwner;
        }

        public void setSecondaryOwner(AccountHolder secondaryOwner) {
                this.secondaryOwner = secondaryOwner;
        }

        public BigDecimal getPenaltyFee() {
                return penaltyFee;
        }

        public void setPenaltyFee(BigDecimal penaltyFee) {
                this.penaltyFee = penaltyFee;
        }

        public Date getCreationDate() {
                return creationDate;
        }

        public void setCreationDate(Date creationDate) {
                this.creationDate = creationDate;
        }

        public Date getUpdateDate() {
                return updateDate;
        }

        public void setUpdateDate(Date updateDate) {
                this.updateDate = updateDate;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }
}

