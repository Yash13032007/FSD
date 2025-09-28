package com.example.controller;

import com.example.modelentity.TransferRequest;
import com.example.modelentity.BankAccount;
import com.example.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bankoperations")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    // Create Account
    @PostMapping("/accounts")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount bankAccount) {
        try {
            BankAccount createdAccount = bankAccountService.createAccount(bankAccount);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Get Account by ID
    @GetMapping("/accounts/{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable String id) {
        try {
            BankAccount account = bankAccountService.getAccountById(id);
            if (account != null) {
                return ResponseEntity.ok(account);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Update Account
    @PutMapping("/accounts/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable String id,
                                                @RequestBody BankAccount updatedAccount) {
        try {
            boolean success = bankAccountService.updateAccount(id, updatedAccount);
            if (success) {
                return ResponseEntity.ok("Account updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred: " + e.getMessage());
        }
    }

    // Delete Account
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        try {
            boolean success = bankAccountService.deleteAccount(id);
            if (success) {
                return ResponseEntity.ok("Account deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
            } 
        } catch  (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured:" + e.getMessage());
        }
    }  
    
    // Transfer Money
    @PostMapping("/transfers")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest transferRequest) {
        try {
            boolean success = bankAccountService.transferMoney(
                    transferRequest.getFromAccountNumber(),
                    transferRequest.getToAccountNumber(),
                    transferRequest.getAmount()
            );

            if (success) {
                return ResponseEntity.ok("Transfer successful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transfer failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred: " + e.getMessage());
        }
    }
}
