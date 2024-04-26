package utp.edu.pe.integrador.productor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.IRegistroUsuario;
import utp.edu.pe.integrador.productor.interfacesservice.IRegistroUsuarioService;
import utp.edu.pe.integrador.productor.model.RegistroUsuario;

@Service
public class RegistroUsuarioService implements IRegistroUsuarioService {
	
	@Autowired
	private IRegistroUsuario servicio;
	
	@Override
	public List<RegistroUsuario> listarRegistros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int grabarRegistro(RegistroUsuario pProducto) {
		// TODO Auto-generated method stub
		int res=0;
		RegistroUsuario producto = servicio.save(pProducto);
		if (!producto.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public RegistroUsuario buscarporCodigo(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarRegistro(int cod) {
		// TODO Auto-generated method stub
		
	}
	
	

}
