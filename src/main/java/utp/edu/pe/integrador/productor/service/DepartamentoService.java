package utp.edu.pe.integrador.productor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.integrador.productor.interfaces.IAverias;
import utp.edu.pe.integrador.productor.interfaces.IDepartamento;
import utp.edu.pe.integrador.productor.interfacesservice.IDepartamentoService;
import utp.edu.pe.integrador.productor.model.Departamento;

import java.util.List;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private IDepartamento departamento1;

    @Override
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>) departamento1.findAll();
    }

    @Override
    public List<Departamento> listarDepartamentosActivos() {
        return (List<Departamento>) departamento1.findAll();
    }

    @Override
    public void ActivarDepartamento(int idDepartamento) {
        departamento1.ActivarDepartamento(idDepartamento);
    }

    @Override
    public void DesactivarDepartamento(int idDepartamento) {
        departamento1.DesactivarDepartamento(idDepartamento);
    }
}
