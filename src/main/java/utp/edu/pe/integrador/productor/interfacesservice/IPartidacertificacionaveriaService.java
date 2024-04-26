package utp.edu.pe.integrador.productor.interfacesservice;

import java.io.ByteArrayInputStream;
import java.util.List;

import utp.edu.pe.integrador.productor.model.Partidacertificacionaveria;

public interface IPartidacertificacionaveriaService {
	
	public List <Partidacertificacionaveria> listarPartidacertificacionaverias();
	public int grabarPartidacertificacionaveria(Partidacertificacionaveria Partidacertificacionaveria);
	public Partidacertificacionaveria partidacertificacionaveriaPorCodigo(int cod);
	public void eliminarPartidacertificacionaveria(int cod);
	
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria(int codigo);
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria2(int codigo, String fechainicio, String fechafin);
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria3(String fechainicio, String fechafin);
	
	ByteArrayInputStream exportPartidasAverias2(String fechainicio, String fechafin) throws Exception;
	
	public List<List<String>> listarCertificacionAverias(String fechainicio, String fechafin);
	
	public List<List<String>> ListarPartidas();
	public Partidacertificacionaveria buscarpartidacertificaionaveria(int codigo , int codigoaveria);	
	public int actualizarpartidacertificaionaveria(int codigo , int codigoaveria);

}
