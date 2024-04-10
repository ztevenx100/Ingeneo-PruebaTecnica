package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Almacen;

public interface AlmacenServiceInterface {

    List<Almacen> obtenerTodosAlmacenes();

    List<Almacen> obtenerAlmacenesFiltados(Almacen filtro);
    
    List<Almacen> obtenerAlmacenesPorEstados();
    
    List<Almacen> obtenerAlmacenesPorEstados(List<String> estados);

    Optional<Almacen> obtenerAlmacenPorId(String id);

    Almacen guardarAlmacen(Almacen Almacen);

    void eliminarAlmacen(String id);

}