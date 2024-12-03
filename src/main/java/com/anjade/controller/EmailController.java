package com.anjade.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.EmailRequest;
import com.anjade.service.EmailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            @RequestParam("recipients") String recipientsJson,
            @RequestParam(value = "attachments", required = false) MultipartFile[] attachments) {
        try {
            List<String> recipients = new ObjectMapper().readValue(recipientsJson, new TypeReference<List<String>>() {});
            emailService.sendEmail(subject, body, recipients, attachments);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	// Endpoint para enviar recordatorio de pago a todos los usuarios con estado pendiente
    @PostMapping("/sendPaymentReminderEmail")
    public String sendPaymentReminderEmails(@RequestBody Map<String, Long> payload) {
        Long estadoPendienteId = payload.get("estadoPendienteId");
        // Llamamos al servicio para enviar los correos a todos los usuarios con el estado pendiente de pago
        try {
            emailService.sendPaymentRemindersToAll(estadoPendienteId);
            return "Recordatorios de pago enviados con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            return "Hubo un error al enviar los correos";
        }
    }
	
}
