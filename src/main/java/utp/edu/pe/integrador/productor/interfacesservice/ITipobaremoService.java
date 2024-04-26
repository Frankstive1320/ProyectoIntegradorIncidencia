package utp.edu.pe.integrador.productor.interfacesservice;

import java.util.List;

import utp.edu.pe.integrador.productor.model.Tipobaremo;

public interface ITipobaremoService {
	
	public List <Tipobaremo> listarTipobaremos();
	public int grabarTipobaremo(Tipobaremo pTipobaremo);
	public Tipobaremo tipobaremoPorCodigo(int cod);
	public void eliminarTipobaremo(int cod);

}
