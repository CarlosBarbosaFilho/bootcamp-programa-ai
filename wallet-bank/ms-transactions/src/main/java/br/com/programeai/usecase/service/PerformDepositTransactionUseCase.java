package br.com.programeai.usecase.service;

import br.com.programeai.model.TransactionEntity;
import br.com.programeai.usecase.domain.TransactionDomain;

public interface PerformDepositTransactionUseCase {

    TransactionEntity deposit(TransactionDomain transactionDomain);
}
