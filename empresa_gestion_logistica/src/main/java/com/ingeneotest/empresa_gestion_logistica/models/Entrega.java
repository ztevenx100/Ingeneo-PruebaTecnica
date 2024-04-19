package com.ingeneotest.empresa_gestion_logistica.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ent_entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ent_id", nullable = false)
    @NotEmpty(message = "El ID no puede estar vacío")
    @NotNull(message = "El ID no puede ser nulo")
    private String id;
    @Column(name = "ent_tipo", nullable = false, columnDefinition = "text default 'T' ")
    private String tipo;
    // @Column(name = "ent_cli", nullable = false)
    // private String cliente;
    //@Column(name = "ent_cli", nullable = false)
    @ManyToOne
    @JoinColumn(name = "ent_cli")
    private Cliente cliente;
    // @Column(name = "ent_pro", nullable = false)
    // private String producto;
    @ManyToOne
    @JoinColumn(name = "ent_pro")
    private Producto producto;
    // @Column(name = "ent_alm", nullable = false)
    // private String almacen;
    @ManyToOne
    @JoinColumn(name = "ent_alm")
    private Almacen almacen;
    // @Column(name = "ent_tra", nullable = false)
    // private String transporte;
    @ManyToOne
    @JoinColumn(name = "ent_tra")
    private Transporte transporte;
    @Column(name = "ent_num_guia", nullable = false)
    private String numeroGuia;
    @Column(name = "ent_fec_registro", nullable = false, columnDefinition = "timestamp with time zone")
    private LocalDateTime fecRegistro;
    @Column(name = "ent_fec_entrega", nullable = false, columnDefinition = "timestamp with time zone")
    private LocalDateTime  fecEntrega;
    @Column(name = "ent_cantidad", nullable = false, columnDefinition = "numeric default 0 ")
    private Double cantidad;
    @Column(name = "ent_valor_total", nullable = false, columnDefinition = "numeric default 0 ")
    private Double valorTotal;
    @Column(name = "ent_valor_descuento", nullable = false, columnDefinition = "numeric default 0 ")
    private Double valorDescuento;
    
    @Column(name = "ent_estado", nullable = false, columnDefinition = "text default 'A' ")
    private String estado;
    
    public Entrega() {
    }
    
    public Entrega(
            String id
            , String tipo
            , Cliente cliente
            , Producto producto
            , Almacen almacen
            , Transporte transporte
            , String numeroGuia
            , LocalDateTime fecRegistro
            , LocalDateTime fecEntrega
            , Double cantidad
            , Double valorTotal
            , Double valorDescuento
            , String estado) {
        this.id = id;
        this.tipo = tipo;
        this.cliente = cliente;
        this.producto = producto;
        this.almacen = almacen;
        this.transporte = transporte;
        this.numeroGuia = numeroGuia;
        this.fecRegistro = fecRegistro;
        this.fecEntrega = fecEntrega;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.valorDescuento = valorDescuento;
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
    
    // public String getCliente() {return cliente;}
    // public void setCliente(String cliente) {this.cliente = cliente;}
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    // public String getProducto() {return producto;}
    // public void setProducto(String producto) {this.producto = producto;}
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Almacen getAlmacen() {
        return almacen;
    }
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    
    public Transporte getTransporte() {
        return transporte;
    }
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    
    public String getNumeroGuia() {
        return numeroGuia;
    }
    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }
    
    public LocalDateTime getFecRegistro() {
        return fecRegistro;
    }
    public void setFecRegistro(LocalDateTime fecRegistro) {
        this.fecRegistro = fecRegistro;
    }
    
    public LocalDateTime getFecEntrega() {
        return fecEntrega;
    }
    public void setFecEntrega(LocalDateTime fecEntrega) {
        this.fecEntrega = fecEntrega;
    }
    
    public Double getCantidad() {
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }
    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
    
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
        + ", estado=" + estado 
        + ", tipo=" + tipo 
        + "]";
    }
    
    
}
