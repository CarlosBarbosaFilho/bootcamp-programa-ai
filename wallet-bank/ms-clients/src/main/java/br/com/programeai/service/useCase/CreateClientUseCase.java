package br.com.programeai.service.useCase;

import br.com.programeai.repository.ClientRepository;
import br.com.programeai.service.domain.ClientDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.programeai.service.domain.ClientDomain.createClient;
import static br.com.programeai.service.domain.ClientDomain.createClientDomain;
@Service
@AllArgsConstructor
public class CreateClientUseCase implements ICreateClientUseCase {

    private final ClientRepository createClientRepository;


    @Override
    public ClientDomain execute(ClientDomain clientDomain) {
        var createEntity = createClient(clientDomain);
        var client = createClientRepository.save(createEntity);
        return createClientDomain(client);
    }


}