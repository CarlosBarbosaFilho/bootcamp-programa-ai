package br.com.programeai.controller.api;

import br.com.programeai.controller.api.request.TransactionDeposit;
import br.com.programeai.controller.api.request.TransactionTransfer;
import br.com.programeai.controller.api.request.TransactionWithdraw;
import br.com.programeai.controller.api.response.BalanceWalletResponse;
import br.com.programeai.controller.api.response.TransactionConfirmedResponse;

public interface TransactionsResources {

    TransactionConfirmedResponse performTransfer(TransactionTransfer request);

    TransactionConfirmedResponse performDeposit(TransactionDeposit request);

    TransactionConfirmedResponse performWithdraw(TransactionWithdraw request);

    BalanceWalletResponse checkBalance(String wallerNumber);

}
