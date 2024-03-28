package com.ingeneotest.empresa_gestion_logistica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    
    // @RequestMapping("/")
    // public String redireccionarAlIndex() {
    //     return "redirect:/index";
    // }

    @GetMapping("/error")
    public String mostrarIndex(Model model) {
        // Aquí puedes mostrar tu página de inicio (index.html u otra)
        model.addAttribute("notificacion", model.getAttribute("notificacion"));
        model.addAttribute("error", model.getAttribute("error"));
        return "error";
    }
}
