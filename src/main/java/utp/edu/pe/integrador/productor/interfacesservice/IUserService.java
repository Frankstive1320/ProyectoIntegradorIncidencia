package utp.edu.pe.integrador.productor.interfacesservice;

import java.util.List;

import utp.edu.pe.integrador.productor.entity.User;

public interface IUserService {

	public List <User> listarUsers();
	public List <User> listarUserSupervisores(String id, String id2);
	
	public List <User> listarTecnicos();
	
	public List<User> listarUserTecnico ();
	
}
