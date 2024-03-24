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

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;
import com.ingeneotest.empresa_gestion_logistica.models.Entrega;
import com.ingeneotest.empresa_gestion_logistica.services.ClienteService;
import com.ingeneotest.empresa_gestion_logistica.services.EntregaServiceInterface;


@Controller
public class EntregaController implements EntregaControllerInterface {
    private final EntregaServiceInterface entregaService;
    private ClienteService clienteService;

    @Autowired
    public EntregaController(EntregaServiceInterface entregaService) {
        this.entregaService = entregaService;
    }
    
    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    @GetMapping("/entrega")
    public String obtenerTodosEntregas(Model model) {
        String path = "Entrega/EntregaLst";

        try {
            List<Entrega> l = entregaService.obtenerTodosEntregas();
            model.addAttribute("entregas", l);
            Entrega vo = new Entrega();
            model.addAttribute("entregaNuevo", vo);
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/entrega/{action}/{id}")
    public String obtenerEntregaPorId(@PathVariable("action") String action, @PathVariable("id") String id, Model model) {
        Optional<Entrega> entrega = null;
        String path = "entrega/entregaAdm";
        System.out.println("get - obtenerEntregaPorId - id: " + id);
        try {
            if (!"0".equalsIgnoreCase(id)) {
                entrega = entregaService.obtenerEntregaPorId(id);
            }else{
                Entrega vo = new Entrega();
                vo.setId(UUID.randomUUID().toString());
                vo.setEstado("A");
                entrega = Optional.of(vo);
            }
            model.addAttribute("entrega", entrega.get());

            List<Cliente> clientesActivos = clienteService.obtenerClientesPorEstados(); // Obtener clientes por estados
            model.addAttribute("clientes", clientesActivos);

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
    @PostMapping("/entrega/{action}/{id}")
    public String guardarEntrega(@PathVariable("action") String action, @PathVariable String id, @ModelAttribute Entrega entrega, Model model, RedirectAttributes redirectAttributes) {
        String path = "entrega/entregaAdm";
        System.out.println("post - guardarEntrega - id; " + id);
        try {
            path = "redirect:/entrega/upd/" + entrega.getId();
            entregaService.guardarEntrega(entrega);
            //new ResponseEntity<>(nuevoEntrega, HttpStatus.CREATED)
            model.addAttribute("accion", "upd");
            redirectAttributes.addFlashAttribute("notificacion", "Entrega " + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error "  + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado") + " Entrega");
        }
        return path;
    }

    @Override
    @GetMapping("/entrega/eliminar/{id}")
    public String eliminarEntrega(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("delete - eliminarEntrega - id; " + id);
        String path = "entrega/entregaLst";
        try {
            path = "redirect:/entrega";
            entregaService.eliminarEntrega(id);
            redirectAttributes.addFlashAttribute("notificacion", "Entrega eliminada");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error eliminado Entrega");
        }
        return path;
    }
}
