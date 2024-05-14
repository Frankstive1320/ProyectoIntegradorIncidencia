package utp.edu.pe.integrador.productor.interfacesservice;

import utp.edu.pe.integrador.productor.model.Departamento;

import java.util.List;

public interface IDepartamentoService {

    public List<Departamento> listarDepartamentos();

    public List<Departamento> listarDepartamentosActivos();

    public void ActivarDepartamento(int idDepartamento);

    public void DesactivarDepartamento(int idDepartamento);
    
    public Departamento BuscarDepartamentobyId(int idDepartamento);
    public Departamento BuscarDepartamentobyNombre(String nombredepartamento);
}
