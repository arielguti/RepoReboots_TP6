package ar.edu.unju.fi.tp6.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp6.models.Producto;
import ar.edu.unju.fi.tp6.services.IProductoService;

/**
 * clase que implementa la interface IProductoService
 */
@Service
public class ProductoServiceImp implements IProductoService {

    private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);

    private List<Producto> listaProducto = new ArrayList<Producto>();

    //@Override
    public void agregarProducto(Producto producto) {
        listaProducto.add(producto);
        LOGGER.info("METHOD: agregarProducto(producto) - se agregó un producto al listado -->"
                + listaProducto.get(listaProducto.size() - 1));
        
    }

    //@Override
    public Producto obtenerUltimoProducto() {
        Producto producto = listaProducto.get(listaProducto.size() - 1);
        LOGGER.info(
                "METHOD: obtenerUltimoProducto() - se obtiene el ultimo producto agregado a la lista -->" + producto);
        return producto;
    }

	public Producto getUnProducto(int codigo) {
		Producto p = new Producto();
		for(Producto producto : this.listaProducto) {
			if(producto.getCodigo() == codigo) {
				p = producto;
			}
		}
		return p;
	}

	public List<Producto> getAllProductos() {		
		return this.listaProducto;
	}
    
}
