package com.ironhack.BankingSystem.repositories.accountRepos;

import com.ironhack.BankingSystem.models.acc.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
}