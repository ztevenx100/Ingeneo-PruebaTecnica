package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ingeneotest.empresa_gestion_logistica.models.Producto;
import com.ingeneotest.empresa_gestion_logistica.repositories.ProductoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductoService implements ProductoServiceInterface {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository ProductoRepository) {
        this.productoRepository = ProductoRepository;
    }

    @Override
    public List<Producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> obtenerProductosFiltados(Producto filtro) {
        List<Producto> productos = productoRepository.findAll();

        // Filtrar clientes según los campos diligenciados en el filtro
        return productos.stream()
                .filter(cliente -> coincideConFiltro(cliente, filtro))
                .collect(Collectors.toList());
    }

    private boolean coincideConFiltro(Producto producto, Producto filtro) {
        // Verificar si los campos del producto coinciden con los campos diligenciados en el filtro
        if (filtro.getId() != null && !filtro.getId().isEmpty() && !producto.getId().contains(filtro.getId())) {
            return false;
        }
        if (filtro.getTipo() != null && !filtro.getTipo().isEmpty() && !producto.getTipo().contains(filtro.getTipo())) {
            return false;
        }
        if (filtro.getNombre() != null && !filtro.getNombre().isEmpty() && !producto.getNombre().contains(filtro.getNombre())) {
            return false;
        }
        if (filtro.getEstado() != null && !filtro.getEstado().isEmpty() && !producto.getEstado().contains(filtro.getEstado())) {
            return false;
        }
        return true;
    }

    @Override
    public List<Producto> obtenerProductosPorEstados() {
        List<String> l = Arrays.asList("A".split(","));
        return obtenerProductosPorEstados(l);
    }

    @Override
    public List<Producto> obtenerProductosPorEstados(List<String> estados) {
        return productoRepository.findByEstadoIn(estados);
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(String id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }
    
}

