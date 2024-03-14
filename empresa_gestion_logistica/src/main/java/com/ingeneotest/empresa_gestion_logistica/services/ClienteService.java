package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;
import com.ingeneotest.empresa_gestion_logistica.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosClientes() {
        //List<Cliente> l = new LinkedList<Cliente>();
        //return l;
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(String id) {
        //Cliente vo = new Cliente();
        //Optional<Cliente> vo = Optional.of(new Cliente());
        //return vo;
        return clienteRepository.findById(id);
    }

    public Cliente guardarCliente(Cliente cliente) {
        //Cliente vo = new Cliente();
        //return vo;
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(String id) {
        clienteRepository.deleteById(id);
    }
    
}

