package ar.edu.unju.fi.tp6.services;

import java.util.List;

import ar.edu.unju.fi.tp6.models.Compra;

public interface ICompraService {
    public void agregarCompra(Compra compra);
    public List<Compra> getCompra();
}
