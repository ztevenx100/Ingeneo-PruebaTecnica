package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ingeneotest.empresa_gestion_logistica.models.Almacen;
import com.ingeneotest.empresa_gestion_logistica.repositories.AlmacenRepository;

import org.springframework.stereotype.Service;

@Service
public class AlmacenService implements AlmacenServiceInterface {

    private AlmacenRepository almacenRepository;

    public AlmacenService(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }

    @Override
    public List<Almacen> obtenerTodosAlmacenes() {
        return almacenRepository.findAll();
    }
    
    @Override
    public List<Almacen> obtenerAlmacenesFiltados(Almacen filtro) {
        List<Almacen> almacenes = almacenRepository.findAll();

        // Filtrar almacenes según los campos diligenciados en el filtro
        return almacenes.stream()
                .filter(almacen -> coincideConFiltro(almacen, filtro))
                .collect(Collectors.toList());
    }

    private boolean coincideConFiltro(Almacen almacen, Almacen filtro) {
        // Verificar si los campos del almacen coinciden con los campos diligenciados en el filtro
        if (filtro.getId() != null && !filtro.getId().isEmpty() && !almacen.getId().contains(filtro.getId())) {
            return false;
        }
        if (filtro.getTipo() != null && !filtro.getTipo().isEmpty() && !almacen.getTipo().contains(filtro.getTipo())) {
            return false;
        }
        if (filtro.getNombre() != null && !filtro.getNombre().isEmpty() && !almacen.getNombre().contains(filtro.getNombre())) {
            return false;
        }
        if (filtro.getDescripcion() != null && !filtro.getDescripcion().isEmpty() && !almacen.getDescripcion().contains(filtro.getDescripcion())) {
            return false;
        }
        if (filtro.getDireccion() != null && !filtro.getDireccion().isEmpty() && !almacen.getDireccion().contains(filtro.getDireccion())) {
            return false;
        }
        if (filtro.getEstado() != null && !filtro.getEstado().isEmpty() && !almacen.getEstado().contains(filtro.getEstado())) {
            return false;
        }
        return true;
    }

    @Override
    public List<Almacen> obtenerAlmacenesPorEstados() {
        List<String> l = Arrays.asList("A".split(","));
        return obtenerAlmacenesPorEstados(l);
    }

    @Override
    public List<Almacen> obtenerAlmacenesPorEstados(List<String> estados) {
        return almacenRepository.findByEstadoIn(estados);
    }

    @Override
    public Optional<Almacen> obtenerAlmacenPorId(String id) {
        return almacenRepository.findById(id);
    }

    @Override
    public Almacen guardarAlmacen(Almacen Almacen) {
        return almacenRepository.save(Almacen);
    }

    @Override
    public void eliminarAlmacen(String id) {
        almacenRepository.deleteById(id);
    }
    
}

