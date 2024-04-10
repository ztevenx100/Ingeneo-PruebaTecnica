package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Producto;

public interface ProductoServiceInterface {

    List<Producto> obtenerTodosProductos();

    List<Producto> obtenerProductosFiltados(Producto filtro);
    
    List<Producto> obtenerProductosPorEstados();
    
    List<Producto> obtenerProductosPorEstados(List<String> estados);

    Optional<Producto> obtenerProductoPorId(String id);

    Producto guardarProducto(Producto producto);

    void eliminarProducto(String id);

}