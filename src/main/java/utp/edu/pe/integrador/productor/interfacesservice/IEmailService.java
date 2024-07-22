package utp.edu.pe.integrador.productor.interfacesservice;

import javax.mail.MessagingException;

import utp.edu.pe.integrador.productor.model.Averias;

public interface IEmailService {
	public void sedEmail (String to, String subject, Averias averias)throws MessagingException;
}
