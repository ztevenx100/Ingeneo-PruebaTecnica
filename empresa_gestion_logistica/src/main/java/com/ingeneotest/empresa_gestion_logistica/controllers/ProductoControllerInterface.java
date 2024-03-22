package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingeneotest.empresa_gestion_logistica.models.Producto;

public interface ProductoControllerInterface {

    String obtenerTodosProductos(Model model);

    String obtenerProductoPorId(String action, String id, Model model);

    String guardarProducto(String action, String id, Producto Producto, Model model, RedirectAttributes redirectAttributes);

    String eliminarProducto(String id, Model model, RedirectAttributes redirectAttributes);

}