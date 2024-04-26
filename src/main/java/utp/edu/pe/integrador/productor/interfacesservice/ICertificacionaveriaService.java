package utp.edu.pe.integrador.productor.interfacesservice;

import java.util.List;

import org.springframework.data.repository.query.Param;
import utp.edu.pe.integrador.productor.model.Certificacionaveria;

public interface ICertificacionaveriaService {
	
	public List <Certificacionaveria> listarCertificacionesaveria();
	public int grabarCertificacionaveria(Certificacionaveria pCertificacionaveria);
	
	public Certificacionaveria certificacionaveriaPorCodigo(int cod);
	
	public List<Certificacionaveria> SeleccionCertificacion(int certificacionaveriaid);
	
	public List<Certificacionaveria> SeleccionListadoCertificacionesaveria(String contrata);
	public List<Certificacionaveria> listarAveriasporcontrata(String contrata);

}
