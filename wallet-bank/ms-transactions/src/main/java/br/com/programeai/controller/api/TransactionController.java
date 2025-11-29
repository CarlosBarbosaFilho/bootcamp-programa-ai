package br.com.programeai.controller.api;

import br.com.programeai.controller.api.request.TransactionDeposit;
import br.com.programeai.controller.api.request.TransactionTransfer;
import br.com.programeai.controller.api.request.TransactionWithdraw;
import br.com.programeai.controller.api.response.BalanceWalletResponse;
import br.com.programeai.controller.api.response.TransactionConfirmedResponse;
import br.com.programeai.mapper.ConverterMapper;
import br.com.programeai.usecase.domain.TransactionDomain;
import br.com.programeai.usecase.domain.TypeTransaction;
import br.com.programeai.usecase.service.PerformDepositTransactionUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@AllArgsConstructor
public class TransactionController implements TransactionsResources {

    private final PerformDepositTransactionUseCase performDepositTransactionUseCase;
    private final ConverterMapper converterMapper;
//    private final PerformTransferTransactionUseCase performTransferTransactionUseCase;
//    private final PerformWithdrawTransactionUseCase performWithdrawTransactionUseCase;
//    private final PerformCheckBalanceTransactionUseCase performCheckBalanceTransactionUseCase;

    @Override
    public TransactionConfirmedResponse performTransfer(TransactionTransfer request) {
      return null;
    }

    @Override
    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionConfirmedResponse performDeposit(@Valid @RequestBody TransactionDeposit request) {
        var domain = (TransactionDomain) this.converterMapper.convertObject(request, TransactionDomain.class);
        domain.setTypeTransaction(TypeTransaction.DEPOSIT);
        this.performDepositTransactionUseCase.deposit(domain);
        return TransactionConfirmedResponse.builder()
                .message("Deposit successfully")
                .codeTransaction(UUID.randomUUID())
                .build();
    }

    @Override
    public TransactionConfirmedResponse performWithdraw(TransactionWithdraw request) {
        return null;
    }

    @Override
    public BalanceWalletResponse checkBalance(String wallerNumber) {
        return null;
    }
}
