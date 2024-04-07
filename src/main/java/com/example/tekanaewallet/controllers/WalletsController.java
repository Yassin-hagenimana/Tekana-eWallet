package com.example.tekanaewallet.controllers;


import com.example.tekanaewallet.models.Wallet;
import com.example.tekanaewallet.models.dtos.CreateWalletDTO;
import com.example.tekanaewallet.services.WalletService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
@Validated
public class WalletsController {

    private final WalletService walletService;

    public WalletsController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/customer/{customerId}")
    public List<Wallet> getWalletsByCustomerId(@PathVariable UUID customerId) {
        return walletService.findByCustomerId(customerId);
    }
    @GetMapping("/all")
    public List<Wallet> getWallets() {
        return walletService.getWallets();
    }

    @PostMapping("/save")
    public Wallet createWallet(@RequestBody CreateWalletDTO wallet) {
        return walletService.createWallet(wallet);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteWallet(@PathVariable UUID id) {
        return walletService.deleteWallet(id);
    }
}
