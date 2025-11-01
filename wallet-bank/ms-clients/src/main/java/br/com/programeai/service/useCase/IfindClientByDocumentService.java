package br.com.programeai.service.useCase;

import br.com.programeai.service.domain.ClientDomain;

public interface IfindClientByDocumentService {

    ClientDomain getClientDocument(String document);
}
