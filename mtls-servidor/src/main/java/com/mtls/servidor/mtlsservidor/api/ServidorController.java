package com.mtls.servidor.mtlsservidor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servidor")
public class ServidorController {

    @GetMapping
    public String conectar(){
        return "Conexão Servidor OK";
    }
}
