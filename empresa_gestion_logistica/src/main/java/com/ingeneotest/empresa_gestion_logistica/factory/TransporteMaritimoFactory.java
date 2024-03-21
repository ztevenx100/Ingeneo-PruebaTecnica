package com.ingeneotest.empresa_gestion_logistica.factory;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;
import com.ingeneotest.empresa_gestion_logistica.models.TransporteMaritimo;

public class TransporteMaritimoFactory implements TransporteFactory {
    @Override
    public Transporte crearTransporte() {
        return new TransporteMaritimo();
    }

    @Override
    public TransporteMaritimo crearTransporte(Transporte vo) {
        TransporteMaritimo v_tra = new TransporteMaritimo();
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
