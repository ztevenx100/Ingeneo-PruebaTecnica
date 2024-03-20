package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

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

