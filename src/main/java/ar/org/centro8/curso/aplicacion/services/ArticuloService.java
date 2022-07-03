package ar.org.centro8.curso.aplicacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.org.centro8.curso.aplicacion.entities.Articulo;
import ar.org.centro8.curso.aplicacion.interfaces.ArticuloRepository;

@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }


    public List<Articulo> getAll(){
        return articuloRepository.findAll();
    }

    public Articulo byId(int id){
        return articuloRepository.findById(id).orElse(new Articulo());
    }

    public List<Articulo> getLikeDescripcion(String descripcion){
        return articuloRepository.findByDescripcionContainingIgnoreCase(descripcion);
    }

    public void saveArticulo(Articulo articulo){
        articuloRepository.save(articulo);
    }

    public void deleteById(int id){
        articuloRepository.deleteById(id);
    }
}
