package com.ironhack.BankingSystem.controllers;
import com.ironhack.BankingSystem.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;
}