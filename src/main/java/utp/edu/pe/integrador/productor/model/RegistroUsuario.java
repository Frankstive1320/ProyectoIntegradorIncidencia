package utp.edu.pe.integrador.productor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "registrousuario")
public class RegistroUsuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int registroid;
	
	private String fecha;
	
	private String hora;
	
	private String username;
	
	public RegistroUsuario() {
		// TODO Auto-generated constructor stub
	}

	public RegistroUsuario(int registroid, String fecha, String hora, String username) {
		super();
		this.registroid = registroid;
		this.fecha = fecha;
		this.hora = hora;
		this.username = username;
	}

	public int getRegistroid() {
		return registroid;
	}

	public void setRegistroid(int registroid) {
		this.registroid = registroid;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
