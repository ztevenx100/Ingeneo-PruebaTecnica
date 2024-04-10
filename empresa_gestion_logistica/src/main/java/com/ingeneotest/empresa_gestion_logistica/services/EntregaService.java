package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ingeneotest.empresa_gestion_logistica.models.Entrega;
import com.ingeneotest.empresa_gestion_logistica.repositories.EntregaRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EntregaService implements EntregaServiceInterface {

    private EntregaRepository entregaRepository;

    public EntregaService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public List<Entrega> obtenerTodosEntregas() {
        return entregaRepository.findAll();
    }
    
    @Override
    public List<Entrega> obtenerEntregasFiltados(Entrega filtro) {
        List<Entrega> entregas = entregaRepository.findAll();

        // Filtrar entregas según los campos diligenciados en el filtro
        return entregas.stream()
                .filter(entrega -> coincideConFiltro(entrega, filtro))
                .collect(Collectors.toList());
    }

    private boolean coincideConFiltro(Entrega entrega, Entrega filtro) {
        // Verificar si los campos de la entrega coinciden con los campos diligenciados en el filtro
        if (filtro.getId() != null && !filtro.getId().isEmpty() && !entrega.getId().contains(filtro.getId())) {
            return false;
        }
        if (filtro.getTipo() != null && !filtro.getTipo().isEmpty() && !entrega.getTipo().contains(filtro.getTipo())) {
            return false;
        }
        if (filtro.getCliente() != null && !filtro.getCliente().getId().isEmpty() && !entrega.getCliente().getId().contains(filtro.getCliente().getId())) {
            return false;
        }
        if (filtro.getProducto() != null && !filtro.getProducto().getId().isEmpty() && !entrega.getProducto().getId().contains(filtro.getProducto().getId())) {
            return false;
        }
        if (filtro.getAlmacen() != null && !filtro.getAlmacen().getId().isEmpty() && !entrega.getAlmacen().getId().contains(filtro.getAlmacen().getId())) {
            return false;
        }
        if (filtro.getTransporte() != null && !filtro.getTransporte().getId().isEmpty() && !entrega.getTransporte().getId().contains(filtro.getTransporte().getId())) {
            return false;
        }
        if (filtro.getNumeroGuia() != null && !filtro.getNumeroGuia().isEmpty() && !entrega.getNumeroGuia().contains(filtro.getNumeroGuia())) {
            return false;
        }
        if (filtro.getEstado() != null && !filtro.getEstado().isEmpty() && !entrega.getEstado().contains(filtro.getEstado())) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Entrega> obtenerEntregaPorId(String id) {
        return entregaRepository.findById(id);
    }

    @Override
    public Entrega guardarEntrega(Entrega entrega) throws DataIntegrityViolationException {
        return entregaRepository.save(entrega);
    }

    @Override
    public void eliminarEntrega(String id) {
        entregaRepository.deleteById(id);
    }
    
}

