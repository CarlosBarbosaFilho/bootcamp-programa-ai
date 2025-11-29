package br.com.programeai.controller.api;

import br.com.programeai.controller.api.request.TransactionDeposit;
import br.com.programeai.controller.api.request.TransactionTransfer;
import br.com.programeai.controller.api.request.TransactionWithdraw;
import br.com.programeai.controller.api.response.BalanceWalletResponse;
import br.com.programeai.controller.api.response.TransactionConfirmedResponse;
import br.com.programeai.usecase.service.PerformDepositTransactionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransactionController implements TransactionsResources {

    private final PerformDepositTransactionUseCase performDepositTransactionUseCase;
//    private final PerformTransferTransactionUseCase performTransferTransactionUseCase;
//    private final PerformWithdrawTransactionUseCase performWithdrawTransactionUseCase;
//    private final PerformCheckBalanceTransactionUseCase performCheckBalanceTransactionUseCase;

    @Override
    public TransactionConfirmedResponse performTransfer(TransactionTransfer request) {
        return null;
    }

    @Override
    public TransactionConfirmedResponse performDeposit(TransactionDeposit request) {
        return null;
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
