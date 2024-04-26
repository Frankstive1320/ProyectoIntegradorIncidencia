package utp.edu.pe.integrador.productor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.entity.User;
import utp.edu.pe.integrador.productor.interfaces.IUser;
import utp.edu.pe.integrador.productor.interfacesservice.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUser usu;

	@Override
	public List<User> listarUsers() {
		return (List<User>) usu.findAll();
	}

	@Override
	public List<User> listarUserSupervisores(String id, String id2) {
		return (List<User>) usu.listarUserSupervisores(id, id2);
	}

	@Override
	public List<User> listarTecnicos() {
		return (List<User>) usu.listarTecnico();
	}

	@Override
	public List<User> listarUserTecnico() {
		return (List<User>) usu.listarUserTecnico();
	}

}
