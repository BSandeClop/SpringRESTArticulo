package ar.org.centro8.curso.aplicacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.org.centro8.curso.aplicacion.entities.Articulo;
import ar.org.centro8.curso.aplicacion.enums.Rubro;
import ar.org.centro8.curso.aplicacion.services.ArticuloService;

@RestController
public class ArticuloController {
    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping(path = "/servicios/articulos/v1/all")
    protected List<Articulo> getAll(){
        return articuloService.getAll();
    }

    @GetMapping(path = "/servicios/articulos/v1/byId")
    protected Articulo getById(@RequestParam int id){
        return articuloService.byId(id);
    }

    @GetMapping(path = "/servicios/articulos/v1/likeDescripcion")
    protected List<Articulo> getLikeDescripcion(@RequestParam String descripcion){
        return articuloService.getLikeDescripcion(descripcion);
    }

    @PostMapping("/servicios/articulos/v1/alta")
    public ResponseEntity<Articulo> guardarPersonaje(
        @RequestParam String descripcion, 
        @RequestParam String rubro, 
        @RequestParam Double costo, 
        @RequestParam Double precio, 
        @RequestParam int stock, 
        @RequestParam int stock_minimo, 
        @RequestParam int stock_maximo
    ){
        try {
            Articulo articulo = new Articulo(descripcion, Rubro.valueOf(rubro), costo, precio, stock, stock_minimo, stock_maximo);
            articuloService.saveArticulo(articulo);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/servicios/articulos/v1/baja")
    public ResponseEntity<Articulo> borrarPersonaje(@RequestParam int id){
        try {
            articuloService.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
