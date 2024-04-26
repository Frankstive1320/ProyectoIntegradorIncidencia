package utp.edu.pe.integrador.productor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="partida")
public class Partida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partidaid;
	
	private String partidatipo;
	
	private String partidatipobaremo;
	
	private String partidaitem;
	
	private String partidadescripcion;
	
	private String partidaum;
	
	private String partidabaremo;
	
	
	
	@ManyToOne
	@JoinColumn(name="tipobaremoid")
	private Tipobaremo tipobaremo;
	
	@ManyToOne
	@JoinColumn(name="partidacategoriaid")
	private Partidacategoria partidacategoria;
	
	public Partida() {
		// TODO Auto-generated constructor stub
	}

	public Partida(int partidaid, String partidatipo, String partidatipobaremo, String partidaitem,
			String partidadescripcion, String partidaum, String partidabaremo, Tipobaremo tipobaremo,
			Partidacategoria partidacategoria) {
		super();
		this.partidaid = partidaid;
		this.partidatipo = partidatipo;
		this.partidatipobaremo = partidatipobaremo;
		this.partidaitem = partidaitem;
		this.partidadescripcion = partidadescripcion;
		this.partidaum = partidaum;
		this.partidabaremo = partidabaremo;
		this.tipobaremo = tipobaremo;
		this.partidacategoria = partidacategoria;
	}



	public int getPartidaid() {
		return partidaid;
	}

	public void setPartidaid(int partidaid) {
		this.partidaid = partidaid;
	}

	public String getPartidatipo() {
		return partidatipo;
	}

	public void setPartidatipo(String partidatipo) {
		this.partidatipo = partidatipo;
	}

	public String getPartidatipobaremo() {
		return partidatipobaremo;
	}

	public void setPartidatipobaremo(String partidatipobaremo) {
		this.partidatipobaremo = partidatipobaremo;
	}

	public String getPartidaitem() {
		return partidaitem;
	}

	public void setPartidaitem(String partidaitem) {
		this.partidaitem = partidaitem;
	}

	public String getPartidadescripcion() {
		return partidadescripcion;
	}

	public void setPartidadescripcion(String partidadescripcion) {
		this.partidadescripcion = partidadescripcion;
	}

	public String getPartidaum() {
		return partidaum;
	}

	public void setPartidaum(String partidaum) {
		this.partidaum = partidaum;
	}

	public String getPartidabaremo() {
		return partidabaremo;
	}

	public void setPartidabaremo(String partidabaremo) {
		this.partidabaremo = partidabaremo;
	}

	public Tipobaremo getTipobaremo() {
		return tipobaremo;
	}

	public void setTipobaremo(Tipobaremo tipobaremo) {
		this.tipobaremo = tipobaremo;
	}

	public Partidacategoria getPartidacategoria() {
		return partidacategoria;
	}

	public void setPartidacategoria(Partidacategoria partidacategoria) {
		this.partidacategoria = partidacategoria;
	}

}
