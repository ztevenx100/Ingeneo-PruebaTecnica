package com.ingeneotest.empresa_gestion_logistica.models;

public class TransporteTerrestre extends Transporte{

    public TransporteTerrestre() {
    }

    public TransporteTerrestre(String id, String tipo, String matricula, String marca, String modelo, String idResponsable, String nomResponsable, String estado) {
        super(id, tipo, matricula, marca, modelo, idResponsable, nomResponsable, estado);
    }
    
    @Override
    public boolean validarFormatoMatricula(){
        return this.getMatricula().matches("[A-Za-z]{3}\\d{3}");
    }

}
