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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ingeneotest.empresa_gestion_logistica.models.Almacen;
import com.ingeneotest.empresa_gestion_logistica.services.AlmacenServiceInterface;


@Controller
public class AlmacenController implements AlmacenControllerInterface{
    private final AlmacenServiceInterface almacenService;

    @Autowired
    public AlmacenController(AlmacenServiceInterface almacenService) {
        this.almacenService = almacenService;
    }

    @Override
    @GetMapping("/almacen")
    public String obtenerTodosAlmacenes(Model model) {
        String path = "almacen/almacenLst";
        System.out.println("get - obtenerTodosAlmacenes ");

        try {
            List<Almacen> l = almacenService.obtenerTodosAlmacenes();
            model.addAttribute("almacenes", l);
            Almacen vo = new Almacen();
            model.addAttribute("almacenNuevo", vo);
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/almacen/{action}/{id}")
    public String obtenerAlmacenPorId(@PathVariable("action") String action, @PathVariable("id") String id, Model model) {
        Optional<Almacen> almacen = null;
        String path = "almacen/almacenAdm";
        System.out.println("get - obtenerAlmacenPorId - id: " + id);
        try {
            if (!"0".equalsIgnoreCase(id)) {
                almacen = almacenService.obtenerAlmacenPorId(id);
            }else{
                Almacen vo = new Almacen();
                vo.setId(UUID.randomUUID().toString());
                vo.setEstado("A");
                almacen = Optional.of(vo);
                model.addAttribute("notificacion", model.getAttribute("notificacion"));
                model.addAttribute("error", model.getAttribute("error"));
            }
            model.addAttribute("almacen", almacen.get());
            model.addAttribute("accion", action);
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }
    
    @Override
    @PostMapping("/almacen/{action}/{id}")
    public String guardarAlmacen(@PathVariable("action") String action, @PathVariable String id, @ModelAttribute Almacen Almacen, Model model, RedirectAttributes redirectAttributes) {
        String path = "Almacen/almacenAdm";
        System.out.println("post - guardarAlmacen - id; " + id);
        try {
            path = "redirect:/almacen/upd/" + Almacen.getId();
            almacenService.guardarAlmacen(Almacen);
            //new ResponseEntity<>(nuevoAlmacen, HttpStatus.CREATED)
            model.addAttribute("accion", "upd");
            redirectAttributes.addFlashAttribute("notificacion", "Almacen " + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error "  + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado") + " almacen");
        }
        return path;
    }

    @Override
    @GetMapping("/almacen/eliminar/{id}")
    public String eliminarAlmacen(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("delete - eliminarAlmacen - id; " + id);
        String path = "almacen/almacenLst";
        try {
            path = "redirect:/almacen";
            almacenService.eliminarAlmacen(id);
            redirectAttributes.addFlashAttribute("notificacion", "Almacen eliminado");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error eliminado almacen");
        }
        return path;
    }
}
