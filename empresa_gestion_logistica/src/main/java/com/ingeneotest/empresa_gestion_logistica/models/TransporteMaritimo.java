package com.ingeneotest.empresa_gestion_logistica.models;

public class TransporteMaritimo extends Transporte{

    public TransporteMaritimo() {
    }
    
    public TransporteMaritimo(String id, String tipo, String matricula, String marca, String modelo, String idResponsable, String nomResponsable, String estado) {
        super(id, tipo, matricula, marca, modelo, idResponsable, nomResponsable, estado);
    }

    @Override
    public boolean validarFormatoMatricula(){
        return this.getMatricula().matches("[A-Za-z]{3}\\d{4}[A-Za-z]");
    }

}
