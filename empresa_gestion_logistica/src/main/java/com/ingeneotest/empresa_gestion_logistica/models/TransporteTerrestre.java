package com.ingeneotest.empresa_gestion_logistica.models;

public class TransporteTerrestre extends Transporte{

    public TransporteTerrestre() {
    }
    
    @Override
    public boolean validarFormatoMatricula(){
        return true;
    }

}
