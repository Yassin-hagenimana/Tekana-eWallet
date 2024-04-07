package com.example.tekanaewallet.services;

import com.example.tekanaewallet.models.Wallet;
import com.example.tekanaewallet.models.dtos.CreateWalletDTO;

import java.util.List;
import java.util.UUID;

public interface WalletService {
    List<Wallet> findByCustomerId(UUID customerId);

    Wallet createWallet(CreateWalletDTO dto);

    List<Wallet>getWallets();

    boolean deleteWallet(UUID id);
}
