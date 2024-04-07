package com.example.tekanaewallet.controllers;


import com.example.tekanaewallet.models.Transactions;
import com.example.tekanaewallet.models.dtos.CreateTransactionDTO;
import com.example.tekanaewallet.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@Validated
public class TransactionsController {


    private final TransactionsService transactionsService;

    @Autowired
    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/wallet/{walletId}")
    public List<Transactions> getTransactionsByWalletId(@PathVariable UUID walletId) {
        return transactionsService.findByWalletId(walletId);
    }

    @PostMapping("/save")
    public Transactions createTransaction(@RequestBody CreateTransactionDTO transaction) {
        return transactionsService.createTransaction(transaction);
    }

    @GetMapping("/{id}")
    public Transactions getTransactionById(@PathVariable UUID id) {
        return transactionsService.getTransactionById(id);
    }

    @GetMapping("/all")
    public List<Transactions> getTransactions() {
        return transactionsService.getTransactions();
    }

}
