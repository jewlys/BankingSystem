package com.ironhack.BankingSystem.services;

import com.ironhack.BankingSystem.models.DTOs.AccountDTO;
import com.ironhack.BankingSystem.models.acc.Account;
import com.ironhack.BankingSystem.models.acc.Checking;
import com.ironhack.BankingSystem.models.acc.Savings;
import com.ironhack.BankingSystem.repositories.accountRepos.AccountRepository;
import com.ironhack.BankingSystem.repositories.accountRepos.CheckingRepository;
import com.ironhack.BankingSystem.repositories.accountRepos.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CheckingService checkingService;
    @Autowired
    private SavingsService savingsService;
    @Autowired
    private CreditCardService creditCardService;

    @Override
    public boolean transferMoney(Integer senderAccountId, String receiverName, Integer receiverAccountId, BigDecimal amount) {
        Optional<Account> receiverAccount = accountRepository.findByAccountIdAndPrimaryOwnerName(receiverAccountId, receiverName);
        Optional<Account> senderAccount = accountRepository.findByAccountId(senderAccountId);
        if(receiverAccount.isPresent() && senderAccount.isPresent()) {
            senderAccount.get().transferMoney(receiverAccount.get(), amount);
            accountRepository.save(senderAccount.get());
            accountRepository.save(receiverAccount.get());
        }

        return receiverAccount.isPresent() && senderAccount.isPresent();
    }

    @Override
    public List<Account> getAllAccountsById(Integer userId) {
        return accountRepository.findAllByPrimaryOwnerUserId(userId);
    }

    public void createAccount(String accountType, String id, AccountDTO accountDTO) {

        switch (accountType) {
            case "checking" -> {
                checkingService.createCheckingAccount(accountDTO, id);
                break;
            }
            case "savings" -> {
                savingsService.createSavingsAccount(accountDTO, id);
                break;
            }
            case "credit" -> {
                creditCardService.createCreditCardAccount(accountDTO, id);
                break;
            }
            default -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The account type is not valid, please re-try.");
            }

        }
    }
}