package com.anjade.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${base.url}") // Inyecta el valor de frontend.url
    private String baseUrl;
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontURL;
	
	private static final int TARGETA = 1; // Código del comercio de pruebas
	private static final int BIZUM = 2; // Código del comercio de pruebas
	
	 public void sendWelcomeEmail(String toEmail, String idAfiliacion) {
		 
		 MimeMessage message = mailSender.createMimeMessage();
		    try {
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        helper.setTo(toEmail);
		        helper.setSubject("Bienvenido ANJADE-Dignidad Deportiva");

		        // HTML content
		        String htmlContent = readEmailTemplate("cuestionario_email.html");
		        // Reemplaza los placeholders en la plantilla
		        htmlContent = htmlContent.replace("${idAfiliacion}", idAfiliacion);

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
		    } catch (IOException e) {
				// TODO Auto-generated catch block
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

	@Override
	public void sendEmailCuestionario(String toEmail,String idAfiliacion) {
		MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setTo(toEmail);
	        helper.setSubject("Cuestionario de Afiliados ANJADE");

	        // HTML content
	        String htmlContent = readEmailTemplate("cuestionario_email.html");
	        // Reemplaza los placeholders en la plantilla
	        htmlContent = htmlContent.replace("${idAfiliacion}", idAfiliacion);

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
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	
	public void sendPaymentReminderEmail(String toEmail, String idAfiliacion) {
		 
		 MimeMessage message = mailSender.createMimeMessage();
		    try {
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        helper.setTo(toEmail);
		        helper.setSubject("Recordatorio de Pago Pendiente ANJADE-Dignidad Deportiva");

		        // HTML content
		        String htmlContent = readEmailTemplate("payment_reminder_template.html");
		        // Reemplaza los placeholders en la plantilla
	            String frontUrl = frontURL + "/reenviarPago?idAfiliacion=" + URLEncoder.encode(idAfiliacion.toString(), StandardCharsets.UTF_8);
	            
	            htmlContent = htmlContent.replace("${anjadeFrontURL}", frontUrl);


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
		    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
		}
	
	private String readEmailTemplate(String templateName) throws IOException {
		ClassPathResource resource = new ClassPathResource("templates/" + templateName);

	    // Usa un InputStream para leer el archivo en lugar de getFile()
	    try (InputStream inputStream = resource.getInputStream()) {
	        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
	    }
	}
}
