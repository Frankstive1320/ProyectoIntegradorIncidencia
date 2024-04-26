package utp.edu.pe.integrador.productor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partidacertificacionaveria")
public class Partidacertificacionaveria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partidacertificacionaveriaid;
	
	String observacionPartidacertificacionaveria;
	
	@ManyToOne
	@JoinColumn(name="partidaid")
	private Partida partida;
	
	@ManyToOne
	@JoinColumn(name="certificacionaveriaid")
	private Certificacionaveria certificacionaveria;
	
	private int cantidadpartida;
	
	public Partidacertificacionaveria() {
		// TODO Auto-generated constructor stub
	}

	

	public Partidacertificacionaveria(int partidacertificacionaveriaid, String observacionPartidacertificacionaveria,
			Partida partida, Certificacionaveria certificacionaveria, int cantidadpartida) {
		super();
		this.partidacertificacionaveriaid = partidacertificacionaveriaid;
		this.observacionPartidacertificacionaveria = observacionPartidacertificacionaveria;
		this.partida = partida;
		this.certificacionaveria = certificacionaveria;
		this.cantidadpartida = cantidadpartida;
	}



	public int getPartidacertificacionaveriaid() {
		return partidacertificacionaveriaid;
	}

	public void setPartidacertificacionaveriaid(int partidacertificacionaveriaid) {
		this.partidacertificacionaveriaid = partidacertificacionaveriaid;
	}

	public String getObservacionPartidacertificacionaveria() {
		return observacionPartidacertificacionaveria;
	}

	public void setObservacionPartidacertificacionaveria(String observacionPartidacertificacionaveria) {
		this.observacionPartidacertificacionaveria = observacionPartidacertificacionaveria;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Certificacionaveria getCertificacionaveria() {
		return certificacionaveria;
	}

	public void setCertificacionaveria(Certificacionaveria certificacionaveria) {
		this.certificacionaveria = certificacionaveria;
	}



	public int getCantidadpartida() {
		return cantidadpartida;
	}



	public void setCantidadpartida(int cantidadpartida) {
		this.cantidadpartida = cantidadpartida;
	}
	
}
