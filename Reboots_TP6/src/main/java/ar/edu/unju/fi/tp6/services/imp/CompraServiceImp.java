package ar.edu.unju.fi.tp6.services.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.models.Compra;
import ar.edu.unju.fi.tp6.services.ICompraService;
@Service("compraUtilService")
public class CompraServiceImp implements ICompraService {

    private List<Compra> compras;
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);

    //@Override
    public void agregarCompra(Compra compra) {
        compras.add(compra);
		LOGGER.info("METHOD: agregarCompra(compra) - se agregó una compra al listado -->"
                + compras.get(compras.size()-1));        
    }

    //@Override
    public List<Compra> getCompra() {
        String cantidad = "";
		if(this.compras == null) {
			cantidad = "Null";
		}
		else{
			cantidad = String.valueOf(compras.size());
		}		
		LOGGER.info("METHOD: getCompra() - muestra el listado de compras -->"
                + cantidad + " clientes");
		return this.compras;        
    }

    
}
