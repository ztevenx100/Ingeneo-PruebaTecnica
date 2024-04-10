package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;

public interface TransporteServiceInterface {
    public static final String TIPO_TERRESTRE = "T";
    public static final String TIPO_MARITIMO = "M";

    List<Transporte> obtenerTodosTransportes();

    List<Transporte> obtenerTransportesFiltados(Transporte filtro);
    
    List<Transporte> obtenerTransportesPorEstados();
    
    List<Transporte> obtenerTransportesPorEstados(List<String> estados);

    Optional<Transporte> obtenerTransportePorId(String id);

    Transporte guardarTransporte(Transporte Transporte);

    void eliminarTransporte(String id);

}