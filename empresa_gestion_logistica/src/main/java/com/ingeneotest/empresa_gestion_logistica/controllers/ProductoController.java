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
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/producto/{action}/{id}")
    public String obtenerProductoPorId(@PathVariable String action, @PathVariable("id") String id, Model model) {
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
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }
    
    @Override
    @PostMapping("/producto/{action}/{id}")
    public String guardarProducto(@PathVariable String action, @PathVariable String id, @ModelAttribute Producto producto, Model model) {
        String path = "producto/productoAdm";
        System.out.println("post - guardarProducto - id; " + id);
        try {
            productoService.guardarProducto(producto);
            //new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED)
            path = "redirect:/producto/upd/" + producto.getId();
            model.addAttribute("accion", "upd");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        return path;
    }

    @Override
    @GetMapping("/producto/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") String id, Model model) {
        System.out.println("delete - eliminarProducto - id; " + id);
        String path = "producto/productoLst";
        try {
            productoService.eliminarProducto(id);
            path = "redirect:/producto";
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        return path;
    }
}
