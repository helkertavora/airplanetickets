package br.com.fa7.airplanetickets.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fa7.airplanetickets.excessoes.ReservaException;
import br.com.fa7.airplanetickets.modelo.entidades.Cliente;
import br.com.fa7.airplanetickets.modelo.entidades.Reserva;
import br.com.fa7.airplanetickets.modelo.entidades.Voo;
import br.com.fa7.airplanetickets.modelo.servicos.ClienteService;
import br.com.fa7.airplanetickets.modelo.servicos.ReservaService;
import br.com.fa7.airplanetickets.modelo.servicos.VooService;
import br.com.fa7.airplanetickets.propertyeditors.ClientePropertyEditor;
import br.com.fa7.airplanetickets.propertyeditors.VooPropertyEditor;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private VooService vooService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private VooPropertyEditor vooPropertyEditors;
	@Autowired
	private ClientePropertyEditor clientePropertyEditors;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarReservas(Model model){
		Iterable<Reserva> reservas = reservaService.listar();
		
		model.addAttribute("titulo", "Listagem de Reservas");
		model.addAttribute("reservas", reservas);
		model.addAttribute("clientes", clienteService.listar());
		model.addAttribute("voos", vooService.listar());
		
		return "reserva/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new ReservaException();
		}else{
			reservaService.salvar(reserva);
		}
		model.addAttribute("reservas", reservaService.listar());
		return "reserva/tabela-reserva";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarReserva(@PathVariable Integer id){
		
		try {
			reservaService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Reserva buscarReserva(@PathVariable Integer id){
		Reserva reserva = reservaService.buscar(id);
		return reserva;
	}
	
	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Voo.class, vooPropertyEditors);
		webDataBinder.registerCustomEditor(Cliente.class, clientePropertyEditors);
	}


}