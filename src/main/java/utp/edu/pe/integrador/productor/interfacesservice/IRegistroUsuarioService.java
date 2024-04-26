package utp.edu.pe.integrador.productor.interfacesservice;

import java.util.List;

import utp.edu.pe.integrador.productor.model.RegistroUsuario;

public interface IRegistroUsuarioService {
	
	public List <RegistroUsuario> listarRegistros();
	public int grabarRegistro(RegistroUsuario pProducto);
	public RegistroUsuario buscarporCodigo(int cod);
	public void eliminarRegistro(int cod);

}
