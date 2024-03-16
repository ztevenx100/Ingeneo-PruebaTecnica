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
    @Column(name = "cli_id")
    private String id;
    @Column(name = "cli_tipo_id")
    private String tipoId;
    @Column(name = "cli_nombre")
    private String nombre;
    @Column(name = "cli_telefono")
    private String telefono;
    @Column(name = "cli_email")
    private String email;
    @Column(name = "cli_direccion")
    private String direccion;
    
    public Cliente() {
    }
    
    public Cliente(String id, String tipoId, String nombre, String telefono, String email, String direccion) {
        this.id = id;
        this.tipoId = tipoId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
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
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", tipoId=" + tipoId + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
    }
    
    

}
