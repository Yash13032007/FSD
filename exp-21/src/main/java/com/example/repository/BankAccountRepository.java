package com.example.repository;

import com.example.modelentity.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends MongoRepository <BankAccount,String> {
       BankAccount findByAccountNumber(String accountNumber);
}

    

