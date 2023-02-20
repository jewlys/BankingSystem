package com.ironhack.BankingSystem.controllers;

import com.ironhack.BankingSystem.models.DTOs.AccountDTO;
import com.ironhack.BankingSystem.models.acc.Savings;
import com.ironhack.BankingSystem.repositories.accountRepos.SavingsRepository;
import com.ironhack.BankingSystem.repositories.userRepos.AccountHolderRepository;
import com.ironhack.BankingSystem.services.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SavingsController {
    @Autowired
    SavingsService savingsService;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    SavingsRepository savingsRepository;


    public void createSavings(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(Integer.valueOf(id)).isPresent()) {

            Savings savingsAccount = new Savings();

            savingsAccount.setBalance(accountDTO.getBalance());
            savingsAccount.setSecretKey(accountDTO.getSecretKey());
            savingsAccount.setPrimaryOwner(accountHolderRepository.findById(Integer.valueOf(id)).get());
            if (accountDTO.getSecondaryOwner() != null) {
                savingsAccount.setSecondaryOwner(accountDTO.getSecondaryOwner());}
            if (accountDTO.getMinimumBalance() != null) {
                savingsAccount.setMinimumBalance(accountDTO.getMinimumBalance());
            }
            savingsAccount.setCreationDate(accountDTO.getCreationDate());
            if (accountDTO.getInterestRate() == null) {

            } else {
                savingsAccount.setInterestRate(accountDTO.getInterestRate());
            }


            savingsRepository.save(savingsAccount);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "There is no record of an AccountHolder with this ID in the database");
        }
    }
}