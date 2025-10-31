package br.com.programeai.service.useCase;

import br.com.programeai.service.domain.ClientDomain;
import org.springframework.stereotype.Service;


public interface ICreateClientUseCase {
    ClientDomain execute(ClientDomain clientDomain);
}
