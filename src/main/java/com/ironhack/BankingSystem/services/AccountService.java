package com.ironhack.BankingSystem.services;

import com.ironhack.BankingSystem.models.DTOs.AccountDTO;
import com.ironhack.BankingSystem.models.acc.Account;
import com.ironhack.BankingSystem.repositories.accountrRepos.AccountRepository;
import com.ironhack.BankingSystem.repositories.accountrRepos.CheckingRepository;
import com.ironhack.BankingSystem.repositories.accountrRepos.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private SavingsRepository savingsRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return account.get();
        } else {
            throw new AccountNotFoundException("Account not found with id " + id);
        }
    }

    public Account createAccount(AccountDTO accountDTO) {
        Account account;
        switch (accountDTO.getAccountType()) {
            case CHECKING:
                account = new Checking(accountDTO.getBalance(), accountDTO.getSecretKey(), accountDTO.getPrimaryOwner(), accountDTO.getSecondaryOwner());
                account.setCreationDate(LocalDateTime.now());
                ((Checking) account).setMinimumBalance(accountDTO.getMinimumBalance());
                return checkingRepository.save((Checking) account);
            case SAVINGS:
                account = new Savings(accountDTO.getBalance(), accountDTO.getSecretKey(), accountDTO.getPrimaryOwner(), accountDTO.getSecondaryOwner());
                account.setCreationDate(LocalDateTime.now());
                ((Savings) account).setInterestRate(accountDTO.getInterestRate());
                return savingsRepository.save((Savings) account);
            case CREDIT_CARD:
                account = new CreditCard(accountDTO.getBalance(), accountDTO.getSecretKey(), accountDTO.getPrimaryOwner(), accountDTO.getSecondaryOwner());
                account.setCreationDate(LocalDateTime.now());
                ((CreditCard) account).setCreditLimit(accountDTO.getCreditLimit());
                return accountRepository.save(account);
            case STUDENT_CHECKING:
                account = new StudentChecking(accountDTO.getBalance(), accountDTO.getSecretKey(), accountDTO.getPrimaryOwner(), accountDTO.getSecondaryOwner());
                account.setCreationDate(LocalDateTime.now());
                return accountRepository.save(account);
            default:
                throw new InvalidAccountTypeException("Invalid account type");
        }
    }

    public void updateBalance(Long accountId, MoneyDto moneyDto) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance().increaseAmount(moneyDto.getAmount()));
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException("Account not found with id " + accountId);
        }
    }
}
