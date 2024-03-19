package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.ui.Model;

import com.ingeneotest.empresa_gestion_logistica.models.Almacen;

public interface AlmacenControllerInterface {

    String obtenerTodosAlmacenes(Model model);

    String obtenerAlmacenPorId(String action, String id, Model model);

    String guardarAlmacen(String action, String id, Almacen Almacen, Model model);

    String eliminarAlmacen(String id, Model model);

}