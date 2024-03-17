package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    
    @RequestMapping("/")
    public String redireccionarAlIndex() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String mostrarIndex() {
        // Aquí puedes mostrar tu página de inicio (index.html u otra)
        return "index";
    }
}
