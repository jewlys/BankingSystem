package com.ironhack.BankingSystem.controllers;

import com.ironhack.BankingSystem.services.CheckingService;
import com.ironhack.BankingSystem.services.StudentCheckingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingController {
    @Autowired
    CheckingService checkingService;


    @Autowired
    StudentCheckingService studentCheckingService;


}