package com.ironhack.BankingSystem.repositories.userRepos;

import com.ironhack.BankingSystem.models.Users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Integer> {
}
