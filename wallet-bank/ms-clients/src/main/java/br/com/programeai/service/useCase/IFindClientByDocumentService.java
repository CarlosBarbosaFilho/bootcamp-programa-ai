package br.com.programeai.service.useCase;

import br.com.programeai.service.domain.ClientDomain;

public interface IFindClientByDocumentService {

    ClientDomain getClientDocument(String document);
}
