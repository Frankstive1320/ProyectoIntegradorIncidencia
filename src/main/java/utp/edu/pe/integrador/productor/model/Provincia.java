package utp.edu.pe.integrador.productor.model;

import javax.persistence.*;

@Entity
@Table(name="provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProvincia;

    private String codProvincia;

    private String nombreProvincia;

    private String estadoProvincia;

    private String codDepartamento;

    public Provincia(){

    }

    public Provincia(int idProvincia, String codProvincia, String nombreProvincia, String estadoProvincia, String codDepartamento) {
        this.idProvincia = idProvincia;
        this.codProvincia = codProvincia;
        this.nombreProvincia = nombreProvincia;
        this.estadoProvincia = estadoProvincia;
        this.codDepartamento = codDepartamento;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getEstadoProvincia() {
        return estadoProvincia;
    }

    public void setEstadoProvincia(String estadoProvincia) {
        this.estadoProvincia = estadoProvincia;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
}
