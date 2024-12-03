package com.anjade.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.ReportDto;

public interface EmailService {

	 public default void sendWelcomeEmail(String toEmail, String idAfiliacion) {}
	 
	 public default void sendRedsysResponseEmail(String toEmail, String idAfiliacion) {}

	void sendEmailConfirmacionPago(String toEmail, String idAfiliacion);

	void sendEmailError(Object error);
	
	 void sendEmailDePagoRechazado(String toEmail, String idAfiliacion) ;
	 
	void sendEmailCuestionario(String toEmail, String idAfiliacion);
	
	default void sendPaymentReminderEmail(String toEmail, String idAfiliacion) {}
	
	void sendEmailNotificacionCreateReport(ReportDto reportDto) ;
	
	void sendEmail(String subject, String body, List<String> recipients, MultipartFile[] attachments) throws IOException;
}
