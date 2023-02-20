package com.ironhack.BankingSystem.repositories.accountRepos;

import com.ironhack.BankingSystem.models.acc.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SavingsRepository extends JpaRepository<Savings, Integer> {
}