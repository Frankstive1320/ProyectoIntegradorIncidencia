package utp.edu.pe.integrador.productor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;

	public void sedEmail (String to, String subject, String text)
	{
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jorgejk158@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
		
		mailSender.send(message);
	}

}
