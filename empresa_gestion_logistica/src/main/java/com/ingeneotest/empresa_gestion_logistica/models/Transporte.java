package com.ingeneotest.empresa_gestion_logistica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tra_transporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tra_id", nullable = false)
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
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getIdResponsable() {
        return idResponsable;
    }
    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }
    
    public String getNomResponsable() {
        return nomResponsable;
    }
    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipo=" + tipo + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", idResponsable=" + idResponsable + ", nomResponsable=" + nomResponsable + ", estado=" + estado + "]";
    }

}
