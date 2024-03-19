package com.ingeneotest.empresa_gestion_logistica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cli_cliente")
public class Cliente {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cli_id", nullable = false)
    private String id;
    @Column(name = "cli_tipo_id", nullable = false)
    private String tipoId;
    @Column(name = "cli_nombre", nullable = false)
    private String nombre;
    @Column(name = "cli_telefono")
    private String telefono;
    @Column(name = "cli_email", nullable = false)
    private String email;
    @Column(name = "cli_direccion")
    private String direccion;
    @Column(name = "cli_estado", nullable = false, columnDefinition = "text default 'A'")
    private String estado;
    
    public Cliente() {
    }
    
    public Cliente(String id, String tipoId, String nombre, String telefono, String email, String direccion, String estado) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTipoId() {
        return tipoId;
    }
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
        return "Cliente [id=" + id + ", tipoId=" + tipoId + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
    }
    
    

}
