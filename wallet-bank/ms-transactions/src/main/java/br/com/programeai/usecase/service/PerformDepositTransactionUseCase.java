package br.com.programeai.usecase.service;

import br.com.programeai.usecase.domain.TransactionDomain;

public interface PerformDepositTransactionUseCase {

    TransactionDomain deposit(TransactionDomain transactionDomain);
}
