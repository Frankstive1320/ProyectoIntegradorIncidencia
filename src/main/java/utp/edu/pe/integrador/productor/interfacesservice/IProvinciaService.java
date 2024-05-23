package utp.edu.pe.integrador.productor.interfacesservice;

import utp.edu.pe.integrador.productor.model.Provincia;

import java.util.List;

public interface IProvinciaService {

    public List<Provincia> listarProvincias();

    public List<Provincia> listarProvinciasActivos();
    
    public List<Provincia> listarProvinciasActivosDepartamento(int idDepartamento);

    public List<Provincia> listarProvincias(int codigo);
}
