package com.ironhack.BankingSystem.repositories.userRepos;

import com.ironhack.BankingSystem.models.Users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}