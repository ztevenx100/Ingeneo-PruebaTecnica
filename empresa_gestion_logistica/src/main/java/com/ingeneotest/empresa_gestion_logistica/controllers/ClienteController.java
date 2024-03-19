package com.ingeneotest.empresa_gestion_logistica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;
import com.ingeneotest.empresa_gestion_logistica.services.ClienteServiceInterface;


@Controller
public class ClienteController implements ClienteControllerInterface {
    private final ClienteServiceInterface clienteService;

    @Autowired
    public ClienteController(ClienteServiceInterface clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    @GetMapping("/cliente")
    public String obtenerTodosClientes(Model model) {
        String path = "cliente/clienteLst";

        try {
            List<Cliente> l = clienteService.obtenerTodosClientes();
            model.addAttribute("clientes", l);
            Cliente vo = new Cliente();
            model.addAttribute("clienteNuevo", vo);
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/cliente/{action}/{id}")
    public String obtenerClientePorId(@PathVariable String action, @PathVariable("id") String id, Model model) {
        Optional<Cliente> cliente = null;
        String path = "cliente/clienteAdm";
        System.out.println("get - guardarCliente - id: " + id);
        try {
            if (!"0".equalsIgnoreCase(id)) {
                cliente = clienteService.obtenerClientePorId(id);
            }else{
                cliente = Optional.of(new Cliente());
            }
            model.addAttribute("cliente", cliente.get());
            model.addAttribute("accion", action);
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }
    
    @Override
    @PostMapping("/cliente/{action}/{id}")
    public String guardarCliente(@PathVariable String action, @PathVariable String id, @ModelAttribute Cliente cliente, Model model) {
        String path = "cliente/clienteAdm";
        System.out.println("post - guardarCliente - id; " + id);
        try {
            clienteService.guardarCliente(cliente);
            //new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED)
            path = "redirect:/cliente/upd/" + cliente.getId();
            model.addAttribute("accion", "upd");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        return path;
    }

    @Override
    @GetMapping("/cliente/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") String id, Model model) {
        System.out.println("delete - eliminarCliente - id; " + id);
        String path = "cliente/clienteLst";
        try {
            clienteService.eliminarCliente(id);
            path = "redirect:/cliente";
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        return path;
    }
}
