package utp.edu.pe.integrador.productor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import utp.edu.pe.integrador.productor.entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
	public Role findByName(String name);

}