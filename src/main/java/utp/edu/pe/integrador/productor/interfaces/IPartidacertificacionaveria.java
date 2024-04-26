package utp.edu.pe.integrador.productor.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import utp.edu.pe.integrador.productor.model.Partidacertificacionaveria;

public interface IPartidacertificacionaveria extends CrudRepository<Partidacertificacionaveria, Integer> {
	
	@Query(value = "select * from partidacertificacionaveria where certificacionaveriaid = ?1", nativeQuery = true)
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria(int codigo);
	
	@Query(value = "select * from partidacertificacionaveria " +
			"JOIN certificacionaveria ON certificacionaveria.certificacionaveriaid = partidacertificacionaveria.certificacionaveriaid " +
			"JOIN averia ON averia.averiaid = certificacionaveria.averiaid " +
			"where averia.fechafinalizacion >= ?1 AND averia.fechafinalizacion <= ?2", nativeQuery = true)
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria3(String fechainicio, String fechafin);
	
	@Query(value = "select * from partidacertificacionaveria " +
			"JOIN certificacionaveria ON certificacionaveria.certificacionaveriaid = partidacertificacionaveria.certificacionaveriaid " +
			"JOIN averia ON averia.averiaid = certificacionaveria.averiaid " +
			" where partidacertificacionaveria.certificacionaveriaid = ?1 AND averia.fechafinalizacion >= ?2 AND averia.fechafinalizacion <= ?3", nativeQuery = true)
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria2(int codigo, String fechainicio, String fechafin);
	
	@Query(value = "select * from partidacertificacionaveria where partidacertificacionaveria.partidaid = ?1 AND partidacertificacionaveria.certificacionaveriaid = ?2 ", nativeQuery = true)
	public Partidacertificacionaveria buscarpartidacertificaionaveria(int codigo , int codigoaveria);
	
	@Modifying
	@Transactional
	@Query(value = "Update partidacertificacionaveria set cantidadpartida = cantidadpartida + 1 where partidacertificacionaveria.partidaid = ?1 AND partidacertificacionaveria.certificacionaveriaid = ?2 ", nativeQuery = true)
	public int actualizarpartidacertificaionaveriacantidad(int codigo , int codigoaveria);
	
	//@Query(value ="SELECT partida.partidaid, partida.partidadescripcion, partida.partidabaremo, COUNT(partida.partidabaremo), SUM(partida.partidabaremo) FROM gpip09kt27rltn4c.partidacertificacionaveria " +
	//		"JOIN partida ON partida.partidaid = partidacertificacionaveria.partidaid " +
	//		"GROUP BY partida.partidaid ", nativeQuery = true)
	//public List<List<String>> listarCertificacionAverias();

	@Query(value = "select * from partida", nativeQuery = true)
	public List<List<String>> ListarPartidas2();
	

	
	
	@Query(value = "SELECT partida.partidaid, partida.partidadescripcion, \r\n"
			+ "					ROUND(tipobaremo.tipobaremopreciolima* partida.partidabaremo,2) AS 'BAREMO LIMA', \r\n"
			+ "					ROUND(tipobaremo.tipobaremoprecioprovincia* partida.partidabaremo,2) 'BAREMO PROVINCIA', \r\n"
			+ "					SUM(IF(averia.zonal = 'Lima' , partidacertificacionaveria.cantidadpartida, 0 )) AS 'AVERIAS EN LIMA' , \r\n"
			+ "					SUM(IF(averia.zonal != 'Lima', partidacertificacionaveria.cantidadpartida, 0 )) AS 'AVERIAS EN PROVINCIA' , \r\n"
			+ "					(ROUND(tipobaremo.tipobaremopreciolima* partida.partidabaremo,2)*SUM(IF(averia.zonal = 'Lima' , partidacertificacionaveria.cantidadpartida, 0 ))) AS 'PRECIO TOTAL LIMA', \r\n"
			+ "					(ROUND(tipobaremo.tipobaremoprecioprovincia* partida.partidabaremo,2)*SUM(IF(averia.zonal != 'Lima', partidacertificacionaveria.cantidadpartida, 0 ))) AS 'PRECIO TOTAL PROVINCIA' \r\n"
			+ "					FROM partidacertificacionaveria \r\n"
			+ "					JOIN partida ON partida.partidaid = partidacertificacionaveria.partidaid \r\n"
			+ "					JOIN tipobaremo ON partida.tipobaremoid = tipobaremo.tipobaremoid \r\n"
			+ "					JOIN certificacionaveria ON certificacionaveria.certificacionaveriaid = partidacertificacionaveria.certificacionaveriaid \r\n"
			+ "					JOIN averia ON averia.averiaid = certificacionaveria.averiaid \r\n"
			+ "					WHERE averia.fechafinalizacion >= :fechainicio AND averia.fechafinalizacion <= :fechafin \r\n"
			+ "				 	GROUP BY partida.partidaid ;", nativeQuery = true)
public List<List<String>> listarCertificacionAverias(@Param("fechainicio") String fechainicio, @Param("fechafin") String fechafin);

	
	
	
}
