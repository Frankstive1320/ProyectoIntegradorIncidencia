package utp.edu.pe.integrador.productor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.IPartidacategoria;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidacategoriaService;
import utp.edu.pe.integrador.productor.model.Partidacategoria;

@Service
public class PartidacategoriaService implements IPartidacategoriaService {
	
	@Autowired
	private IPartidacategoria cua;

	@Override
	public List<Partidacategoria> listarPartidacategorias() {
		return (List<Partidacategoria>) cua.findAll();
	}

	@Override
	public int grabarPartidacategoria(Partidacategoria pPartidacategoria) {
		int res=0;
		Partidacategoria partidacategoria = cua.save(pPartidacategoria);
		if (!partidacategoria.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Partidacategoria PartidacategoriaPorCodigo(int cod) {
		return cua.findById(cod).orElse(null);
	}

	@Override
	public void eliminarPartidacategoria(int cod) {
		cua.deleteById(cod);
	}

}
