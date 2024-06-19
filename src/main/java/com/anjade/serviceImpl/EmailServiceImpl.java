package com.anjade.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.anjade.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender mailSender;
	
	 public void sendWelcomeEmail(String toEmail, String idAfiliacion) {
	     /*   SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject("Bienvenido a ANJADE");
	        message.setText("Bienvenido ANJADE. Su número de afiliación es:"+idAfiliacion);
	        message.setFrom("anjade@anjade.es");
	        mailSender.send(message);*/
		 
		 
		  MimeMessage message = mailSender.createMimeMessage();
		    try {
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        helper.setTo(toEmail);
		        helper.setSubject("Bienvenido a ANJADE");

		        // HTML content
		        String htmlContent = "<html><body>"
		                + "<p>Bienvenido a ANJADE-DIGNIDAD DEPORTIVA. Tú número de afiliación es: " + idAfiliacion + "</p>"
		                + "<img src='cid:imagen'/>"
		                + "</body></html>";
		        helper.setText(htmlContent, true);

		        // Add the image as an attachment with content ID
		        ClassPathResource image = new ClassPathResource("templates/anjade_icono.jpg");
		        helper.addInline("imagen", image);

		        // Set sender
		        helper.setFrom("anjade@anjade.es");

		        // Send the email
		        mailSender.send(message);
		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
	    }
	 
	 public  void sendRedsysResponseEmail(String toEmail, String response) {
		 SimpleMailMessage message = new SimpleMailMessage();
		    message.setTo(toEmail);
		    message.setSubject("Response Pruebas redsys");
		    message.setText("Response: "+response);
		    message.setFrom("anjade@anjade.es");
		    mailSender.send(message);
	 }
	 

	@Override
	public void sendEmailConfirmacionPago(String toEmail, String idAfiliacion) {
		MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo(toEmail);
	        helper.setSubject("Confirmación de pago Afiliación ANJADE");

	        // HTML content
	        String htmlContent = "<html><body>"
	                + "<p>Afiliado: " + idAfiliacion + " hemos recibido correctamente vuestro pago de afiiación anual.</p>"
	                + "<img src='cid:imagen'/>"
	                + "</body></html>";
	        helper.setText(htmlContent, true);

	        // Add the image as an attachment with content ID
	        ClassPathResource image = new ClassPathResource("templates/anjade_icono.jpg");
	        helper.addInline("imagen", image);

	        // Set sender
	        helper.setFrom("anjade@anjade.es");

	        // Send the email
	        mailSender.send(message);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void sendEmailDePagoRechazado(String toEmail, String idAfiliacion) {
		MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo(toEmail);
	        helper.setSubject("Confirmación de pago Afiliación ANJADE");

	        // HTML content
	        String htmlContent = "<html><body>"
	                + "<p>Afiliado: " + idAfiliacion + " no hemos recibido correctamente vuestro pago de afiiación anual. Por favor conactar con administración.</p>"
	                + "<img src='cid:imagen'/>"
	                + "</body></html>";
	        helper.setText(htmlContent, true);

	        // Add the image as an attachment with content ID
	        ClassPathResource image = new ClassPathResource("templates/anjade_icono.jpg");
	        helper.addInline("imagen", image);

	        // Set sender
	        helper.setFrom("anjade@anjade.es");

	        // Send the email
	        mailSender.send(message);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void sendEmailError(Object error) {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo("administracion@anjade.es");
	        helper.setSubject("Error anjade.es");

	        // HTML content
	        String htmlContent = String.valueOf(error);
	        helper.setText(htmlContent, true);

	        // Set sender
	        helper.setFrom("anjade@anjade.es");

	        // Send the email
	        mailSender.send(message);
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
		
		
	}

}
