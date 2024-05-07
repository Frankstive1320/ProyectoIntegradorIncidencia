package utp.edu.pe.integrador.productor.model;

import javax.persistence.*;

@Entity
@Table(name="departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;

    private String codDepartamento;

    private String nombreDepartamento;

    private String estadoDepartamento;

    public Departamento(){

    }

    public Departamento(String nombreDepartamento, int idDepartamento, String estadoDepartamento) {
        this.codDepartamento = codDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.idDepartamento = idDepartamento;
        this.estadoDepartamento = estadoDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public String getEstadoDepartamento() {
        return estadoDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public void setEstadoDepartamento(String estadoDepartamento) {
        this.estadoDepartamento = estadoDepartamento;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
}
