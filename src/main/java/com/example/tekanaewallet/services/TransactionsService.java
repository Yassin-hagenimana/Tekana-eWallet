package com.example.tekanaewallet.services;

import com.example.tekanaewallet.models.Transactions;
import com.example.tekanaewallet.models.dtos.CreateTransactionDTO;

import java.util.List;
import java.util.UUID;

public interface TransactionsService {
    List<Transactions> findByWalletId(UUID walletId);

    Transactions createTransaction(CreateTransactionDTO dto);

    Transactions getTransactionById(UUID id);

    List<Transactions> getTransactions();


}
