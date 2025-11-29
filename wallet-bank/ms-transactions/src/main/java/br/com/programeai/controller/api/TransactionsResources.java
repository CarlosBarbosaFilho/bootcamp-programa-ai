package br.com.programeai.controller.api;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsResources {

    TransactionConfirmedResponse performTransfer(TransactionTransfer request);

    TransactionConfirmedResponse performDeposit(TransactionDeposit request);

    TransactionConfirmedResponse performWithdraw(TransactionWithdraw request);

    BalanceWalletResponse checkBalance(String wallerNumber);

}
