package com.ironhack.BankingSystem.controllers;

import com.ironhack.BankingSystem.models.DTOs.AccountDTO;
import com.ironhack.BankingSystem.models.acc.Account;
import com.ironhack.BankingSystem.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    // POST /accounts
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody AccountDTO accountDTO) throws Exception {
        return accountService.createAccount(accountDTO);
    }

    // GET /accounts
    @GetMapping("")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // GET /accounts/{id}
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // PUT /accounts/{id}
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) throws Exception {
        return accountService.updateAccount(id, accountDTO);
    }

    // DELETE /accounts/{id}
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
