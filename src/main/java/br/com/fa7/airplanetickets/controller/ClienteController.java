package br.com.fa7.airplanetickets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fa7.airplanetickets.excessoes.ClienteException;
import br.com.fa7.airplanetickets.modelo.entidades.Cliente;
import br.com.fa7.airplanetickets.modelo.servicos.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarCliente(Model model){
		Iterable<Cliente> clientes = clienteService.listar();
		
		model.addAttribute("titulo", "Listagem de Reservas");
		model.addAttribute("clientes", clientes);
		
		return "cliente/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new ClienteException();
		}else{
			clienteService.salvar(cliente);
		}
		model.addAttribute("clientes", clienteService.listar());
		return "cliente/tabela-cliente";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarCliente(@PathVariable Integer id){
		
		try {
			clienteService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Cliente buscarCliente(@PathVariable Integer id){
		Cliente cliente = clienteService.buscar(id);
		return cliente;
	}

	
}
