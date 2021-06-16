package ar.edu.unju.fi.tp6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="COMPRAS")
@Component
public class Compra {
	
	@Id
	@Column(name="COM_id")
	private int id;

	@Autowired
	@ManyToOne
	@JoinColumn(name="PRO_cod")
	private Producto producto;
	
	@Column(name="COM_cantidad")
	private int cantidad;
	
	@Column(name="COM_total")
	private double total;
	
	public Compra() {
		
	}	
	

	public Compra(int id, Producto producto, int cantidad, double total) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		this.total = this.producto.getPrecio()*this.cantidad;
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}



	@Override
	public String toString() {
		return "Compra [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", total=" + total + "]";
	}
	
}
