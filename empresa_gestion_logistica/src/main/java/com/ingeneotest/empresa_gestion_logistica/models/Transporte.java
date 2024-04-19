package com.ingeneotest.empresa_gestion_logistica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tra_transporte")
public class Transporte extends TransporteInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tra_id", nullable = false)
    @NotEmpty(message = "El ID no puede estar vacío")
    @NotNull(message = "El ID no puede ser nulo")
    private String id;
    @Column(name = "tra_tipo", nullable = false)
    private String tipo;
    @Column(name = "tra_matricula", nullable = false)
    private String matricula;
    @Column(name = "tra_marca", nullable = false)
    private String marca;
    @Column(name = "tra_modelo", nullable = false)
    private String modelo;
    @Column(name = "tra_id_responsable", nullable = false)
    private String idResponsable;
    @Column(name = "tra_nom_responsable")
    private String nomResponsable;
    @Column(name = "tra_estado", nullable = false, columnDefinition = "text default 'A' ")
    private String estado;
    
    public Transporte() {
    }
    
    public Transporte(String id, String tipo, String matricula, String marca, String modelo, String idResponsable, String nomResponsable, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.idResponsable = idResponsable;
        this.nomResponsable = nomResponsable;
        this.estado = estado;
    }
    
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String getMatricula() {
        return matricula;
    }
    @Override
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    @Override
    public String getMarca() {
        return marca;
    }
    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }
    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public String getIdResponsable() {
        return idResponsable;
    }
    @Override
    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    @Override
    public String getNomResponsable() {
        return nomResponsable;
    }
    @Override
    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }
    
    @Override
    public String getEstado() {
        return estado;
    }
    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipo=" + tipo + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", idResponsable=" + idResponsable + ", nomResponsable=" + nomResponsable + ", estado=" + estado + "]";
    }

    @Override
    public boolean validarFormatoMatricula(){
        return true;
    }

}
