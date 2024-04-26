package utp.edu.pe.integrador.productor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.IPartida;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidaService;
import utp.edu.pe.integrador.productor.model.Partida;

@Service
public class PartidaService implements IPartidaService {
	
	@Autowired
	private IPartida cua;

	@Override
	public List<Partida> listarPartidas() {
		return (List<Partida>) cua.findAll();
	}

	@Override
	public int grabarPartida(Partida pPartida) {
		int res=0;
		Partida partida = cua.save(pPartida);
		if (!partida.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Partida partidaPorCodigo(int cod) {
		return cua.findById(cod).orElse(null);
	}

	@Override
	public void eliminarPartida(int cod) {
		cua.deleteById(cod);
	}

	@Override
	public List<Partida> listaPartidasAverias() {
		// TODO Auto-generated method stub
		return cua.listaPartidasAverias();
	}

	@Override
	public List<Partida> listaPartidasTrabajo() {
		// TODO Auto-generated method stub
		return cua.listaPartidasTrabajo();
	}

	@Override
	public List<Partida> listaPartidasEquipo() {
		// TODO Auto-generated method stub
		return cua.listaPartidasEquipo();
	}

}
