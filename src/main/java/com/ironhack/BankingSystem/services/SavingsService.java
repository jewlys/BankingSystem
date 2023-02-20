package com.ironhack.BankingSystem.services;

import com.ironhack.BankingSystem.models.DTOs.AccountDTO;
import com.ironhack.BankingSystem.models.acc.Savings;
import com.ironhack.BankingSystem.repositories.accountRepos.SavingsRepository;
import com.ironhack.BankingSystem.repositories.userRepos.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public void createSavings(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(Integer.valueOf(id)).isPresent()) {

            Savings savingsAccount = new Savings();
            /*
            else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Missing parameters to properly create a Savings Account");
            }
            */

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
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }
}