package utp.edu.pe.integrador.productor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipobaremo")
public class Tipobaremo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tipobaremoid;
	
	private String tipobaremonombre;
	
	private double tipobaremopreciolima;
	
	private double tipobaremoprecioprovincia;
	
	public Tipobaremo() {
		// TODO Auto-generated constructor stub
	}

	public Tipobaremo(int tipobaremoid, String tipobaremonombre, double tipobaremopreciolima,
			double tipobaremoprecioprovincia) {
		super();
		this.tipobaremoid = tipobaremoid;
		this.tipobaremonombre = tipobaremonombre;
		this.tipobaremopreciolima = tipobaremopreciolima;
		this.tipobaremoprecioprovincia = tipobaremoprecioprovincia;
	}

	public int getTipobaremoid() {
		return tipobaremoid;
	}

	public void setTipobaremoid(int tipobaremoid) {
		this.tipobaremoid = tipobaremoid;
	}

	public String getTipobaremonombre() {
		return tipobaremonombre;
	}

	public void setTipobaremonombre(String tipobaremonombre) {
		this.tipobaremonombre = tipobaremonombre;
	}

	public double getTipobaremopreciolima() {
		return tipobaremopreciolima;
	}

	public void setTipobaremopreciolima(double tipobaremopreciolima) {
		this.tipobaremopreciolima = tipobaremopreciolima;
	}

	public double getTipobaremoprecioprovincia() {
		return tipobaremoprecioprovincia;
	}

	public void setTipobaremoprecioprovincia(double tipobaremoprecioprovincia) {
		this.tipobaremoprecioprovincia = tipobaremoprecioprovincia;
	}
	
}
