package com.ironhack.BankingSystem.services;

import com.ironhack.BankingSystem.repositories.accountRepos.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckingService implements StudentCheckingServiceInterface {

    @Autowired
    StudentCheckingRepository studentCheckingRepository;


}