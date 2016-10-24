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

import br.com.fa7.airplanetickets.excessoes.EmpresaAereaException;
import br.com.fa7.airplanetickets.modelo.entidades.EmpresaAerea;
import br.com.fa7.airplanetickets.modelo.entidades.Voo;
import br.com.fa7.airplanetickets.modelo.servicos.EmpresaAereaService;
import br.com.fa7.airplanetickets.propertyeditors.VooPropertyEditor;

@Controller
@RequestMapping("/empresaAerea")
public class EmpresaAereaController {
	
	@Autowired
	private EmpresaAereaService empresaAereaService;
	@Autowired
	private VooPropertyEditor vooPropertyEditor;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarEmpresaAerea(Model model){
		Iterable<EmpresaAerea> empresaAerea = empresaAereaService.listar();
		
		model.addAttribute("titulo", "Listagem de Empresas Aeras");
		model.addAttribute("empresaAereas", empresaAerea);
		
		return "empresaAerea/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarEmpresaAereas(@Valid @ModelAttribute EmpresaAerea empresaAereas, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new EmpresaAereaException();
		}else{
			empresaAereaService.salvar(empresaAereas);
		}
		model.addAttribute("empresaAereas", empresaAereaService.listar());
		return "empresaAerea/tabela-empresaAerea";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarEmpresaAerea(@PathVariable Integer id){	
		try {
			empresaAereaService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public EmpresaAerea buscarEmpresaAerea(@PathVariable Integer id){
		EmpresaAerea empresaAerea = empresaAereaService.buscar(id);
		return empresaAerea;
	}
	
	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Voo.class, vooPropertyEditor);
		
	}
	
}
