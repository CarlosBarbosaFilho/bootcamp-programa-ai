package br.com.programeai.service;

import br.com.programeai.repository.WalletsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.programeai.service.WalletsDomain.*;

@Service
@AllArgsConstructor
public class CreateWalletsUseCase implements CreateWalletsService {

    private final WalletsRepository repository;

    @Override
    public WalletsDomain create(WalletsDomain walletsDomain) {
        var walletsEntity = this.repository.save(createWalletEntity(walletsDomain));
        return createWalletDomain(walletsEntity);
    }
}
