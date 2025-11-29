package br.com.programeai.usecase.service.impl;

import br.com.programeai.model.TransactionEntity;
import br.com.programeai.repository.TransactionRepository;
import br.com.programeai.usecase.domain.TransactionDomain;
import br.com.programeai.usecase.service.PerformDepositTransactionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PerformDepositTransactionUseCaseImpl implements PerformDepositTransactionUseCase {
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionEntity deposit(TransactionDomain transactionDomain) {
        var entity = TransactionEntity.builder()
                .typeTransaction(transactionDomain.getTypeTransaction())
                .amountTransaction(transactionDomain.getAmountTransaction())
                .codeTransaction(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .currentBalanceDestinationWallet(BigDecimal.TEN)
                .currentBalanceDestinationWallet(BigDecimal.TEN)
                .sourceWallet(transactionDomain.getSourceWallet())
                .destinationWallet(transactionDomain.getDestinationWallet())
                .emailSourceWallet("carlos@gmail.com")
                .build();
        return this.transactionRepository.save(entity);

    }
}
