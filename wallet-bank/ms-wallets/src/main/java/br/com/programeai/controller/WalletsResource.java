package br.com.programeai.controller;

import br.com.programeai.controller.request.WalletRequest;
import br.com.programeai.controller.response.WalletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/wallets")
public interface WalletsResource {

    @PostMapping
    WalletResponse create(@Valid @RequestBody WalletRequest request);

}
