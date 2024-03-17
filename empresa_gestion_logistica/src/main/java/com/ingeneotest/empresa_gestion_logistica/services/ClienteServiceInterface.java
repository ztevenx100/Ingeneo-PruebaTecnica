package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;

public interface ClienteServiceInterface {

    List<Cliente> obtenerTodosClientes();

    Optional<Cliente> obtenerClientePorId(String id);

    Cliente guardarCliente(Cliente cliente);

    void eliminarCliente(String id);

}