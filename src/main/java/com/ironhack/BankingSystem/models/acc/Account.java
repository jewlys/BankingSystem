package com.ironhack.BankingSystem.models.acc;

import com.ironhack.BankingSystem.models.Money;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import jakarta.persistence.*;
import jakarta.transaction.Status;


import java.math.BigDecimal;

import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, precision = 19, scale = 2)
        private BigDecimal balance;

        @ManyToOne(optional = false)
        @JoinColumn(name = "primary_owner_id")
        private AccountHolder primaryOwner;

        @ManyToOne
        @JoinColumn(name = "secondary_owner_id")
        private AccountHolder secondaryOwner;

        @Column(nullable = false, precision = 19, scale = 2)
        private BigDecimal penaltyFee;

        @Column(nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private ChronoLocalDate creationDate;

        @Column(nullable = true)
        @Temporal(TemporalType.TIMESTAMP)
        private Date updateDate;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Status status;

        public Account() {}

        public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
                this.balance = balance.getAmount();
                this.primaryOwner = primaryOwner;
                this.secondaryOwner = secondaryOwner;
                this.creationDate = new ChronoLocalDate() {
                        @Override
                        public long getLong(TemporalField field) {
                                return 0;
                        }

                        @Override
                        public Chronology getChronology() {
                                return null;
                        }

                        @Override
                        public int lengthOfMonth() {
                                return 0;
                        }

                        @Override
                        public long until(java.time.temporal.Temporal endExclusive, TemporalUnit unit) {
                                return 0;
                        }

                        @Override
                        public ChronoPeriod until(ChronoLocalDate endDateExclusive) {
                                return null;
                        }

                        @Override
                        public boolean equals(Object obj) {
                                return false;
                        }

                        @Override
                        public int hashCode() {
                                return 0;
                        }

                        @Override
                        public String toString() {
                                return null;
                        }
                };

        }

        public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Date creationDate, Status status) {
        }

        public Account(Money balance, AccountHolder primaryOwner) {
        }

        public Account(BigDecimal balance) {
        }

        public Long getId() {
                return id;
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

        public ChronoLocalDate getCreationDate() {
                return creationDate;
        }

        public void setCreationDate(ChronoLocalDate creationDate) {
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

        public void deposit(Money amount) {
                this.balance = this.balance.add(amount.getAmount());
        }

        public void withdraw(Money amount) {
                if (this.balance.compareTo(amount.getAmount()) >= 0) {
                        this.balance = this.balance.subtract(amount.getAmount());
                } else {
                        throw new IllegalArgumentException("Insufficient funds");
                }
        }

        public void addInterest(BigDecimal interestRate) {
                BigDecimal interest = this.balance.multiply(interestRate);
                this.balance = this.balance.add(interest);
        }

        public Object getSecretKey() {
                return null;
        }

        public void transferMoney(Account account, BigDecimal amount) {
        }
}

