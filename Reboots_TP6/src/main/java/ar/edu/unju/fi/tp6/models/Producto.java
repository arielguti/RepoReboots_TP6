package ar.edu.unju.fi.tp6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PRODUCTOS")
@Component
public class Producto {
	
	@Id
	@Column(name="PRO_cod")
    private int codigo;
	
	@Column(name="PRO_nombre")
    private String nombre;
    
	@Column(name="PRO_precio")
	private double precio;
    
	@Column(name="PRO_marca")
	private String marca;
    
	@Column(name="PRO_stock")
	private int stock;


    public Producto() {
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", precio='" + getPrecio() + "'" +
            ", marca='" + getMarca() + "'" +
            ", stock='" + getStock() + "'" +
            "}";
    }
    
}
