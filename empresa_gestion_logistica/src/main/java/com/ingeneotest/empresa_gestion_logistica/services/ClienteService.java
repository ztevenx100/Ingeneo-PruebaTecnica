package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

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

