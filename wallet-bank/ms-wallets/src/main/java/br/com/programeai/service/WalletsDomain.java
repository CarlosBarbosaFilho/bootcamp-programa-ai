package br.com.programeai.service;

import br.com.programeai.model.WalletEntity;
import br.com.programeai.model.WalletStatus;
import br.com.programeai.model.WalletType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WalletsDomain {

    private Long id;
    private String walletNumber;
    private WalletType walletType;
    private WalletStatus walletStatus;
    private BigDecimal balance;
    private Long client;
    private String clientDocument;
    private LocalDateTime createdAt;

    public static WalletEntity createWalletEntity(WalletsDomain walletsDomain) {
        return WalletEntity.builder()
                .walletNumber(walletsDomain.walletNumber)
                .walletType(walletsDomain.walletType)
                .walletStatus(walletsDomain.walletStatus)
                .balance(walletsDomain.balance)
                .client(walletsDomain.client)
                .clientDocument(walletsDomain.clientDocument)
                .createdAt(LocalDateTime.now().withNano(0))
                .build();
    }

    public static WalletsDomain createWalletDomain(WalletEntity wallet){
        return WalletsDomain.builder()
                .id(wallet.getId())
                .walletType(wallet.getWalletType())
                .walletNumber(wallet.getWalletNumber())
                .balance(wallet.getBalance())
                .clientDocument(wallet.getClientDocument())
                .client(wallet.getClient())
                .createdAt(wallet.getCreatedAt())
                .walletStatus(wallet.getWalletStatus())
                .build();
    }
}