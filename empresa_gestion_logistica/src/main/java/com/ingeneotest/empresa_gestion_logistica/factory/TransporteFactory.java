package com.ingeneotest.empresa_gestion_logistica.factory;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;

public interface TransporteFactory {

    Transporte crearTransporte();
    Transporte crearTransporte(Transporte vo);

}
