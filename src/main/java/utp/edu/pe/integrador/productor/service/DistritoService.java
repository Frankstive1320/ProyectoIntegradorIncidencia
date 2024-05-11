package utp.edu.pe.integrador.productor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.integrador.productor.interfaces.IDepartamento;
import utp.edu.pe.integrador.productor.interfaces.IDistrito;
import utp.edu.pe.integrador.productor.interfacesservice.IDepartamentoService;
import utp.edu.pe.integrador.productor.interfacesservice.IDistritoService;
import utp.edu.pe.integrador.productor.model.Departamento;
import utp.edu.pe.integrador.productor.model.Distrito;

import java.util.List;

@Service
public class DistritoService implements IDistritoService {

    @Autowired
    private IDistrito distrito1;

    @Override
    public List<Distrito> listarDistritos() {
        return (List<Distrito>) distrito1.findAll();
    }

    @Override
    public List<Distrito> listarDistritosActivos() {
        return (List<Distrito>) distrito1.findAll();
    }
}
