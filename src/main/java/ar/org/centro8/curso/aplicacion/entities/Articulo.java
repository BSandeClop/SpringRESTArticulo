package ar.org.centro8.curso.aplicacion.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ar.org.centro8.curso.aplicacion.enums.Rubro;

@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Rubro rubro;
    private Double costo;
    private Double precio;
    private int stock;
    private int stock_minimo;
    private int stock_maximo;

    public Articulo(String descripcion, Rubro rubro, Double costo, Double precio, int stock, int stock_minimo, int stock_maximo) {
    this.descripcion = descripcion;
    this.rubro = rubro;
    this.costo = costo;
    this.precio = precio;
    this.stock = stock;
    this.stock_minimo = stock_minimo;
    this.stock_maximo = stock_maximo;
    }


    public Articulo(){

    }

    public Articulo(int id, String descripcion, Rubro rubro, Double costo, Double precio, int stock, int stock_minimo, int stock_maximo) {
        this.id = id;
        this.descripcion = descripcion;
        this.rubro = rubro;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stock_minimo = stock_minimo;
        this.stock_maximo = stock_maximo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public int getStock_maximo() {
        return stock_maximo;
    }
    
    public void setStock_maximo(int stock_maximo) {
        this.stock_maximo = stock_maximo;
    }


    @Override
    public String toString() {
        return "Articulo [costo=" + costo + ", descripcion=" + descripcion + ", id=" + id + ", precio=" + precio
                + ", rubro=" + rubro + ", stock=" + stock + ", stock_maximo=" + stock_maximo + ", stock_minimo="
                + stock_minimo + "]";
    }

    

}
