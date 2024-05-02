package utp.edu.pe.integrador.productor.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import utp.edu.pe.integrador.productor.entity.User;

public interface IUser  extends CrudRepository<User, Integer>{
	
	@Query(value ="SELECT * FROM user " + 
			"INNER JOIN user_roles ON  user.id = user_roles.user_id " + 
			"WHERE user_roles.role_id = :id OR user_roles.role_id = :id2", nativeQuery = true)
	public List<User> listarUserSupervisores (@Param("id") String id, @Param("id2") String id2);
	
	@Query(value ="SELECT * FROM user " + 
			"INNER JOIN user_roles ON  user.id = user_roles.user_id " + 
			"WHERE user_roles.role_id = '4'", nativeQuery = true)
	public List<User> listarUserTecnico ();
	
	@Query(value =
			"SELECT * FROM user " 
			+ "LEFT JOIN user_roles ON user_roles.user_id = user.id "
			
			+ "WHERE user_roles.role_id = 2  ", nativeQuery = true)
	public List<User> listarTecnico(); 
		
}

