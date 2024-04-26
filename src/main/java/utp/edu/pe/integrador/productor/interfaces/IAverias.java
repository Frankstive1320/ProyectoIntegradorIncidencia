package utp.edu.pe.integrador.productor.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import utp.edu.pe.integrador.productor.model.Averias;

public interface IAverias extends CrudRepository<Averias, Integer> {
		
	
	@Query(value ="select * from  averia where estado = 'EN PLANTA'", nativeQuery = true)
	public List<Averias> listaraveriasenplanta();

	
	@Query(value ="SELECT * FROM averia WHERE estado = 'PENDIENTE'", nativeQuery = true)
	public List<Averias> listaraveriasenplanta2();
	
	@Query(value = "SELECT * FROM averia WHERE (estado = 'EJECUTADO' OR estado = 'EN PLANTA') AND contrata = ?1 AND liquidadotrabajo = 'NO' ", nativeQuery = true)
	public List<Averias> listarAveriasEjecutasMateriales(String contrata);
	
	@Query(value = "SELECT * FROM averia WHERE estado = 'EJECUTADO' AND materiales = 'CON MATERIALES' and liquidadotrabajo IS NULL ", nativeQuery = true)
	public List<Averias> listarAveriasEjecutasMateriales2();
	@Query(value = "SELECT * FROM averia WHERE estado = 'PENDIENTE' and contrata =? ", nativeQuery = true)
	public List<Averias> listarAveriasportecnico(String contrata);
	
	@Modifying
	@Transactional
	@Query(value =
			"UPDATE averia SET liquidadotrabajo = 'SI' WHERE averiaid = ?1 "
			,  nativeQuery = true)
	void ActualizarAveriaLiquidacion(int averiaid);
	
	@Query(value = "SELECT * FROM averia WHERE (estado = 'EJECUTADO' OR estado = 'EN PLANTA') and contrata = ?1 and certificaciontrabajo IS NULL ", nativeQuery = true)
	public List<Averias> listarAveriasSinCertificacion(String contrata);
	
	@Modifying
	@Transactional
	@Query(value =
			"UPDATE averia SET certificaciontrabajo = 'SI' WHERE averiaid = ?1 "
			,  nativeQuery = true)
	void ActualizarAveriaSinCertificacion(int averiaid);
	
	@Modifying
	@Transactional
	@Query(value =
			"UPDATE averia SET fechafinalizacion = ?1 WHERE averiaid = ?2 "
			,  nativeQuery = true)
	void ActualizarAveriaFechaFinalizacionn(String fechafinalizacion, int averiaid);
	
}
