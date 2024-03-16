package com.ingeneotest.empresa_gestion_logistica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ingeneotest.empresa_gestion_logistica.models.Cliente;
import com.ingeneotest.empresa_gestion_logistica.services.ClienteService;


@Controller
//@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente")
    //ResponseEntity<List<Cliente>>
    public String obtenerTodosClientes(Model model) {
        String path = "cliente/clienteLst";

        try {
            List<Cliente> l = clienteService.obtenerTodosClientes();
            model.addAttribute("clientes", l);
            Cliente vo = new Cliente();
            model.addAttribute("clienteNuevo", vo);
        } catch (Exception e) {
            path = "error";
        }

        return path;
    }

    @GetMapping("/cliente/{action}/{id}")
    public String obtenerClientePorId(@PathVariable String action, @PathVariable("id") String id, Model model) {
        Optional<Cliente> cliente = null;
        String path = "cliente/clienteAdm";
        System.out.println("get - guardarCliente - id; " + id);
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
        }
        
        return path;
    }
    
    @PostMapping("/cliente/{action}/{id}")
    // ResponseEntity<Cliente>
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
        }
        return path;
    }

    @DeleteMapping("/cliente/eliminar/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") String id, Model model) {
        clienteService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
