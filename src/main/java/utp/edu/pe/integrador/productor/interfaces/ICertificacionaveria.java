package utp.edu.pe.integrador.productor.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import utp.edu.pe.integrador.productor.model.Certificacionaveria;

public interface ICertificacionaveria extends CrudRepository<Certificacionaveria, Integer> {
	
	@Query(value ="SELECT * FROM certificacionaveria WHERE certificacionaveriaid = :certificacionaveriaid", nativeQuery = true)
	public List<Certificacionaveria> SeleccionCertificacion(@Param("certificacionaveriaid") int certificacionaveriaid);
	
	@Query(value ="SELECT * FROM certificacionaveria " + 
			"JOIN averia ON averia.averiaid = certificacionaveria.averiaid " + 
			"WHERE averia.contrata = ?1 ", nativeQuery = true)
	public List<Certificacionaveria> SeleccionListadoCertificacionesaveria(String contrata);
	
	@Query(value ="SELECT * FROM certificacionaveria JOIN averia ON averia.averiaid = certificacionaveria.averiaid where  averia.contrata = :contrata", nativeQuery = true)
	public List<Certificacionaveria> listarAveriasporcontrata(@Param("contrata") String contrata);
	
	
	

}
