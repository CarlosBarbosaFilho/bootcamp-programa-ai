package br.com.programeai.service;

import java.math.BigDecimal;

public interface PerformDepositWalletUseCase {

    String performDeposit(String number, BigDecimal amount);
}
