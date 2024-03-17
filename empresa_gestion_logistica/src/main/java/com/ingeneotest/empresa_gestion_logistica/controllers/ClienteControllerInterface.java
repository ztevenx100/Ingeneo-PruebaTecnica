package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.ui.Model;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;

public interface ClienteControllerInterface {

    String obtenerTodosClientes(Model model);

    String obtenerClientePorId(String action, String id, Model model);

    String guardarCliente(String action, String id, Cliente cliente, Model model);

    String eliminarCliente(String id, Model model);

}