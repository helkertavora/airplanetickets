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

import br.com.fa7.airplanetickets.excessoes.VooException;
import br.com.fa7.airplanetickets.modelo.entidades.Aeroporto;
import br.com.fa7.airplanetickets.modelo.entidades.EmpresaAerea;
import br.com.fa7.airplanetickets.modelo.entidades.Voo;
import br.com.fa7.airplanetickets.modelo.servicos.AeroportoService;
import br.com.fa7.airplanetickets.modelo.servicos.EmpresaAereaService;
import br.com.fa7.airplanetickets.modelo.servicos.VooService;
import br.com.fa7.airplanetickets.propertyeditors.AeroportoPropertyEditor;
import br.com.fa7.airplanetickets.propertyeditors.EmpresaAereaPropertyEditor;

@Controller
@RequestMapping("/voo")
public class VooController {
	
	@Autowired
	private VooService vooService;
	@Autowired
	private AeroportoService aeroportoService;
	@Autowired
	private EmpresaAereaService empresaAereaService;
	@Autowired
	private AeroportoPropertyEditor aeroportoPropertyEditors;
	@Autowired
	private EmpresaAereaPropertyEditor empresaAereaPropertyEditors;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarVoos(Model model){
		Iterable<Voo> voos = vooService.listar();
		
		model.addAttribute("titulo", "Listagem de Voos");
		model.addAttribute("voos", voos);
		model.addAttribute("aeroportos", aeroportoService.listar());
		model.addAttribute("empresaAereas", empresaAereaService.listar());
		
		return "voo/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarVoo(@Valid @ModelAttribute Voo voo, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			throw new VooException();
		}else{
			vooService.salvar(voo);
		}
		model.addAttribute("voos", vooService.listar());
		return "voo/tabela-voo";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarReserva(@PathVariable Integer id){
		
		try {
			vooService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Voo buscarVoo(@PathVariable Integer id){
		Voo voo = vooService.buscar(id);
		return voo;
	}
	
	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Aeroporto.class, aeroportoPropertyEditors);
		webDataBinder.registerCustomEditor(EmpresaAerea.class, empresaAereaPropertyEditors);
	}

}