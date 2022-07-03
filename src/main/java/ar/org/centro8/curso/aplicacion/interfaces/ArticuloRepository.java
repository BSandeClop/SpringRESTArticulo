package ar.org.centro8.curso.aplicacion.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.centro8.curso.aplicacion.entities.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
    List<Articulo> findByDescripcionContainingIgnoreCase(String descripcion);
}
