package br.com.programeai.service.domain;

import br.com.programeai.model.Client;
import br.com.programeai.model.StatusClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDomain {

    private Long id;
    private String name;
    private String email;
    private String document;
    private BigDecimal income;
    private LocalDateTime createdAt;
    private StatusClient status;

    public static ModelMapper converterMapper() {
        return new ModelMapper();
    }

    public static Client createClient(ClientDomain clientDomain) {
        return ClientDomain.converterMapper().map(clientDomain, Client.class);
    }

    public static ClientDomain createClientDomain(Client client) {
        return ClientDomain.converterMapper().map(client, ClientDomain.class);
    }
}
