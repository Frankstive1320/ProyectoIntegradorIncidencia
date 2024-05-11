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

    String query2=
            "SELECT T1.* FROM provincia T1 " +
            "INNER JOIN departamento T2 ON " +
            "T1.cod_departamento=T2.cod_departamento " +
            "WHERE " +
            "T2.estado_departamento='ACTIVO' AND " +
            "T1.estado_provincia='ACTIVO' AND " +
            "T2.id_departamento= ?1 ";
    @Query(value =query2, nativeQuery = true)
    public List<Provincia> listarProvinciasActivosDepartamento(int idDepartamento);
}
