package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.ui.Model;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;

public interface TransporteControllerInterface {

    String obtenerTodosTransportes(Model model);

    String obtenerTransportePorId(String action, String id, Model model);

    String guardarTransporte(String action, String id, Transporte transporte, Model model);

    String eliminarTransporte(String id, Model model);

}