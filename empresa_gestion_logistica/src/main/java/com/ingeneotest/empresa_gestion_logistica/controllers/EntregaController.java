package com.ingeneotest.empresa_gestion_logistica.controllers;

import java.time.LocalDateTime;
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
import com.ingeneotest.empresa_gestion_logistica.models.Cliente;
import com.ingeneotest.empresa_gestion_logistica.models.Entrega;
import com.ingeneotest.empresa_gestion_logistica.models.Producto;
import com.ingeneotest.empresa_gestion_logistica.models.Transporte;
import com.ingeneotest.empresa_gestion_logistica.services.AlmacenService;
import com.ingeneotest.empresa_gestion_logistica.services.ClienteService;
import com.ingeneotest.empresa_gestion_logistica.services.EntregaServiceInterface;
import com.ingeneotest.empresa_gestion_logistica.services.ProductoService;
import com.ingeneotest.empresa_gestion_logistica.services.TransporteService;


@Controller
public class EntregaController implements EntregaControllerInterface {
    private final EntregaServiceInterface entregaService;
    private ClienteService clienteService;
    private ProductoService productoService;
    private AlmacenService almacenService;
    private TransporteService transporteService;

    @Autowired
    public EntregaController(EntregaServiceInterface entregaService) {
        this.entregaService = entregaService;
    }
    
    @Autowired
    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }
    @Autowired
    public void setAlmacenService(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }
    @Autowired
    public void setTransporteService(TransporteService transporteService) {
        this.transporteService = transporteService;
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
                vo.setFecRegistro(LocalDateTime.now());
                vo.setNumeroGuia(this.generarNumeroGuia());
                entrega = Optional.of(vo);
            }
            model.addAttribute("entrega", entrega.get());

            List<Cliente> clientesActivos = clienteService.obtenerClientesPorEstados();
            model.addAttribute("clientes", clientesActivos);
            List<Producto> ProductosActivos = productoService.obtenerProductosPorEstados();
            model.addAttribute("productos", ProductosActivos);
            List<Almacen> almacenesActivos = almacenService.obtenerAlmacenesPorEstados();
            model.addAttribute("almacenes", almacenesActivos);
            List<Transporte> transportesActivos = transporteService.obtenerTransportesPorEstados(); 
            model.addAttribute("transportes", transportesActivos);

            model.addAttribute("accion", action);
            model.addAttribute("notificacion", model.getAttribute("notificacion"));
            model.addAttribute("error", model.getAttribute("error"));
        } catch (Exception e) {
            path = "error";
            System.out.println(e);
        }
        
        return path;
    }

    public String generarNumeroGuia() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replaceAll("-", "");
        String numeroGuia = uuidString.substring(0, 10).toUpperCase();
        return numeroGuia;
    }

    @Override
    @PostMapping("/entrega/{action}/{id}")
    public String guardarEntrega(@PathVariable("action") String action, @PathVariable String id, @ModelAttribute Entrega entrega, Model model, RedirectAttributes redirectAttributes) {
        String path = "entrega/entregaAdm";
        String msg = "";
        System.out.println("post - guardarEntrega - id; " + id);
        try {
            path = "redirect:/entrega/upd/" + entrega.getId();
            entregaService.guardarEntrega(entrega);
            //new ResponseEntity<>(nuevoEntrega, HttpStatus.CREATED)
            msg = "Entrega " + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado") + System.lineSeparator();

            if ("add".equalsIgnoreCase(action)) {
                Producto v_pro = entrega.getProducto();
                v_pro.setCantidad(entrega.getProducto().getCantidad() - entrega.getCantidad());
                productoService.guardarProducto(v_pro);
                msg += "Cantidad del producto " + v_pro.getId() + "actualizado";
            }
            
            model.addAttribute("accion", "upd");
            redirectAttributes.addFlashAttribute("notificacion", msg);
        } catch (Exception e) {
            path = "redirect:/entrega/add/0";
            System.out.println(e);
            System.out.println(e.getMessage());
            msg = "Error "  + (("add".equalsIgnoreCase(action))?"adicionado":"actualizado") + " Entrega";
            redirectAttributes.addFlashAttribute("error", msg);
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
