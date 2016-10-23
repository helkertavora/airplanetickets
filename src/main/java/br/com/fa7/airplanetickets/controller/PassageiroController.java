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

import br.com.fa7.airplanetickets.excessoes.PassageiroException;
import br.com.fa7.airplanetickets.modelo.entidades.Passageiro;
import br.com.fa7.airplanetickets.modelo.enumeracoes.RelactionamentoContatoEmergencia;
import br.com.fa7.airplanetickets.modelo.enumeracoes.TipoDocumento;
import br.com.fa7.airplanetickets.modelo.servicos.PassageiroService;

@Controller
@RequestMapping("/passageiro")
public class PassageiroController {
	
	@Autowired
	private PassageiroService passageiroService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPassageiro(Model model){
		Iterable<Passageiro> passageiro = passageiroService.listar();
		
		model.addAttribute("titulo", "Listagem de Passageiros");
		model.addAttribute("passageiros", passageiro);
		model.addAttribute("tipoDocumentos", TipoDocumento.values());
		model.addAttribute("relactionamentoContatoEmergencias", RelactionamentoContatoEmergencia.values());
		
		return "passageiro/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarPassageiro(@Valid @ModelAttribute Passageiro passageiro, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new PassageiroException();
		}else{
			passageiroService.salvar(passageiro);
		}
		model.addAttribute("passageiros", passageiroService.listar());
		return "passageiro/tabela-passageiro";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarPassageiro(@PathVariable Integer id){	
		try {
			passageiroService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Passageiro buscarPassageiro(@PathVariable Integer id){
		Passageiro passageiro = passageiroService.buscar(id);
		return passageiro;
	}

	
}
