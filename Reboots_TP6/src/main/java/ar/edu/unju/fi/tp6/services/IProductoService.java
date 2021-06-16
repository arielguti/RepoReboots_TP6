package ar.edu.unju.fi.tp6.services;

import java.util.List;

import ar.edu.unju.fi.tp6.models.Producto;

public interface IProductoService {
    public void agregarProducto(Producto producto);
    public Producto obtenerUltimoProducto();
    public Producto getUnProducto(int codigo);
    public List<Producto> getAllProductos();
}
