package com.ironhack.BankingSystem.repositories.accountRepos;

import com.ironhack.BankingSystem.models.acc.Checking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CheckingRepository extends JpaRepository<Checking, Integer> {
}