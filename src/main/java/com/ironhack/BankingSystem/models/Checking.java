package com.ironhack.BankingSystem.models;
import com.ironhack.BankingSystem.AccountStatus;
import com.ironhack.BankingSystem.models.Account;
import com.ironhack.BankingSystem.models.AccountHolder;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "checking_accounts")
public class Checking extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal balance;

    private String secretKey;

    @ManyToOne
    @JoinColumn(name = "primary_owner_id", referencedColumnName = "id")
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id", referencedColumnName = "id")
    private AccountHolder secondaryOwner;

    @Column(nullable = false)
    private BigDecimal minimumBalance;

    @Column(nullable = false)
    private BigDecimal penaltyFee;

    @Column(nullable = false)
    private BigDecimal monthlyMaintenanceFee;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    // Constructor, getters, and setters omitted for brevity

}
