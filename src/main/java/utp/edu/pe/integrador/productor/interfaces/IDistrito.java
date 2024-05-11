package utp.edu.pe.integrador.productor.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import utp.edu.pe.integrador.productor.model.Distrito;

import java.util.List;

public interface IDistrito extends CrudRepository<Distrito, Integer> {

    String query="select * from distrito";
    @Query(value =query, nativeQuery = true)
    public List<Distrito> listarDistritos();

    @Query(value ="select * from distrito where estado_distrito = 'ACTIVO'", nativeQuery = true)
    public List<Distrito> listarDistritosActivos();
}
