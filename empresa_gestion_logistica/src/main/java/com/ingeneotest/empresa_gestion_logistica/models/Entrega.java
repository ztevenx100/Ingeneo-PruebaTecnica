package com.ingeneotest.empresa_gestion_logistica.models;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ent_entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ent_id", nullable = false)
    private String id;
    // @Column(name = "ent_cli", nullable = false)
    // private String cliente;
    //@Column(name = "ent_cli", nullable = false)
    @ManyToOne
    @JoinColumn(name = "ent_cli")
    private Cliente cliente;
    @Column(name = "ent_pro", nullable = false)
    private String producto;
    @Column(name = "ent_alm", nullable = false)
    private String almacen;
    @Column(name = "ent_tra", nullable = false)
    private String transporte;
    @Column(name = "ent_num_guia", nullable = false)
    private String numeroGuia;
    @Column(name = "ent_fec_registro", nullable = false, columnDefinition = "timestamp with time zone")
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mmZ")
    private OffsetDateTime fecRegistro;
    @Column(name = "ent_fec_entrega", nullable = false, columnDefinition = "timestamp with time zone")
    //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mmZ")
    private OffsetDateTime  fecEntrega;
    @Column(name = "ent_estado", nullable = false, columnDefinition = "text default 'A' ")
    private String estado;
    
    public Entrega() {
    }
    
    public Entrega(String id, Cliente cliente, String producto, String almacen, String transporte, String numeroGuia, OffsetDateTime fecRegistro, OffsetDateTime fecEntrega, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.almacen = almacen;
        this.transporte = transporte;
        this.numeroGuia = numeroGuia;
        this.fecRegistro = fecRegistro;
        this.fecEntrega = fecEntrega;
        this.estado = estado;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    // public String getCliente() {
    //     return cliente;
    // }
    // public void setCliente(String cliente) {
    //     this.cliente = cliente;
    // }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public String getAlmacen() {
        return almacen;
    }
    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }
    
    public String getTransporte() {
        return transporte;
    }
    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }
    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }
    
    public OffsetDateTime getFecRegistro() {
        return fecRegistro;
    }
    public void setFecRegistro(OffsetDateTime fecRegistro) {
        this.fecRegistro = fecRegistro;
    }
    // public void setFecRegistro(String fecRegistro) {
    //     this.fecRegistro = OffsetDateTime.parse(fecRegistro);
    // }
    
    public OffsetDateTime getFecEntrega() {
        return fecEntrega;
    }
    public void setFecEntrega(OffsetDateTime fecEntrega) {
        this.fecEntrega = fecEntrega;
    }
    // public void setFecEntrega(String fecEntrega) {
    //     this.fecEntrega = OffsetDateTime.parse(fecEntrega);
    // }
    
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id 
        + ", cliente=" + cliente
        + ", producto=" + producto
        + ", almacen=" + almacen
        + ", transporte=" + transporte
        + ", numeroGuia=" + numeroGuia
        + ", fecRegistro=" + fecRegistro
        + ", fecEntrega=" + fecEntrega
        + ", estado=" + estado + "]";
    }


}
