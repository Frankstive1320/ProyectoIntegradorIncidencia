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
        String content = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; }"
                + ".container { width: 100%; max-width: 600px; margin: auto; border: 1px solid #ccc; padding: 10px; }"
                + ".header { background-color: #003366; color: white; padding: 10px; text-align: center; }"
                + ".header h1 { margin: 0; font-size: 24px; }"
                + ".content { padding: 20px; }"
                + ".content h2 { color: #003366; text-align: center; }"
                + ".content p { margin: 10px 0; }"
                + ".details { width: 100%; border-collapse: collapse; margin: 20px 0; }"
                + ".details th, .details td { text-align: left; padding: 8px; border-bottom: 1px solid #ddd; }"
                + ".details th { background-color: #f2f2f2; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='container'>"
                + "<div class='header'>"
                + "<h1>" + averia.getInc() + "</h1>"
                + "</div>"
                + "<div class='content'>"
                + "<h2>EJECUCION DE AVERIA</h2>"
                + "<p>Estimados señores, se le brinda informacion de la averia ejecutada detalladamente:</p>"
                + "<table class='details'>"
                + "<tr><th>Incidencia</th><td>" + averia.getInc() + "</td></tr>"
                + "<tr><th>Contrata</th><td>" + averia.getContrata() + "</td></tr>"
                + "<tr><th>Cliente</th><td>" + averia.getCliente() + "</td></tr>"
                + "<tr><th>Dirección</th><td>" + averia.getDireccion() + "</td></tr>"
                + "<tr><th>Fecha</th><td>" + averia.getFechafinalizacion() + "</td></tr>"
                + "<tr><th>Acción Correctiva</th><td>" + averia.getAccionesCorrectivas() + "</td></tr>"
                + "<tr><th>Responsable</th><td>" + averia.getResponsable() + "</td></tr>"
                + "</table>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        message.setText(content, true);
		
		mailSender.send(mimeMessage);
	}

}
