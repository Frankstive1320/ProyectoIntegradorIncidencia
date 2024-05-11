package utp.edu.pe.integrador.productor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.integrador.productor.interfaces.IProvincia;
import utp.edu.pe.integrador.productor.interfacesservice.IDepartamentoService;
import utp.edu.pe.integrador.productor.interfacesservice.IProvinciaService;
import utp.edu.pe.integrador.productor.model.Provincia;

import java.util.List;

@Service
public class ProvinciaService implements IProvinciaService {

    @Autowired
    private IProvincia provincia1;

    @Override
    public List<Provincia> listarProvincias() {
        return (List<Provincia>) provincia1.findAll();
    }

    @Override
    public List<Provincia> listarProvinciasActivos() {
        return (List<Provincia>) provincia1.findAll();
    }
}
