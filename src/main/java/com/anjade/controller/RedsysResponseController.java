package com.anjade.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.service.EmailService;
import com.anjade.service.RedsysResponseNotification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/api/v1/payment")
public class RedsysResponseController {
	
	@Autowired
    private EmailService emailService;
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
	
	@PostMapping("/response")
    public void handleResponse(@RequestBody String response) throws JsonMappingException, JsonProcessingException {
        // Lógica para manejar la respuesta de Redsys
		/*Map<String, String> parseParameters = redsysResponseServiceNotification.parseParameters(response);
		parseParameters.forEach((key, value) -> System.out.println(key + ": " + value));
        String signatureVersion = parseParameters.get("Ds_SignatureVersion");
        String merchantParameters = parseParameters.get("Ds_MerchantParameters");
        String signature = parseParameters.get("Ds_Signature");*/
        
       // redsysResponseServiceNotification.readNotificatinoRedsysResponse(merchantParameters);
        
    }
	
	@PostMapping("/redsysresponse")
    public void handleResponseRedsys(@RequestBody String response) {
        // Lógica para manejar la respuesta de Redsys
        System.out.println("Response from Redsys: " + response);
       
        emailService.sendRedsysResponseEmail("alexanderlandagrandales@gmail.com",response);
    }
}
