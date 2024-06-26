package com.ingeneotest.empresa_gestion_logistica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pro_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotEmpty(message = "El ID no puede estar vacío")
    @NotNull(message = "El ID no puede ser nulo")
    @Column(name = "pro_id", nullable = false)
    private String id;
    @Column(name = "pro_tipo", nullable = false)
    private String tipo;
    @Column(name = "pro_nombre", nullable = false)
    private String nombre;
    @Column(name = "pro_cantidad", nullable = false, columnDefinition = "numeric(6,0) default 0 ")
    private Double cantidad;
    @Column(name = "pro_valor_unitario", nullable = false, columnDefinition = "numeric(12,2) default 0 ")
    private Double valorUnitario;
    @Column(name = "pro_estado", nullable = false, columnDefinition = "text default 'A' ")
    private String estado;
    
    public Producto() {
    }
    
    public Producto(String id, String tipo, String nombre, Double cantidad, Double valorUnitario, String estado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
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
    
    public Double getCantidad() {
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", valorUnitario=" + valorUnitario + ", estado=" + estado + "]";
    }

}
