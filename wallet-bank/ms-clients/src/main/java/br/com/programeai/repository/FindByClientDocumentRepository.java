package br.com.programeai.repository;

import br.com.programeai.model.Client;

import java.util.List;

public interface FindByClientDocumentRepository {
    List<Client> getDocument(String document);
    Client getClient(Long id);

}
