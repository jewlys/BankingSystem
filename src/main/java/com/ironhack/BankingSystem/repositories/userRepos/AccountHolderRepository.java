package com.ironhack.BankingSystem.repositories.userRepos;

import com.ironhack.BankingSystem.models.Users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {
}