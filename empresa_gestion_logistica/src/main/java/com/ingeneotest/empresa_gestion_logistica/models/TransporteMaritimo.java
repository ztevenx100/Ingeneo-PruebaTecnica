package com.ingeneotest.empresa_gestion_logistica.models;

public class TransporteMaritimo extends Transporte{

    public TransporteMaritimo() {
    }
    
    @Override
    public boolean validarFormatoMatricula(){
        return true;
    }

}
