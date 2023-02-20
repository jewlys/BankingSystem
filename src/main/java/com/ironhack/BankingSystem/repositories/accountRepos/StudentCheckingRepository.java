package com.ironhack.BankingSystem.repositories.accountRepos;

import com.ironhack.BankingSystem.models.acc.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Integer> {
}