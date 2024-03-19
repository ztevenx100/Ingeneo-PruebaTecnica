package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

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

