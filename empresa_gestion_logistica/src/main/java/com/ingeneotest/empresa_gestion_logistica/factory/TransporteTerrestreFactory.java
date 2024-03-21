package com.ingeneotest.empresa_gestion_logistica.factory;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;
import com.ingeneotest.empresa_gestion_logistica.models.TransporteTerrestre;

public class TransporteTerrestreFactory implements TransporteFactory {
    @Override
    public Transporte crearTransporte() {
        return new TransporteTerrestre();
    }

    @Override
    public TransporteTerrestre crearTransporte(Transporte vo) {
        TransporteTerrestre v_tra = new TransporteTerrestre();
        v_tra.setId(vo.getId());
        v_tra.setTipo(vo.getTipo());
        v_tra.setMatricula(vo.getMatricula());
        v_tra.setMarca(vo.getMarca());
        v_tra.setModelo(vo.getModelo());
        v_tra.setIdResponsable(vo.getIdResponsable());
        v_tra.setNomResponsable(vo.getNomResponsable());
        v_tra.setEstado(vo.getEstado());

        return v_tra;
    }
    
}
