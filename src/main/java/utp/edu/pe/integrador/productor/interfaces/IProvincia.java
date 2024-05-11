package utp.edu.pe.integrador.productor.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import utp.edu.pe.integrador.productor.model.Provincia;

import java.util.List;

public interface IProvincia extends CrudRepository<Provincia, Integer> {

    String query="select * from provincia";
    @Query(value =query, nativeQuery = true)
    public List<Provincia> listarProvincias();

    @Query(value ="select * from provincia where estado_provincia = 'ACTIVO'", nativeQuery = true)
    public List<Provincia> listarProvinciasActivos();
}
