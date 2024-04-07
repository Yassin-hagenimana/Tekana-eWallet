package com.example.tekanaewallet.serviceImpl;

import com.example.tekanaewallet.exceptions.WalletNotFoundException;
import com.example.tekanaewallet.models.Customer;
import com.example.tekanaewallet.models.Wallet;
import com.example.tekanaewallet.models.dtos.CreateWalletDTO;
import com.example.tekanaewallet.repositories.CustomersRepository;
import com.example.tekanaewallet.repositories.WalletsRepository;
import com.example.tekanaewallet.services.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletsRepository walletsRepository;
    private final CustomersRepository customersRepository;

    public WalletServiceImpl(WalletsRepository walletsRepository, CustomersRepository customersRepository) {
        this.walletsRepository = walletsRepository;
        this.customersRepository = customersRepository;
    }

    @Override
    public List<Wallet> findByCustomerId(UUID customerId) {
        return walletsRepository.findByCustomerId(customerId);
    }

    @Override
    public Wallet createWallet(CreateWalletDTO dto) {
        Wallet wallet = new Wallet();
        Customer foundCustomer = customersRepository.findById(dto.getCustomerId()).orElseThrow();
        wallet.setCustomer(foundCustomer);
        wallet.setBalance(dto.getBalance());
        return walletsRepository.save(wallet);
    }

    @Override
    public List<Wallet> getWallets() {
        return walletsRepository.findAll();
    }

    @Override
    public boolean deleteWallet(UUID id) {
        Optional<Wallet> foundWallet = walletsRepository.findById(id);
        if (foundWallet.isEmpty()) {
            throw new WalletNotFoundException("Wallet not found");
        } else {
            if (foundWallet.get().getBalance() > 0) {
                throw new WalletNotFoundException("Wallet has balance");
            }else {
                walletsRepository.delete(foundWallet.get());
                return true;
            }
        }

    }
}
