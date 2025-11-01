package br.com.programeai.repository;

import br.com.programeai.model.Client;
import br.com.programeai.model.StatusClient;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.List;

@Service
public class FindClientByDocumentRepository implements FindByClientDocumentRepository {

    private final DynamoDbTable<Client> clientTable;

    public FindClientByDocumentRepository(DynamoDbEnhancedClient enhancedClient) {
        this.clientTable = enhancedClient.table("client", TableSchema.fromBean(Client.class));
    }

    @Override
    public List<Client> getDocument(String document) {
        QueryConditional condition = QueryConditional.keyEqualTo(
                Key.builder().partitionValue(document).build()
        );

        QueryEnhancedRequest request = QueryEnhancedRequest.builder()
                .queryConditional(condition)
                .build();

        return clientTable.index("document-index")
                .query(request)
                .stream()
                .flatMap(page -> page.items().stream())
                .filter(c -> !c.getStatus().equals(StatusClient.INACTIVE))
                .toList();
    }
}
