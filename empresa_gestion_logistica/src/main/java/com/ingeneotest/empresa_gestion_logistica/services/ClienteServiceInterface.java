package com.ingeneotest.empresa_gestion_logistica.services;

import java.util.List;
import java.util.Optional;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;

public interface ClienteServiceInterface {

    List<Cliente> obtenerTodosClientes();

    List<Cliente> obtenerClientesFiltados(Cliente filtro);

    List<Cliente> obtenerClientesPorEstados();
    
    List<Cliente> obtenerClientesPorEstados(List<String> estados);

    Optional<Cliente> obtenerClientePorId(String id);

    Cliente guardarCliente(Cliente cliente);

    void eliminarCliente(String id);

}