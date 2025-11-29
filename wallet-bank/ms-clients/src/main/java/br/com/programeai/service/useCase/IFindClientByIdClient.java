package br.com.programeai.service.useCase;

import br.com.programeai.service.domain.ClientDomain;

public interface IFindClientByIdClient {

    ClientDomain getClientById(Long id);
}
