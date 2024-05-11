package utp.edu.pe.integrador.productor.model;

import javax.persistence.*;

@Entity
@Table(name="distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistrito;

    private String codDistrito;

    private String nombreDistrito;

    private String estadoDistrito;

    private String codProvincia;

    private String codDepartamento;

    public Distrito(){

    }

    public Distrito(int idDistrito, String codDistrito, String nombreDistrito, String estadoDistrito, String codProvincia, String codDepartamento) {
        this.idDistrito = idDistrito;
        this.codDistrito = codDistrito;
        this.nombreDistrito = nombreDistrito;
        this.estadoDistrito = estadoDistrito;
        this.codProvincia = codProvincia;
        this.codDepartamento = codDepartamento;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getCodDistrito() {
        return codDistrito;
    }

    public void setCodDistrito(String codDistrito) {
        this.codDistrito = codDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getEstadoDistrito() {
        return estadoDistrito;
    }

    public void setEstadoDistrito(String estadoDistrito) {
        this.estadoDistrito = estadoDistrito;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
}
