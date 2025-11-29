package br.com.programeai.service.useCase;

import br.com.programeai.repository.FindByClientDocumentRepository;
import br.com.programeai.service.domain.ClientDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByClientByIdUseCase implements  IFindClientByIdClient{

    private final FindByClientDocumentRepository findByClientDocumentRepository;
    
    @Override
    public ClientDomain getClientById(Long id) {
        var client = findByClientDocumentRepository.getClient(id);
        return  ClientDomain.createClientDomain(client);
    }
}
