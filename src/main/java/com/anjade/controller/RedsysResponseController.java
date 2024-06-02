package com.anjade.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class RedsysResponseController {
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
	@PostMapping("/response")
    public void handleResponse(@RequestBody String response) {
        // Lógica para manejar la respuesta de Redsys
        System.out.println("Response from Redsys: " + response);
    }
}
