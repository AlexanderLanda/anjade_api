package com.anjade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/sendCuestionarioEmail")
	public ResponseEntity<String> sendCuestionarioEmail(@RequestParam String toEmail,
			@RequestParam String idAfiliacion) {

		try {
			emailService.sendEmailCuestionario(toEmail, idAfiliacion);
			return ResponseEntity.ok("Email enviado correctamente.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error al enviar el correo: " + e.getMessage());
		}
	}

	@PostMapping("/send-error-email")
	public ResponseEntity<String> sendErrorEmail(@RequestBody Object request) {

		emailService.sendEmailError(request);

		return ResponseEntity.ok("Email enviado correctamente.");
	}
	
	@PostMapping("/send-payment-reminder")
	public ResponseEntity<String> sendPaymentReminderEmail(@RequestParam String toEmail,@RequestParam String idAfiliacion) {

		emailService.sendPaymentReminderEmail(toEmail,idAfiliacion);

		return ResponseEntity.ok("Email enviado correctamente.");
	}
	
}
