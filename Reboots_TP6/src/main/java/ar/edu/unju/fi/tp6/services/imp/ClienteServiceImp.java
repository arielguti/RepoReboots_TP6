package ar.edu.unju.fi.tp6.services.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.models.Cliente;
import ar.edu.unju.fi.tp6.services.IClienteService;
import ar.edu.unju.fi.tp6.utils.TableClientes;

@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService {

    private List<Cliente> clientes;
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);

    //@Override
    public void agregarCliente(Cliente cliente) {
        clientes = TableClientes.registros;		
		clientes.add(cliente);
		LOGGER.info("METHOD: agregarCliente(cliente) - se agregó un cliente al listado -->"
                + clientes.get(clientes.size()-1));
        
    }

    //@Override
    public List<Cliente> getClientes() {
        String cantidad = "";
		if(this.clientes == null) {
			cantidad = "Null";
		}else {
			cantidad = String.valueOf(clientes.size());
		}		
		LOGGER.info("METHOD: getcliente() - muestra el listado de clientes -->"
                + cantidad + " clientes");
		return clientes;
    }

    //@Override
    public List<Cliente> listadoCargado() {
        Cliente cliente = new Cliente("Dni", 29496334, "Farfan Sebastian", "sebas@gmail.com", "12345", LocalDate.of(1982, 12, 26), 388, 156827105, LocalDate.now());
		clientes = TableClientes.registros;
		clientes.add(cliente);
		return clientes;
    }
    
}
