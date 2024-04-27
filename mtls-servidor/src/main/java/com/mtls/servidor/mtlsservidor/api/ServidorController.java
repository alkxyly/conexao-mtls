package com.mtls.servidor.mtlsservidor.api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/servidor")
public class ServidorController {

    @GetMapping
    public String hello(Model model, Principal principal){
        /**
         * UserDetails currentUser
         *                 = (UserDetails) ((Authentication) principal).getPrincipal();
         *         model.addAttribute("username", currentUser.getUsername());
         */
        return "Conexão OK";
    }
}
