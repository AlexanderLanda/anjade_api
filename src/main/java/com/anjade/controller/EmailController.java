package com.anjade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.entity.EmailRequest;
import com.anjade.service.EmailService;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

	
	@Autowired
	private EmailService emailService;

	@PostMapping("/sendWelcomeEmail")
	public ResponseEntity<String> sendWelcomeEmail(@RequestBody EmailRequest request) {
		String toEmail = request.getToEmail();
		String idAfiliacion = request.getIdAfiliacion();

		emailService.sendWelcomeEmail(toEmail, idAfiliacion);

		return ResponseEntity.ok("Email enviado correctamente.");
	}
	
	@PostMapping("/send-error-email")
	public ResponseEntity<String> sendErrorEmail(@RequestBody Object request) {

		emailService.sendEmailError(request);

		return ResponseEntity.ok("Email enviado correctamente.");
	}
}
