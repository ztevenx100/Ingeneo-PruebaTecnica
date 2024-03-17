package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    
    // @RequestMapping("/")
    // public String redireccionarAlIndex() {
    //     return "redirect:/index";
    // }

    @GetMapping("/error")
    public String mostrarIndex() {
        // Aquí puedes mostrar tu página de inicio (index.html u otra)
        return "error";
    }
}
