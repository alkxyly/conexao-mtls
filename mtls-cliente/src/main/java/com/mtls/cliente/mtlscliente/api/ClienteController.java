package com.mtls.cliente.mtlscliente.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private static final String SERVER_URL = "https://localhost:8443/api/servidor";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello(){
        String response = restTemplate.getForObject(SERVER_URL, String.class);
        return response;
    }
}
