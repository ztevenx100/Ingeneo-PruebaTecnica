package com.ingeneotest.empresa_gestion_logistica.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ingeneotest.empresa_gestion_logistica.models.Transporte;
import com.ingeneotest.empresa_gestion_logistica.services.TransporteServiceInterface;


@Controller
public class TransporteController implements TransporteControllerInterface{
    private final TransporteServiceInterface transporteService;

    @Autowired
    public TransporteController(TransporteServiceInterface transporteService) {
        this.transporteService = transporteService;
    }

    @Override
    @GetMapping("/transporte")
    public String obtenerTodosTransportes(Model model) {
        String path = "transporte/transporteLst";

        try {
            List<Transporte> l = transporteService.obtenerTodosTransportes();
            model.addAttribute("transportes", l);
            Transporte vo = new Transporte();
            model.addAttribute("transporteNuevo", vo);
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/transporte/{action}/{id}")
    public String obtenerTransportePorId(@PathVariable String action, @PathVariable("id") String id, Model model) {
        Optional<Transporte> Transporte = null;
        String path = "transporte/transporteAdm";
        System.out.println("get - guardarTransporte - id: " + id);
        try {
            if (!"0".equalsIgnoreCase(id)) {
                Transporte = transporteService.obtenerTransportePorId(id);
            }else{
                Transporte vo = new Transporte();
                vo.setId(UUID.randomUUID().toString());
                vo.setEstado("A");
                Transporte = Optional.of(vo);
            }
            model.addAttribute("transporte", Transporte.get());
            model.addAttribute("accion", action);
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }
    
    @Override
    @PostMapping("/transporte/{action}/{id}")
    public String guardarTransporte(@PathVariable String action, @PathVariable String id, @ModelAttribute Transporte transporte, Model model) {
        String path = "transporte/transporteAdm";
        System.out.println("post - guardarTransporte - id; " + id);
        try {
            transporteService.guardarTransporte(transporte);
            //new ResponseEntity<>(nuevoTransporte, HttpStatus.CREATED)
            path = "redirect:/transporte/upd/" + transporte.getId();
            model.addAttribute("accion", "upd");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        return path;
    }

    @Override
    @GetMapping("/transporte/eliminar/{id}")
    public String eliminarTransporte(@PathVariable("id") String id, Model model) {
        System.out.println("delete - eliminarTransporte - id; " + id);
        String path = "transporte/transporteLst";
        try {
            transporteService.eliminarTransporte(id);
            path = "redirect:/transporte";
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        return path;
    }
}
