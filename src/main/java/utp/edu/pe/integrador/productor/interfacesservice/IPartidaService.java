package utp.edu.pe.integrador.productor.interfacesservice;

import java.util.List;

import utp.edu.pe.integrador.productor.model.Partida;

public interface IPartidaService {
	
	public List <Partida> listarPartidas();
	public int grabarPartida(Partida pPartida);
	public Partida partidaPorCodigo(int cod);
	public void eliminarPartida(int cod);
	
	public List<Partida> listaPartidasAverias();
	
	public List<Partida> listaPartidasTrabajo();
	
	public List<Partida> listaPartidasEquipo();

}
