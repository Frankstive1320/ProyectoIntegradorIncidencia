package utp.edu.pe.integrador.productor.interfaces;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import utp.edu.pe.integrador.productor.model.Departamento;

import java.util.List;

public interface IDepartamento extends CrudRepository<Departamento, Integer> {

    @Query(value ="select * from departamento", nativeQuery = true)
    public List<Departamento> listarDepartamentos();

    @Query(value ="select * from departamento where estado_departamento = 'ACTIVO'", nativeQuery = true)
    public List<Departamento> listarDepartamentosActivos();

    @Modifying
    @Transactional
    @Query(value =
            "UPDATE departamento SET estado_departamento = 'ACTIVO' WHERE id_departamento = ?1 "
            ,  nativeQuery = true)
    void ActivarDepartamento(int idDepartamento);

    @Modifying
    @Transactional
    @Query(value =
            "UPDATE departamento SET estado_departamento = 'ANULADO' WHERE id_departamento = ?1 "
            ,  nativeQuery = true)
    void DesactivarDepartamento(int idDepartamento);

}
