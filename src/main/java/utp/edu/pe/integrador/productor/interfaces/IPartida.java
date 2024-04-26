package utp.edu.pe.integrador.productor.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import utp.edu.pe.integrador.productor.model.Partida;

public interface IPartida extends CrudRepository<Partida, Integer> {

	@Query(value = "select * from partida where partidacategoriaid  = 1", nativeQuery = true)
	public List<Partida> listaPartidasAverias();
	
	@Query(value = "select * from partida where partidacategoriaid  = 2", nativeQuery = true)
	public List<Partida> listaPartidasTrabajo();
	
	@Query(value = "select * from partida where partidacategoriaid  = 1", nativeQuery = true)
	public List<Partida> listaPartidasEquipo();
}
