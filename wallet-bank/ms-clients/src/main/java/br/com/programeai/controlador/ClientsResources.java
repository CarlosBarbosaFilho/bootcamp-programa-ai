package br.com.programeai.controlador;

import br.com.programeai.rest.request.ClientRequest;
import br.com.programeai.rest.response.ClientResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients")
public interface ClientsResources {

    @PostMapping
    ClientResponse create(@Valid @RequestBody ClientRequest request);

//    @GetMapping
//    List<ClientResponse> list();

//    @GetMapping("/{id}")
//    ClientResponse getClient(@PathVariable("id") Long id);
//
//    @GetMapping("/email/{email}")
//    ClientResponse getClientEmail(@PathVariable("email") String email);
//
//    @GetMapping("/document/{document}")
//    ClientResponse getClientDocument(@PathVariable("document") String document);
//
//    @DeleteMapping("/{id}")
//    String deleteClient(@PathVariable("id") Long id);
}