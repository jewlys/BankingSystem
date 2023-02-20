package com.ironhack.BankingSystem.services;

import com.ironhack.BankingSystem.models.DTOs.AccountDTO;
import com.ironhack.BankingSystem.models.Users.AccountHolder;
import com.ironhack.BankingSystem.models.acc.Checking;
import com.ironhack.BankingSystem.models.acc.StudentChecking;
import com.ironhack.BankingSystem.repositories.accountRepos.CheckingRepository;
import com.ironhack.BankingSystem.repositories.accountRepos.StudentCheckingRepository;
import com.ironhack.BankingSystem.repositories.userRepos.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class CheckingService implements CheckingServiceInterface {
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    StudentCheckingRepository tudentCheckingRepository;

    public void createChecking(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(Integer.valueOf(id)).isPresent()) {

            LocalDate today = LocalDate.now();

            BigDecimal balance = accountDTO.getBalance();
            String secretKey = accountDTO.getSecretKey();
            AccountHolder primaryOwner = accountHolderRepository.findById(Integer.valueOf(id)).get();
            AccountHolder secondaryOwner = accountDTO.getSecondaryOwner();
            BigDecimal minimumBalance = accountDTO.getMinimumBalance();
            LocalDate creationDate;
            if (accountDTO.getCreationDate() != null) {
                creationDate = accountDTO.getCreationDate();
            } else {
                creationDate = today;
            }

            LocalDate dateOfBirth = primaryOwner.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (dateOfBirth.isAfter(today.minusYears(24))) {
                StudentChecking studentChecking = new StudentChecking(balance, primaryOwner, secondaryOwner, creationDate, secretKey);
                tudentCheckingRepository.save(studentChecking);
            } else {
                Checking checkingAccount = new Checking(balance, secretKey, primaryOwner, secondaryOwner, creationDate);
                if (minimumBalance != null) {
                    checkingAccount.getBalance();
                }
                checkingRepository.save(checkingAccount);
            }

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exist in the database");
        }
    }
}



