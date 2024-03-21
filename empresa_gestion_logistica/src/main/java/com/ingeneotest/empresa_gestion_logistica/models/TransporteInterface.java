package com.ingeneotest.empresa_gestion_logistica.models;

public abstract class TransporteInterface {

    public abstract String getId();

    public abstract void setId(String id);

    public abstract String getTipo();

    public abstract void setTipo(String tipo);

    public abstract String getMatricula();

    public abstract void setMatricula(String matricula);

    public abstract String getMarca();

    public abstract void setMarca(String marca);

    public abstract String getModelo();

    public abstract void setModelo(String modelo);

    public abstract String getIdResponsable();

    public abstract void setIdResponsable(String idResponsable);

    public abstract String getNomResponsable();

    public abstract void setNomResponsable(String nomResponsable);

    public abstract String getEstado();

    public abstract void setEstado(String estado);

    public abstract String toString();

    public abstract boolean validarFormatoMatricula();

}