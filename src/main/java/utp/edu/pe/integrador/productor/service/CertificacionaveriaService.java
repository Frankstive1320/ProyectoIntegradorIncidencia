package utp.edu.pe.integrador.productor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.ICertificacionaveria;
import utp.edu.pe.integrador.productor.interfacesservice.ICertificacionaveriaService;

import utp.edu.pe.integrador.productor.model.Certificacionaveria;

@Service
public class CertificacionaveriaService implements ICertificacionaveriaService {
	
	@Autowired
	private ICertificacionaveria cer;

	@Override
	public List<Certificacionaveria> listarCertificacionesaveria() {
		return (List<Certificacionaveria>) cer.findAll();
	}

	@Override
	public int grabarCertificacionaveria(Certificacionaveria pCertificacionaveria) {
		int res=0;
		Certificacionaveria certificacionaveria = cer.save(pCertificacionaveria);
		if (!certificacionaveria.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public List<Certificacionaveria> SeleccionCertificacion(int certificacionaveriaid) {
		return (List<Certificacionaveria>) cer.SeleccionCertificacion(certificacionaveriaid);
	}

	@Override
	public List<Certificacionaveria> SeleccionListadoCertificacionesaveria(String contrata) {
		return (List<Certificacionaveria>) cer.SeleccionListadoCertificacionesaveria(contrata);
	}

	@Override
	public List<Certificacionaveria> listarAveriasporcontrata(String contrata) {
		return (List<Certificacionaveria>) cer.listarAveriasporcontrata(contrata);
	}

	@Override
	public Certificacionaveria certificacionaveriaPorCodigo(int cod) {
		return cer.findById(cod).orElse(null);
	}

}
