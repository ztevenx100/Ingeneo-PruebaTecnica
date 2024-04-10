package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingeneotest.empresa_gestion_logistica.models.Entrega;

public interface EntregaControllerInterface {

    String obtenerTodosEntregas(Model model, Entrega entregaFiltro);

    String obtenerEntregaPorId(String action, String id, Model model);

    String guardarEntrega(String action, String id, Entrega entrega, Model model, RedirectAttributes redirectAttributes);

    String eliminarEntrega(String id, Model model, RedirectAttributes redirectAttributes);

}