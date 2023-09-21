package com.devertelo.springrestclientexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController()
public class EnderecoController {

    private final RestClient restClient;
    private final CepService cepService;

    public EnderecoController(RestClient restClient, CepService cepService) {
        this.restClient = restClient;
        this.cepService = cepService;
    }

    @GetMapping("{cep}")
    public ResponseEntity<Endereco> get(@PathVariable String cep) {
        var endereco = restClient.get().uri("/{cep}/json", cep)
                .retrieve()
                .body(Endereco.class);

        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/interface/{cep}")
    public ResponseEntity<Endereco> getByInterface(@PathVariable String cep) {
        var endereco = cepService.get(cep);

        return ResponseEntity.ok(endereco);
    }
}
