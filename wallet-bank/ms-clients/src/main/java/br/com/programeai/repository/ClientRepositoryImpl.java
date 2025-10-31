package br.com.programeai.repository;


import br.com.programeai.model.Client;
import br.com.programeai.model.StatusClient;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.time.LocalDateTime;

@Service
public class ClientRepositoryImpl implements ClientRepository{
    private final DynamoDbTable<Client> clientTable;

    public ClientRepositoryImpl(DynamoDbEnhancedClient enhancedClient) {
        this.clientTable = enhancedClient.table("client", TableSchema.fromBean(Client.class));
    }

    public Client save(Client client) {
        client.setId(System.currentTimeMillis());
        client.setCreatedAt(LocalDateTime.now());
        client.setStatus(StatusClient.ACTIVE);
        clientTable.putItem(client);
        return client;
    }



}
