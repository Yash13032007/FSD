package com.example.service;

import com.example.modelentity.BankAccount;
import com.example.repository.BankAccountRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    // Create a new bank account
    public BankAccount createAccount(BankAccount bankAccount) {
       if (bankAccount == null || bankAccount.getAccountNumber() == null) { 
        throw new IllegalArgumentException("Bank account or account number cannot be null");
    }
    return bankAccountRepository.save(bankAccount);
  }

    // Get a bank account by its ID
    public BankAccount getAccountById(String id) { 
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
        return bankAccountRepository.findById(id).orElse(null);
    }

    // Update an existing bank account
    public boolean updateAccount(String id, BankAccount updatedAccount) {
        if (id == null || id.trim().isEmpty() || updatedAccount == null) { 
            throw new IllegalArgumentException("ID or account cannot be null or empty");
     }
     if (bankAccountRepository.existsById(id)) {
        updatedAccount.setId(id);
        bankAccountRepository.save(updatedAccount);
        return true;
       }
        return false;
    }

    // Delete a bank account by its ID
    public boolean deleteAccount(String id) {
         if (id == null || id.trim().isEmpty()) {
          throw new IllegalArgumentException("Account ID cannot be null or empty");
        }
         if (bankAccountRepository.existsById(id)) {
             bankAccountRepository.deleteById(id);
             return true;
        } 
        return false;
    }

    // Transfer money from one account to another
    @Transactional
     public boolean transferMoney(String fromAccountNumber, String toAccountNumber, double amount) {
       if (fromAccountNumber == null || toAccountNumber == null || amount <= 0) 
       {
           throw new IllegalArgumentException("Account numbers cannot be null and amount must be greater than zero"); 
        }

    BankAccount fromAccount = bankAccountRepository.findByAccountNumber(fromAccountNumber); 
    BankAccount toAccount = bankAccountRepository.findByAccountNumber(toAccountNumber);

    if (fromAccount == null || toAccount == null) {
      throw new IllegalArgumentException("One or both accounts not found");}
    if (fromAccount.getBalance() < amount) {
    throw new IllegalArgumentException("Insufficient funds"); }

    fromAccount.setBalance(fromAccount.getBalance() - amount); 
    toAccount.setBalance(toAccount.getBalance() + amount);

    bankAccountRepository.save(fromAccount); 
    bankAccountRepository.save(toAccount);

    return true;
   }
}
