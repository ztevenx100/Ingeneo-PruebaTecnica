package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Entrega;
import com.ingeneotest.empresa_gestion_logistica.repositories.EntregaRepository;

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
    public Optional<Entrega> obtenerEntregaPorId(String id) {
        return entregaRepository.findById(id);
    }

    @Override
    public Entrega guardarEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @Override
    public void eliminarEntrega(String id) {
        entregaRepository.deleteById(id);
    }
    
}

