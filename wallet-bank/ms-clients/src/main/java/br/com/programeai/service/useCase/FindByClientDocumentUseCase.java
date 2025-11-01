package br.com.programeai.service.useCase;

import br.com.programeai.mapper.ConverterMapper;
import br.com.programeai.repository.FindByClientDocumentRepository;
import br.com.programeai.service.domain.ClientDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindByClientDocumentUseCase implements  IfindClientByDocumentService{

    private final FindByClientDocumentRepository findByClientDocumentRepository;

    @Override
    public ClientDomain getClientDocument(String document) {
        var client =  findByClientDocumentRepository.getDocument(document).stream().findAny();
        return ClientDomain.createClientDomain(client.get());
    }
}
