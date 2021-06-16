package ar.edu.unju.fi.tp6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.models.Producto;
import ar.edu.unju.fi.tp6.services.IProductoService;

@Controller
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private Producto producto;
    
    @GetMapping("/producto")
    public String getProducto(Model model){
        model.addAttribute(producto);
        return "nuevo";

    }


    /**
     * Método que permite agregar un producto a la lista 
     * @param producto es un objeto tipo Producto
     * @return String que es el nombre de la vista
     */
    @PostMapping("/producto/guardar")
    public String agregarProducto(@ModelAttribute("producto") Producto producto){
        productoService.agregarProducto(producto);
        return "resultado";
    }

    /**
     * Método que obtiene el ultimo producto de la lista y lo manda a la vista 
     * @param model que es el objeto que se enviara a la vista
     * @return String que es el nombre de la vista 
     */
    @GetMapping("/producto/ultimo")
    public ModelAndView mostrarUltimoProducto(){
        Producto producto = productoService.obtenerUltimoProducto();
        ModelAndView model = new ModelAndView("ultimoProducto");
        model.addObject("ultimoProducto", producto);

        return model;


    }


}
