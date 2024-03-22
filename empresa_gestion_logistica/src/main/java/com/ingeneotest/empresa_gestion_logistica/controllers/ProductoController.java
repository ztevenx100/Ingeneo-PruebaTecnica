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

import com.ingeneotest.empresa_gestion_logistica.models.Producto;
import com.ingeneotest.empresa_gestion_logistica.services.ProductoServiceInterface;


@Controller
public class ProductoController implements ProductoControllerInterface{
    private final ProductoServiceInterface productoService;

    @Autowired
    public ProductoController(ProductoServiceInterface productoService) {
        this.productoService = productoService;
    }

    @Override
    @GetMapping("/producto")
    public String obtenerTodosProductos(Model model) {
        String path = "producto/productoLst";

        try {
            List<Producto> l = productoService.obtenerTodosProductos();
            model.addAttribute("productos", l);
            Producto vo = new Producto();
            model.addAttribute("productoNuevo", vo);
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/producto/{action}/{id}")
    public String obtenerProductoPorId(@PathVariable("action") String action, @PathVariable("id") String id, Model model) {
        Optional<Producto> producto = null;
        String path = "producto/productoAdm";
        System.out.println("get - guardarProducto - id: " + id);
        try {
            if (!"0".equalsIgnoreCase(id)) {
                producto = productoService.obtenerProductoPorId(id);
            }else{
                Producto vo = new Producto();
                vo.setId(UUID.randomUUID().toString());
                vo.setEstado("A");
                producto = Optional.of(vo);
            }
            model.addAttribute("producto", producto.get());
            model.addAttribute("accion", action);
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }
    
    @Override
    @PostMapping("/producto/{action}/{id}")
    public String guardarProducto(@PathVariable("action") String action, @PathVariable String id, @ModelAttribute Producto producto, Model model, RedirectAttributes redirectAttributes) {
        String path = "producto/productoAdm";
        System.out.println("post - guardarProducto - id; " + id);
        try {
            path = "redirect:/producto/upd/" + producto.getId();
            productoService.guardarProducto(producto);
            //new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED)
            model.addAttribute("accion", "upd");
            redirectAttributes.addFlashAttribute("notificacion", "Producto " + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error "  + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado") + " producto");
        }
        return path;
    }

    @Override
    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("delete - eliminarProducto - id; " + id);
        String path = "producto/productoLst";
        try {
            path = "redirect:/producto";
            productoService.eliminarProducto(id);
            redirectAttributes.addFlashAttribute("notificacion", "Producto eliminado");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error eliminado producto");
        }
        return path;
    }
}
