package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

