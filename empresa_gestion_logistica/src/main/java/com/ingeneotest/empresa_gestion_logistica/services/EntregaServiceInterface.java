package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Entrega;

public interface EntregaServiceInterface {

    List<Entrega> obtenerTodosEntregas();

    Optional<Entrega> obtenerEntregaPorId(String id);

    Entrega guardarEntrega(Entrega entrega);

    void eliminarEntrega(String id);

}