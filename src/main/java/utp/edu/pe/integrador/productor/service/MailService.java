package utp.edu.pe.integrador.productor.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfacesservice.IAveriasService;
import utp.edu.pe.integrador.productor.interfacesservice.IEmailService;
import utp.edu.pe.integrador.productor.model.Averias;

@Service
public class MailService implements IEmailService {
	
	@Autowired
	private JavaMailSender mailSender;

	public void sedEmail (String to, String subject, Averias averia)throws MessagingException
	{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
        message.setFrom("telemarketingsrlasoc@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        String content = "<html><body>"
                + "<h3>Detalles de la Avería</h3>"
                + "<p><strong>Incidencia:</strong> " + averia.getInc() + "</p>"
                + "<p><strong>Tecnico:</strong> " + averia.getContrata() + "</p>"
                + "<p><strong>Cliente:</strong> " + averia.getCliente() + "</p>"
                + "<p><strong>Dirección:</strong> " + averia.getDireccion() + "</p>"
                + "<p><strong>Fecha Finalizacion:</strong> " + averia.getFechafinalizacion() + "</p>"
                + "<p><strong>Acciónes Correctivas:</strong> " + averia.getAccionesCorrectivas() + "</p>"
                + "<p><strong>Responsable:</strong> " + averia.getResponsable() + "</p>"
                + "</body></html>";

        message.setText(content, true);
		
		mailSender.send(mimeMessage);
	}

}
