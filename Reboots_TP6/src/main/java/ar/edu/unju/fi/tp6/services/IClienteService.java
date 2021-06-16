package ar.edu.unju.fi.tp6.services;

import java.util.List;

import ar.edu.unju.fi.tp6.models.Cliente;

public interface IClienteService {
    public void agregarCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public List<Cliente> listadoCargado();
}
