package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;
import com.ingeneotest.empresa_gestion_logistica.repositories.TransporteRepository;

import org.springframework.stereotype.Service;

@Service
public class TransporteService implements TransporteServiceInterface {

    private TransporteRepository transporteRepository;

    public TransporteService(TransporteRepository transporteRepository) {
        this.transporteRepository = transporteRepository;
    }

    @Override
    public List<Transporte> obtenerTodosTransportes() {
        return transporteRepository.findAll();
    }
    
    @Override
    public List<Transporte> obtenerTransportesFiltados(Transporte filtro) {
        List<Transporte> transportes = transporteRepository.findAll();

        // Filtrar transportes según los campos diligenciados en el filtro
        return transportes.stream()
                .filter(transporte -> coincideConFiltro(transporte, filtro))
                .collect(Collectors.toList());
    }

    private boolean coincideConFiltro(Transporte transporte, Transporte filtro) {
        // Verificar si los campos del transporte coinciden con los campos diligenciados en el filtro
        if (filtro.getId() != null && !filtro.getId().isEmpty() && !transporte.getId().contains(filtro.getId())) {
            return false;
        }
        if (filtro.getTipo() != null && !filtro.getTipo().isEmpty() && !transporte.getTipo().contains(filtro.getTipo())) {
            return false;
        }
        if (filtro.getMatricula() != null && !filtro.getMatricula().isEmpty() && !transporte.getMatricula().contains(filtro.getMatricula())) {
            return false;
        }
        if (filtro.getMarca() != null && !filtro.getMarca().isEmpty() && !transporte.getMarca().contains(filtro.getMarca())) {
            return false;
        }
        if (filtro.getModelo() != null && !filtro.getModelo().isEmpty() && !transporte.getModelo().contains(filtro.getModelo())) {
            return false;
        }
        if (filtro.getIdResponsable() != null && !filtro.getIdResponsable().isEmpty() && !transporte.getIdResponsable().contains(filtro.getIdResponsable())) {
            return false;
        }
        if (filtro.getNomResponsable() != null && !filtro.getNomResponsable().isEmpty() && !transporte.getNomResponsable().contains(filtro.getNomResponsable())) {
            return false;
        }
        if (filtro.getEstado() != null && !filtro.getEstado().isEmpty() && !transporte.getEstado().contains(filtro.getEstado())) {
            return false;
        }
        return true;
    }

    @Override
    public List<Transporte> obtenerTransportesPorEstados() {
        List<String> l = Arrays.asList("A".split(","));
        return obtenerTransportesPorEstados(l);
    }

    @Override
    public List<Transporte> obtenerTransportesPorEstados(List<String> estados) {
        return transporteRepository.findByEstadoIn(estados);
    }

    @Override
    public Optional<Transporte> obtenerTransportePorId(String id) {
        return transporteRepository.findById(id);
    }

    @Override
    public Transporte guardarTransporte(Transporte Transporte) {
        return transporteRepository.save(Transporte);
    }

    @Override
    public void eliminarTransporte(String id) {
        transporteRepository.deleteById(id);
    }

}

