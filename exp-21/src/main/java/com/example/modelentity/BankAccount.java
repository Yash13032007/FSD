package com.example.modelentity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "accounts")
@Data
public class BankAccount {
    @Id
    private String id;
    private String accountNumber;
    private String accountHolderName;
    private double balance;
}
