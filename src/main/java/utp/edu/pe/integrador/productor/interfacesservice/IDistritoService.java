package utp.edu.pe.integrador.productor.interfacesservice;

import utp.edu.pe.integrador.productor.model.Distrito;

import java.util.List;

public interface IDistritoService {

    public List<Distrito> listarDistritos();

    public List<Distrito> listarDistritosActivos();
}
