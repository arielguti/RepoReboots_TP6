package ar.edu.unju.fi.tp6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.models.Compra;
import ar.edu.unju.fi.tp6.services.ICompraService;
import ar.edu.unju.fi.tp6.services.IProductoService;

@Controller
public class CompraController {

	@Autowired
	private Compra compra;
	
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	
	@Autowired
	private IProductoService productoService;

//    @GetMapping("/compra/nuevo")
//	public String nuevoCompra(Model model) {
//		model.addAttribute(compra);
//		return "compraForm";
//	}
	
    @GetMapping("/compra/nuevo")
	public String getSucursalFormPage(Model model) {		
		model.addAttribute("compra", this.compra);		
		model.addAttribute("productos", productoService.getAllProductos());
		return "compraForm";
	}
    
//	@PostMapping("/compra/guardar")
//	public ModelAndView Guardar(@ModelAttribute("compra") Compra compra) {
//		ModelAndView model = new ModelAndView("compras");		
//		compraService.agregarCompra(compra);		
//		//model.addObject("compras",compraService.listadoCargado());
//		model.addObject("compra", compraService.getCompra());
//		return model;		
//	}
	
	@GetMapping("/compra/guardar")
	public String getEmpleadoResultPage(Model model, 
			@RequestParam(name="id") String id,
			@RequestParam(name="cantidad") String cantidad,
			@RequestParam(name="total") String total,
			@RequestParam(name="codigoProd") String codigoP) {
		
		Compra comp = new Compra();
		comp.setId(Integer.valueOf(id));
		comp.setCantidad(Integer.valueOf(cantidad));
		comp.setTotal(Double.valueOf(total));
		comp.setProducto(this.productoService.getUnProducto(Integer.valueOf(codigoP)));
		
		compraService.agregarCompra(comp);
		
		model.addAttribute("compra", compraService.getCompra());
		return "compras";
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView mostrarListado() {
		ModelAndView model = new ModelAndView("listaCompras");
		model.addObject("compra", compraService.getCompra());
		return model;
	}
		
}
