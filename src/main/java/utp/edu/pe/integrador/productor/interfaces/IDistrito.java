package utp.edu.pe.integrador.productor.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import utp.edu.pe.integrador.productor.model.Departamento;
import utp.edu.pe.integrador.productor.model.Distrito;
import utp.edu.pe.integrador.productor.model.Provincia;

import java.util.List;

public interface IDistrito extends CrudRepository<Distrito, Integer> {

    String query="select * from distrito";
    @Query(value =query, nativeQuery = true)
    public List<Distrito> listarDistritos();

    @Query(value ="select * from distrito where estado_distrito = 'ACTIVO'", nativeQuery = true)
    public List<Distrito> listarDistritosActivos();

    String query2=
            "SELECT T1.* FROM distrito T1\n" +
                    "INNER JOIN provincia T2 ON\n" +
                    "T1.cod_provincia=T2.cod_provincia\n" +
                    "INNER JOIN departamento T3 ON\n" +
                    "T1.cod_departamento=T3.cod_departamento\n" +
                    "WHERE\n" +
                    "T3.estado_departamento='ACTIVO' AND\n" +
                    "T2.estado_provincia='ACTIVO' AND\n" +
                    "T1.estado_distrito='ACTIVO' AND\n" +
                    "T2.cod_provincia= ?1 ";
    @Query(value =query2, nativeQuery = true)
    public List<Distrito> listarDistritosActivosProvincia(int idProvincia);
    
    @Query(value =
            "select * from distrito where nombre_distrito = ?1"
            ,  nativeQuery = true)
    public Distrito BuscarDistritobyNombre(String nombredistrito);

    @Query(value = "select * from distrito where cod_provincia = ?1", nativeQuery = true)
    public List<Distrito> listarDistritos(int codigo);
}
