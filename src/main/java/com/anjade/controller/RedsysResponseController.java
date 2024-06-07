package com.anjade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.service.EmailService;

@RestController
@RequestMapping("/api/v1/payment")
public class RedsysResponseController {
	
	@Autowired
    private EmailService emailService;
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
	@PostMapping("/response")
    public void handleResponse(@RequestBody String response) {
        // Lógica para manejar la respuesta de Redsys
        System.out.println("Response from Redsys: " + response);
        
    }
	
	@PostMapping("/redsysresponse")
    public void handleResponseRedsys(@RequestBody String response) {
        // Lógica para manejar la respuesta de Redsys
        System.out.println("Response from Redsys: " + response);
        emailService.sendWelcomeEmail("alexanderlandagrandales@gmail.com",response);
    }
}
