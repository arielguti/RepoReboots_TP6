package ar.edu.unju.fi.tp6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp6.models.Cliente;
import ar.edu.unju.fi.tp6.services.IClienteService;

@Controller
public class ClienteController {
    @Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteUtilService")
	private IClienteService clienteService;

    @GetMapping("/cliente/nuevo")
	public String nuevoCliente(Model model) {
		model.addAttribute(cliente);
		return "nuevoCliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView Guardar(@ModelAttribute("cliente") Cliente cliente) {
		ModelAndView model = new ModelAndView("clientes");		
		clienteService.agregarCliente(cliente);		
		//model.addObject("clientes",clienteService.listadoCargado());
		model.addObject("clientes", clienteService.getClientes());
		return model;		
	}
	
	@GetMapping("/cliente/listado")
	public ModelAndView mostrarListado() {
		ModelAndView model = new ModelAndView("listado");
		model.addObject("clientes", clienteService.getClientes());
		return model;
	}
}
