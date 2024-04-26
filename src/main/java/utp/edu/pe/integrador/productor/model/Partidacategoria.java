package utp.edu.pe.integrador.productor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partidacategoria")
public class Partidacategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partidacategoriaid;

	private String partidacategorianombre;
	private String partidacategoriadescripcion; 
	
	public Partidacategoria() {
		// TODO Auto-generated constructor stub
	}

	public Partidacategoria(int partidacategoriaid, String partidacategorianombre, String partidacategoriadescripcion) {
		super();
		this.partidacategoriaid = partidacategoriaid;
		this.partidacategorianombre = partidacategorianombre;
		this.partidacategoriadescripcion = partidacategoriadescripcion;
	}

	public int getPartidacategoriaid() {
		return partidacategoriaid;
	}

	public void setPartidacategoriaid(int partidacategoriaid) {
		this.partidacategoriaid = partidacategoriaid;
	}

	public String getPartidacategorianombre() {
		return partidacategorianombre;
	}

	public void setPartidacategorianombre(String partidacategorianombre) {
		this.partidacategorianombre = partidacategorianombre;
	}

	public String getPartidacategoriadescripcion() {
		return partidacategoriadescripcion;
	}

	public void setPartidacategoriadescripcion(String partidacategoriadescripcion) {
		this.partidacategoriadescripcion = partidacategoriadescripcion;
	}
	
}
