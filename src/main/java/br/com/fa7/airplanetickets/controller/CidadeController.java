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

import br.com.fa7.airplanetickets.excessoes.CidadeException;
import br.com.fa7.airplanetickets.modelo.entidades.Cidade;
import br.com.fa7.airplanetickets.modelo.enumeracoes.Estado;
import br.com.fa7.airplanetickets.modelo.servicos.CidadeService;

@Controller
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarReservas(Model model){
		Iterable<Cidade> cidade = cidadeService.listar();
		
		model.addAttribute("titulo", "Listagem de Cidades");
		model.addAttribute("cidades", cidade);
		model.addAttribute("estados", Estado.values());
		
		return "cidade/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarCidade(@Valid @ModelAttribute Cidade cidade, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new CidadeException();
		}else{
			cidadeService.salvar(cidade);
		}
		model.addAttribute("cidades", cidadeService.listar());
		return "cidade/tabela-cidade";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarCidade(@PathVariable Integer id){	
		try {
			cidadeService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Cidade buscarCidade(@PathVariable Integer id){
		Cidade cidade = cidadeService.buscar(id);
		return cidade;
	}

	
}
