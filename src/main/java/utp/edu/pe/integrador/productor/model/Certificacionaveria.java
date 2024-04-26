package utp.edu.pe.integrador.productor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="certificacionaveria")
public class Certificacionaveria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certificacionaveriaid;

	private String certificacionaverianombre;
	private String certificacionaveriaobservacion; 
	private String certificacionaveriafecha; 
	
	@ManyToOne
	@JoinColumn(name="averiaid")
	private Averias averia;
	
	public Certificacionaveria() {
		// TODO Auto-generated constructor stub
	}

	public Certificacionaveria(int certificacionaveriaid, String certificacionaverianombre,
			String certificacionaveriaobservacion, String certificacionaveriafecha, Averias averia) {
		super();
		this.certificacionaveriaid = certificacionaveriaid;
		this.certificacionaverianombre = certificacionaverianombre;
		this.certificacionaveriaobservacion = certificacionaveriaobservacion;
		this.certificacionaveriafecha = certificacionaveriafecha;
		this.averia = averia;
	}

	public int getCertificacionaveriaid() {
		return certificacionaveriaid;
	}

	public void setCertificacionaveriaid(int certificacionaveriaid) {
		this.certificacionaveriaid = certificacionaveriaid;
	}

	public String getCertificacionaverianombre() {
		return certificacionaverianombre;
	}

	public void setCertificacionaverianombre(String certificacionaverianombre) {
		this.certificacionaverianombre = certificacionaverianombre;
	}

	public String getCertificacionaveriaobservacion() {
		return certificacionaveriaobservacion;
	}

	public void setCertificacionaveriaobservacion(String certificacionaveriaobservacion) {
		this.certificacionaveriaobservacion = certificacionaveriaobservacion;
	}

	public String getCertificacionaveriafecha() {
		return certificacionaveriafecha;
	}

	public void setCertificacionaveriafecha(String certificacionaveriafecha) {
		this.certificacionaveriafecha = certificacionaveriafecha;
	}

	public Averias getAveria() {
		return averia;
	}

	public void setAveria(Averias averia) {
		this.averia = averia;
	}
	
}
