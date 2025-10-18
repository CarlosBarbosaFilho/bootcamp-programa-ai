package br.com.programeai.repository;

import br.com.programeai.model.Client;

import java.util.List;

public interface ClientRepository {
    Client save(Client client);
    List<Client> list();
    Client getClient(Long id);
    void deleteClient(Long id);
    List<Client> findByEmail(String email);
    List<Client> findByDocument(String document);
}
