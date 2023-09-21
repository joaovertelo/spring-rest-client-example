package com.devertelo.springrestclientexample;

import com.devertelo.springrestclientexample.controller.CepService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.create("https://viacep.com.br/ws");
    }
    @Bean
    CepService cepService() {
        var factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient()))
                .build();
        return factory.createClient(CepService.class);
    }
}
