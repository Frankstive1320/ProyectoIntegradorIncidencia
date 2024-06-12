package utp.edu.pe.integrador.productor.interfacesservice;

import java.io.ByteArrayInputStream;
import java.util.List;

import utp.edu.pe.integrador.productor.model.Averias;

public interface IAveriasService {
	
	public List <Averias> listarAveria();
	public int grabarAverias(Averias pAverias);
	public Averias averiaPorCodigo(int cod);
	public void eliminarAverias(int cod);
	
	public List<Averias> listaraveriasenplanta();
	public List<Averias> listaraveriasenplanta2();
	
	public List<Averias> listarAveriasEjecutasMateriales(String contrata);
	public List<Averias> listarAveriasEjecutasMateriales2();
	
	public void ActualizarAveriaLiquidacion(int averiaid);
	
	public List<Averias> listarAveriasSinCertificacion(String contrata);
	public List<Averias> listarAveriasportecnico(String contrata);
	
	public void ActualizarAveriaSinCertificacion(int averiaid);
	
	public void ActualizarAveriaFechaFinalizacionn(String fechafinalizacion, int averiaid);
	ByteArrayInputStream exportAllDta() throws Exception;
	
	public void AgregarAveria (String inc, String sisego, String zonal, String zonificacion, String contrata,
			String tecnico_asignado, String fecha_atencion, String tipo_averia, String diagnostico, String parada_reloj,
			String acciones_correctivas, String estado, String observaciones, String cliente, String departamento,String distrito
			,String direccion, String materiales);
	
	
}
