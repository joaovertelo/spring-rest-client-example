package com.devertelo.springrestclientexample.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface CepService {

    @GetExchange("/{cep}/json")
    Endereco get(@PathVariable String cep);
}
