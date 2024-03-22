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

import com.ingeneotest.empresa_gestion_logistica.factory.TransporteFactory;
import com.ingeneotest.empresa_gestion_logistica.factory.TransporteMaritimoFactory;
import com.ingeneotest.empresa_gestion_logistica.factory.TransporteTerrestreFactory;
import com.ingeneotest.empresa_gestion_logistica.models.Transporte;
import com.ingeneotest.empresa_gestion_logistica.models.TransporteInterface;
import com.ingeneotest.empresa_gestion_logistica.models.TransporteMaritimo;
import com.ingeneotest.empresa_gestion_logistica.models.TransporteTerrestre;
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
        System.out.println("get - obtenerTodosTransportes ");

        try {
            List<Transporte> l = transporteService.obtenerTodosTransportes();
            model.addAttribute("transportes", l);
            TransporteInterface vo = new Transporte();
            model.addAttribute("transporteNuevo", vo);
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }

        return path;
    }

    @Override
    @GetMapping("/transporte/{action}/{id}")
    public String obtenerTransportePorId(@PathVariable("action") String action, @PathVariable("id") String id, Model model) {
        Optional<Transporte> Transporte = null;
        String path = "transporte/transporteAdm";
        System.out.println("get - obtenerTransportePorId - id: " + id);
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
            //System.out.println("notificacion " + model.getAttribute("notificacion"));
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }
    
    @Override
    @PostMapping("/transporte/{action}/{id}")
    public String guardarTransporte(@PathVariable("action") String action, @PathVariable("id") String id, @ModelAttribute Transporte transporte, Model model, RedirectAttributes redirectAttributes) {
        String path = "transporte/transporteAdm";
        TransporteFactory factory = null;
        System.out.println("post - guardarTransporte - id: " + id + " - action: " + action);
        try {
            path = "redirect:/transporte/upd/" + transporte.getId();

            if(TransporteServiceInterface.TIPO_MARITIMO.equalsIgnoreCase(transporte.getTipo()) ) {
                factory = new TransporteMaritimoFactory();
                TransporteMaritimo transporteMaritimo = (TransporteMaritimo) factory.crearTransporte(transporte);
                if (!transporteMaritimo.validarFormatoMatricula()){
                    System.err.println("El formato debe corresponder a 3 letras iniciales, seguidas de 4 números y finalizando con una letra");
                    return path;
                }
            } else if (TransporteServiceInterface.TIPO_TERRESTRE.equalsIgnoreCase(transporte.getTipo()) ){
                factory = new TransporteTerrestreFactory();
                TransporteTerrestre transporteTerrestre = (TransporteTerrestre) factory.crearTransporte(transporte);
                if (!transporteTerrestre.validarFormatoMatricula()){
                    System.err.println("El formato debe corresponder a 3 letras iniciales y 3 números finales");
                    return path;
                }
            }

            transporteService.guardarTransporte(transporte);
            //new ResponseEntity<>(nuevoTransporte, HttpStatus.CREATED)
            model.addAttribute("accion", "upd");
            redirectAttributes.addFlashAttribute("notificacion", "Transporte " + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error "  + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado") + " transporte");
        }
        return path;
    }

    @Override
    @GetMapping("/transporte/eliminar/{id}")
    public String eliminarTransporte(@PathVariable("id") String id, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("delete - eliminarTransporte - id; " + id);
        String path = "transporte/transporteLst";
        try {
            path = "redirect:/transporte";
            transporteService.eliminarTransporte(id);
            redirectAttributes.addFlashAttribute("notificacion", "Transporte eliminado");
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
            redirectAttributes.addFlashAttribute("error", "Error eliminado transporte");
        }
        return path;
    }
}
