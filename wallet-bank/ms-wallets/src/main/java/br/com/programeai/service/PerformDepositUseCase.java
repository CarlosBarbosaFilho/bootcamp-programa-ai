package br.com.programeai.service;

import br.com.programeai.repository.WalletsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class PerformDepositUseCase implements PerformDepositWalletUseCase {

    private final WalletsRepository walletsRepository;

    @Override
    public String performDeposit(String number, BigDecimal amount) {

        var wallet = walletsRepository.findByWalletNumber(number);
        if(wallet == null) {
            return "Wallet does not exists";
        }

        var newBalance = wallet.getBalance().add(amount);
        wallet.setBalance(newBalance);
        this.walletsRepository.save(wallet);
        return "Deposit successfully";
    }
}
