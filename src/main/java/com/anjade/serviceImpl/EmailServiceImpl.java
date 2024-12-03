package com.anjade.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anjade.entity.ReportDto;
import com.anjade.entity.UsuariosDto;
import com.anjade.repository.UsuariosRepository;
import com.anjade.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender mailSender;
	
	 @Autowired
	private UsuariosRepository usuarioRepository;
	
	@Value("${base.url}") // Inyecta el valor de frontend.url
    private String baseUrl;
	
	@Value("${responsable.report}") // Inyecta el valor de frontend.url
    private String responsableReport;
	
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
		        System.out.println("Correo enviado con éxito a: " + toEmail);
			} catch (MessagingException e) {
		        System.err.println("Error de mensajería: " + e.getMessage());
		        e.printStackTrace();
		    } catch (Exception e) {
		        System.err.println("Error inesperado: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
	
	// Este método obtiene todos los usuarios con estado "Pendiente de pago" y les envía un recordatorio
    public void sendPaymentRemindersToAll(Long estadoPendienteId) {
        // Obtener todos los usuarios cuyo estado de cuenta es "Pendiente de pago" (usando el ID del estado)
        List<UsuariosDto> usuarios = usuarioRepository.findByEstadoCuentaId(estadoPendienteId);

        // Enviar el correo a cada usuario
        for (UsuariosDto usuario : usuarios) {
            sendPaymentReminderEmail(usuario.getCorreo(), usuario.getIdAfiliacion());
        }
    }
	
	
	
	private String readEmailTemplate(String templateName) throws IOException {
		ClassPathResource resource = new ClassPathResource("templates/" + templateName);

	    // Usa un InputStream para leer el archivo en lugar de getFile()
	    try (InputStream inputStream = resource.getInputStream()) {
	        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
	    }
	}

	@Override
	public void sendEmailNotificacionCreateReport(ReportDto reportDto) {
		 MimeMessage message = mailSender.createMimeMessage();
		    try {
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        
		        // Configurar destinatarios
		        helper.setTo(new String[]{reportDto.getEmail(), responsableReport});
		        helper.setSubject("Comunicación de Creación de Reporte sobre sucesos");

		        // Leer y personalizar el contenido HTML
		        String htmlContent = readEmailTemplate("create_report_email.html");
		        
		        // Determinar si es afiliado o usuario general
		        String saludo;
		        if (reportDto.getAfiliacionId() != null && !reportDto.getAfiliacionId().isEmpty()) {
		            saludo = "Afiliado: " + reportDto.getAfiliacionId();
		        } else {
		            saludo = "Usuario: " + reportDto.getNombre() + " " + reportDto.getApellidos();
		        }
		        
		        // Reemplazar placeholders
		        htmlContent = htmlContent.replace("${saludo}", saludo);
		        htmlContent = htmlContent.replace("${referenciaReporte}", reportDto.getReferenciaReporte());

		        helper.setText(htmlContent, true);

		        // Agregar imagen como adjunto inline
		        ClassPathResource image = new ClassPathResource("templates/anjade_icono.jpg");
		        helper.addInline("imagen", image);

		        // Configurar remitente
		        helper.setFrom("anjade@anjade.es");

		        // Enviar el correo
		        mailSender.send(message);
		    } catch (MessagingException | IOException e) {
		        e.printStackTrace();
		    }
		
		
	}
	
	@Override
	public void sendEmail(String subject, String body, List<String> recipients, MultipartFile[] attachments) throws IOException {
		try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

         // Configurar remitente
	        helper.setFrom("anjade@anjade.es");
            // Agregar múltiples destinatarios
            helper.setTo(recipients.toArray(new String[0]));
            helper.setSubject(subject);
            helper.setText(body);

            // Adjuntar los archivos
            if (attachments != null && attachments.length > 0) {
                for (MultipartFile attachment : attachments) {
                    // Comprobar si el archivo tiene contenido
                    if (!attachment.isEmpty()) {
                        helper.addAttachment(attachment.getOriginalFilename(), attachment);
                    }
                }
            }
            
            // Agregar imagen como adjunto inline
	        ClassPathResource image = new ClassPathResource("templates/anjade_icono.jpg");
	        helper.addInline("imagen", image);

            // Enviar el correo
            mailSender.send(message);
            System.out.println("Correo enviado con éxito a: " + recipients);
		} catch (MessagingException e) {
	        System.err.println("Error de mensajería: " + e.getMessage());
	        e.printStackTrace();
	    } catch (Exception e) {
	        System.err.println("Error inesperado: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}
