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

import br.com.fa7.airplanetickets.excessoes.PassagemException;
import br.com.fa7.airplanetickets.modelo.entidades.Passageiro;
import br.com.fa7.airplanetickets.modelo.entidades.Passagem;
import br.com.fa7.airplanetickets.modelo.entidades.Reserva;
import br.com.fa7.airplanetickets.modelo.servicos.PassageiroService;
import br.com.fa7.airplanetickets.modelo.servicos.PassagemService;
import br.com.fa7.airplanetickets.modelo.servicos.ReservaService;
import br.com.fa7.airplanetickets.propertyeditors.PassageiroPropertyEditor;
import br.com.fa7.airplanetickets.propertyeditors.ReservaPropertyEditor;

@Controller
@RequestMapping("/passagem")
public class PassagemController {
	
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private PassageiroService passageiroService;
	@Autowired
	private PassagemService passagemService;
	@Autowired
	private PassageiroPropertyEditor passageiroPropertyEditors;
	@Autowired
	private ReservaPropertyEditor reservaPropertyEditors;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPassagem(Model model){
		Iterable<Passagem> passagem = passagemService.listar();
		
		model.addAttribute("titulo", "Listagem de Passagem");
		model.addAttribute("passagens", passagem);
		model.addAttribute("passageiros", passageiroService.listar());
		model.addAttribute("reservas", reservaService.listar());
		
		return "passagem/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarPassagem(@Valid @ModelAttribute Passagem passagem, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new PassagemException();
		}else{
			passagemService.salvar(passagem);
		}
		model.addAttribute("passagens", passagemService.listar());
		return "passagem/tabela-passagem";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarPassagem(@PathVariable Integer id){
		
		try {
			passagemService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Passagem buscarPassagem(@PathVariable Integer id){
		Passagem passagem = passagemService.buscar(id);
		return passagem;
	}
	
	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Passageiro.class, passageiroPropertyEditors);
		webDataBinder.registerCustomEditor(Reserva.class, reservaPropertyEditors);
	}


}