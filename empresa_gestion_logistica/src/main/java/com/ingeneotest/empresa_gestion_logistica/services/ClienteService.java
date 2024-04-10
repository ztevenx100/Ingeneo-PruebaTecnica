package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;
import com.ingeneotest.empresa_gestion_logistica.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteServiceInterface {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> obtenerClientesFiltados(Cliente filtro) {
        List<Cliente> clientes = clienteRepository.findAll();

        // Filtrar clientes según los campos diligenciados en el filtro
        return clientes.stream()
                .filter(cliente -> coincideConFiltro(cliente, filtro))
                .collect(Collectors.toList());
    }

    private boolean coincideConFiltro(Cliente cliente, Cliente filtro) {
        // Verificar si los campos del cliente coinciden con los campos diligenciados en el filtro
        if (filtro.getId() != null && !filtro.getId().isEmpty() && !cliente.getId().contains(filtro.getId())) {
            return false;
        }
        if (filtro.getTipoId() != null && !filtro.getTipoId().isEmpty() && !cliente.getTipoId().contains(filtro.getTipoId())) {
            return false;
        }
        if (filtro.getNombre() != null && !filtro.getNombre().isEmpty() && !cliente.getNombre().contains(filtro.getNombre())) {
            return false;
        }
        if (filtro.getTelefono() != null && !filtro.getTelefono().isEmpty() && !cliente.getTelefono().contains(filtro.getTelefono())) {
            return false;
        }
        if (filtro.getEmail() != null && !filtro.getEmail().isEmpty() && !cliente.getEmail().contains(filtro.getEmail())) {
            return false;
        }
        if (filtro.getDireccion() != null && !filtro.getDireccion().isEmpty() && !cliente.getDireccion().contains(filtro.getDireccion())) {
            return false;
        }
        if (filtro.getEstado() != null && !filtro.getEstado().isEmpty() && !cliente.getEstado().contains(filtro.getEstado())) {
            return false;
        }
        return true;
    }

    @Override
    public List<Cliente> obtenerClientesPorEstados() {
        List<String> l = Arrays.asList("A".split(","));
        return obtenerClientesPorEstados(l);
    }

    @Override
    public List<Cliente> obtenerClientesPorEstados(List<String> estados) {
        return clienteRepository.findByEstadoIn(estados);
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(String id) {
        clienteRepository.deleteById(id);
    }

}

