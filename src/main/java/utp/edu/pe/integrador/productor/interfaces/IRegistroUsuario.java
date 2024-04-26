package utp.edu.pe.integrador.productor.interfaces;

import org.springframework.data.repository.CrudRepository;

import utp.edu.pe.integrador.productor.model.RegistroUsuario;

public interface IRegistroUsuario extends CrudRepository<RegistroUsuario, Integer> {

}
