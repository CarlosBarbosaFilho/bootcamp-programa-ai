package br.com.programeai.controller;

import br.com.programeai.controller.request.WalletRequest;
import br.com.programeai.controller.response.WalletResponse;
import br.com.programeai.model.WalletStatus;
import br.com.programeai.service.CreateWalletsService;
import br.com.programeai.service.WalletsDomain;
import br.com.programeai.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class WalletsController implements  WalletsResource{

    private final CreateWalletsService service;
    private final Utils utils;

    @Override
    public WalletResponse create(WalletRequest request) {
        var domain = walletDomain(request);
        return walletResponse(this.service.create(domain));
    }

    private WalletsDomain walletDomain(WalletRequest walletRequest) {
        return WalletsDomain.builder()
                .walletNumber(walletRequest.getWalletNumber())
                .walletType(walletRequest.getWalletType())
                .client(walletRequest.getClient())
                .walletStatus(WalletStatus.ACTIVE)
                .balance(BigDecimal.ZERO)
                .createdAt(LocalDateTime.now())
                .build();
    }

    private WalletResponse walletResponse(WalletsDomain walletDomain) {
        return WalletResponse.builder()
                .id(walletDomain.getId())
                .client(walletDomain.getClient())
                .walletNumber(walletDomain.getWalletNumber())
                .walletStatus(walletDomain.getWalletStatus())
                .walletType(walletDomain.getWalletType())
                .balance(walletDomain.getBalance())
                .createdAt(utils.formatDate(walletDomain.getCreatedAt()))
                .build();
    }
}
