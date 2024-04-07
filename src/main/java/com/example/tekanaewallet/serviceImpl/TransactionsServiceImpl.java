package com.example.tekanaewallet.serviceImpl;

import com.example.tekanaewallet.models.Transactions;
import com.example.tekanaewallet.models.Wallet;
import com.example.tekanaewallet.models.dtos.CreateTransactionDTO;
import com.example.tekanaewallet.repositories.CustomerTransactionsRepository;
import com.example.tekanaewallet.repositories.WalletsRepository;
import com.example.tekanaewallet.services.TransactionsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    private final WalletsRepository walletsRepository;

    private final CustomerTransactionsRepository transactionsRepository;

    public TransactionsServiceImpl(WalletsRepository walletsRepository, CustomerTransactionsRepository transactionsRepository) {
        this.walletsRepository = walletsRepository;
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public List<Transactions> findByWalletId(UUID walletId) {
        return transactionsRepository.findByWalletId(walletId);
    }

    @Override
    public Transactions createTransaction(CreateTransactionDTO dto) {
        Transactions transactions = new Transactions();
        Wallet foundWallet = walletsRepository.findById(dto.getWalletId()).orElseThrow();
        transactions.setAmount(dto.getAmount());
        transactions.setWallet(foundWallet);
        return transactionsRepository.save(transactions);

    }

    @Override
    public Transactions getTransactionById(UUID id) {
        return transactionsRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Transactions> getTransactions() {
        return transactionsRepository.findAll();
    }


}
