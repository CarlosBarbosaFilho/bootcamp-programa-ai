package br.com.programeai.controller.response;

import br.com.programeai.model.WalletStatus;
import br.com.programeai.model.WalletType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse {

    private Long id;
    private String walletNumber;
    private WalletType walletType;
    private WalletStatus walletStatus;
    private BigDecimal balance;
    private String createdAt;
    private Long client;
}
