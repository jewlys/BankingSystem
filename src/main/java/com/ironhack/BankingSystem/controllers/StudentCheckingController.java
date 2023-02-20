package com.ironhack.BankingSystem.controllers;

import com.ironhack.BankingSystem.services.StudentCheckingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCheckingController {
    StudentCheckingService studentCheckingService;
}
