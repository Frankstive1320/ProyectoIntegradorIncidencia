package utp.edu.pe.integrador.productor.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="averia")
public class Averias {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int averiaid;

	@NotBlank
	private String inc;

	@NotBlank
	private String sisego;

	@NotBlank
	private String zonal;

	private String zonificacion;

	private String contrata;

	@NotBlank
	private String tecnicoAsignado;

	@NotBlank
	private String fechaAtencion;

	private String tipoAveria;

	@NotBlank
	private String diagnostico;

	@NotBlank
	private String paradaReloj;

	@NotBlank
	private String accionesCorrectivas;

	private String estado;

	@NotBlank
	private String cliente;

	@NotBlank
	private String observaciones;

	@NotBlank
	private String materiales;

	private String liquidadotrabajo;

	private String certificaciontrabajo;
	
	// PARA REPORTE

	@NotBlank
	private String direccion;
	private String tiposervicio;
	@NotBlank
	private String fechafinalizacion;
	@NotBlank
	private String departamento;
	@NotBlank
	private String distrito;
	@NotBlank
	private String responsable;
	
	private String fechaparafinalizar;
	
	public Averias() {
		// TODO Auto-generated constructor stub
	}

	public Averias(int averiaid, String inc, String sisego, String zonal, String zonificacion, String contrata,
			String tecnicoAsignado, String fechaAtencion, String tipoAveria, String diagnostico, String paradaReloj,
			String accionesCorrectivas, String estado, String cliente, String observaciones, String materiales,
			String liquidadotrabajo, String certificaciontrabajo, String direccion, String tiposervicio,
			String fechafinalizacion, String departamento, String distrito, String responsable,
			String fechaparafinalizar) {
		super();
		this.averiaid = averiaid;
		this.inc = inc;
		this.sisego = sisego;
		this.zonal = zonal;
		this.zonificacion = zonificacion;
		this.contrata = contrata;
		this.tecnicoAsignado = tecnicoAsignado;
		this.fechaAtencion = fechaAtencion;
		this.tipoAveria = tipoAveria;
		this.diagnostico = diagnostico;
		this.paradaReloj = paradaReloj;
		this.accionesCorrectivas = accionesCorrectivas;
		this.estado = estado;
		this.cliente = cliente;
		this.observaciones = observaciones;
		this.materiales = materiales;
		this.liquidadotrabajo = liquidadotrabajo;
		this.certificaciontrabajo = certificaciontrabajo;
		this.direccion = direccion;
		this.tiposervicio = tiposervicio;
		this.fechafinalizacion = fechafinalizacion;
		this.departamento = departamento;
		this.distrito = distrito;
		this.responsable = responsable;
		this.fechaparafinalizar = fechaparafinalizar;
	}

	public int getAveriaid() {
		return averiaid;
	}

	public void setAveriaid(int averiaid) {
		this.averiaid = averiaid;
	}

	public String getInc() {
		return inc;
	}

	public void setInc(String inc) {
		this.inc = inc;
	}

	public String getSisego() {
		return sisego;
	}

	public void setSisego(String sisego) {
		this.sisego = sisego;
	}

	public String getZonal() {
		return zonal;
	}

	public void setZonal(String zonal) {
		this.zonal = zonal;
	}

	public String getZonificacion() {
		return zonificacion;
	}

	public void setZonificacion(String zonificacion) {
		this.zonificacion = zonificacion;
	}

	public String getContrata() {
		return contrata;
	}

	public void setContrata(String contrata) {
		this.contrata = contrata;
	}

	public String getTecnicoAsignado() {
		return tecnicoAsignado;
	}

	public void setTecnicoAsignado(String tecnicoAsignado) {
		this.tecnicoAsignado = tecnicoAsignado;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getTipoAveria() {
		return tipoAveria;
	}

	public void setTipoAveria(String tipoAveria) {
		this.tipoAveria = tipoAveria;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getParadaReloj() {
		return paradaReloj;
	}

	public void setParadaReloj(String paradaReloj) {
		this.paradaReloj = paradaReloj;
	}

	public String getAccionesCorrectivas() {
		return accionesCorrectivas;
	}

	public void setAccionesCorrectivas(String accionesCorrectivas) {
		this.accionesCorrectivas = accionesCorrectivas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getMateriales() {
		return materiales;
	}

	public void setMateriales(String materiales) {
		this.materiales = materiales;
	}

	public String getLiquidadotrabajo() {
		return liquidadotrabajo;
	}

	public void setLiquidadotrabajo(String liquidadotrabajo) {
		this.liquidadotrabajo = liquidadotrabajo;
	}

	public String getCertificaciontrabajo() {
		return certificaciontrabajo;
	}

	public void setCertificaciontrabajo(String certificaciontrabajo) {
		this.certificaciontrabajo = certificaciontrabajo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public String getFechafinalizacion() {
		return fechafinalizacion;
	}

	public void setFechafinalizacion(String fechafinalizacion) {
		this.fechafinalizacion = fechafinalizacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getFechaparafinalizar() {
		return fechaparafinalizar;
	}

	public void setFechaparafinalizar(String fechaparafinalizar) {
		this.fechaparafinalizar = fechaparafinalizar;
	}
	
}
