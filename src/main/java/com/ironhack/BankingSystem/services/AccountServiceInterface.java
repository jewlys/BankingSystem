package com.ironhack.BankingSystem.services;

import com.ironhack.BankingSystem.models.acc.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountServiceInterface {

    boolean transferMoney(Integer senderAccount, String receiverName, Integer receiverAccountId, BigDecimal amount) throws MoneyTransferException;

    List<Account> getAllAccountsById(Integer userId);

    class MoneyTransferException extends Exception {
    }
}