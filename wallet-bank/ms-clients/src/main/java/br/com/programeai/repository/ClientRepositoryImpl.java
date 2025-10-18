package br.com.programeai.repository;

import br.com.programeai.model.Client;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository{
    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public List<Client> list() {
        return List.of();
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public List<Client> findByEmail(String email) {
        return List.of();
    }

    @Override
    public List<Client> findByDocument(String document) {
        return List.of();
    }
}
