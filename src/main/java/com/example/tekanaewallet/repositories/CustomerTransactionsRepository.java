package com.example.tekanaewallet.repositories;

import com.example.tekanaewallet.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerTransactionsRepository extends JpaRepository<Transactions, UUID> {
    List<Transactions> findByWalletId(UUID walletId);
}
