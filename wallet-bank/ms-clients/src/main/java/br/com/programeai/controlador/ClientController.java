package br.com.programeai.controlador;

import br.com.programeai.mapper.ConverterMapper;
import br.com.programeai.rest.request.ClientRequest;
import br.com.programeai.rest.response.ClientResponse;
import br.com.programeai.service.domain.ClientDomain;
import br.com.programeai.service.useCase.ICreateClientUseCase;
import br.com.programeai.service.useCase.IFindClientByDocumentService;
import br.com.programeai.service.useCase.IFindClientByIdClient;
import br.com.programeai.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController implements ClientsResources {

    private final Utils utils;

    private final ICreateClientUseCase createClientService;
    private final IFindClientByDocumentService ifindClientByDocumentService;
    private final IFindClientByIdClient iFindClientByIdClient;

    private final ConverterMapper converterMapper;

    @Override
    public ClientResponse create(ClientRequest request) {

        return createResponse(this.createClientService.execute(createDomain(request)));
    }

//    @Override
//    public List<ClientResponse> list() {
//        return listAllClientsService.listAll().stream().map(this::createResponse).toList();
//    }
//
    @Override
    public ClientResponse getClient(Long id) {
        return createResponse(this.iFindClientByIdClient.getClientById(id));
    }
//
//    @Override
//    public ClientResponse getClientEmail(String email) {
//        return createResponse(this.findClientByEmailService.find(email));
//    }
//
    @Override
    public ClientResponse getClientDocument(String document) {
        return createResponse(this.ifindClientByDocumentService.getClientDocument(document));
    }
//
//    @Override
//    public String deleteClient(Long id) {
//        return deleteClientByIdService.delete(id);
//    }

    private ClientDomain createDomain(ClientRequest request) {
        return (ClientDomain) this.converterMapper.convertObject(request, ClientDomain.class);
    }

    private ClientResponse createResponse(ClientDomain domain) {
        var response = (ClientResponse) this.converterMapper.convertObject(domain, ClientResponse.class);
        response.setCreatedAt(utils.formatDate(domain.getCreatedAt()));
        return response;
    }
}