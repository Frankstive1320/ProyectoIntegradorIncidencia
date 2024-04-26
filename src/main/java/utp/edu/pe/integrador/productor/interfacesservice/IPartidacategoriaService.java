package utp.edu.pe.integrador.productor.interfacesservice;

import java.util.List;

import utp.edu.pe.integrador.productor.model.Partidacategoria;

public interface IPartidacategoriaService {
	
	public List <Partidacategoria> listarPartidacategorias();
	public int grabarPartidacategoria(Partidacategoria pPartidacategoria);
	public Partidacategoria PartidacategoriaPorCodigo(int cod);
	public void eliminarPartidacategoria(int cod);

}
