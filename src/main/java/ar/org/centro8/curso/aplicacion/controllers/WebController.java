package ar.org.centro8.curso.aplicacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.aplicacion.entities.Articulo;
import ar.org.centro8.curso.aplicacion.enums.Rubro;
import ar.org.centro8.curso.aplicacion.services.ArticuloService;

@Controller
public class WebController {
    private final ArticuloService articuloService;
    private String mensaje = "Ingrese un nuevo articulo";
    
    @Autowired
    public WebController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/articulos")
    public String articulosPage(@RequestParam(name="buscarDescripcion", required = false, defaultValue = "")String buscarDescripcion, Model model){
        model.addAttribute("rubros", List.of(Rubro.values()));
        model.addAttribute("articulo", new Articulo());
        model.addAttribute("all", articuloService.getAll());
        model.addAttribute("likeDescripcion", articuloService.getLikeDescripcion(buscarDescripcion));
        model.addAttribute("mensaje", mensaje);
        return "articulos";
    }

    @PostMapping("/saveArticulo")
    public String saveArticulo(@ModelAttribute Articulo articulo){
        try {
            articuloService.saveArticulo(articulo);
            mensaje="Se dio de alta el articulo con el ID: " + articulo.getId();
        } catch (Exception e) {
            mensaje="Ocurrio un error!";
        }
        return "redirect:articulos";
    }
}
