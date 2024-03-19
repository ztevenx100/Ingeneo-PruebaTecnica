package com.ingeneotest.empresa_gestion_logistica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alm_almacen")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "alm_id", nullable = false)
    private String id;
    @Column(name = "alm_tipo", nullable = false)
    private String tipo;
    @Column(name = "alm_nombre", nullable = false)
    private String nombre;
    @Column(name = "alm_descripcion")
    private String descripcion;
    @Column(name = "alm_direccion", nullable = false)
    private String direccion;
    @Column(name = "alm_estado", nullable = false, columnDefinition = "text default 'A' ")
    private String estado;
    
    public Almacen() {
    }
    
    public Almacen(String id, String tipo, String nombre, String descripcion, String direccion, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
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
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", direccion=" + direccion + ", estado=" + estado + "]";
    }

}
