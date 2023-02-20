package com.ironhack.BankingSystem.repositories.userRepos;

import com.ironhack.BankingSystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Role findByName(String name);
}