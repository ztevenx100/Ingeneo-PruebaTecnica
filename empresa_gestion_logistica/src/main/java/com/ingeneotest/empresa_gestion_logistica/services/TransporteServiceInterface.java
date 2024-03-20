package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;

public interface TransporteServiceInterface {

    List<Transporte> obtenerTodosTransportes();

    Optional<Transporte> obtenerTransportePorId(String id);

    Transporte guardarTransporte(Transporte Transporte);

    void eliminarTransporte(String id);

}