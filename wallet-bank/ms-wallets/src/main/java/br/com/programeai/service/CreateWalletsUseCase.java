package br.com.programeai.service;

import br.com.programeai.repository.WalletsRepository;
import br.com.programeai.service.client.GetClientToWallet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.programeai.service.WalletsDomain.*;

@Service
@AllArgsConstructor
public class CreateWalletsUseCase implements CreateWalletsService {

    private final WalletsRepository repository;
    private final GetClientToWallet getClientToWallet;

    @Override
    public WalletsDomain create(WalletsDomain walletsDomain) {

        var client = getClientToWallet.clientToWallet(walletsDomain.getClient());
        walletsDomain.setClient(client.getId());
        walletsDomain.setClientDocument(client.getDocument());
        var walletsEntity = this.repository.save(createWalletEntity(walletsDomain));
        return createWalletDomain(walletsEntity);
    }
}
