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

import br.com.fa7.airplanetickets.excessoes.AeroportoException;
import br.com.fa7.airplanetickets.modelo.entidades.Aeroporto;
import br.com.fa7.airplanetickets.modelo.entidades.Cidade;
import br.com.fa7.airplanetickets.modelo.servicos.AeroportoService;
import br.com.fa7.airplanetickets.modelo.servicos.CidadeService;
import br.com.fa7.airplanetickets.propertyeditors.CidadePropertyEditor;

@Controller
@RequestMapping("/aeroporto")
public class AeroportoController {

	@Autowired
	private AeroportoService aeroportoService;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private CidadePropertyEditor cidadePropertyEditor;

	@RequestMapping(method = RequestMethod.GET)
	public String listarAeroporto(Model model) {
		Iterable<Aeroporto> aeroportos = aeroportoService.listar();

		model.addAttribute("titulo", "Listagem de Aeroportos");
		model.addAttribute("aeroportos", aeroportos);
		model.addAttribute("cidades", cidadeService.listar());

		return "aeroporto/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarAeroporto(@Valid @ModelAttribute Aeroporto aeroporto, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			throw new AeroportoException();
		} else {
			aeroportoService.salvar(aeroporto);
		}
		model.addAttribute("aeroportos", aeroportoService.listar());
		return "aeroporto/tabela-aeroporto";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletarAeroporto(@PathVariable Integer id) {
		try {
			aeroportoService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	// metodo de update
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Aeroporto buscarAeroporto(@PathVariable Integer id) {
		Aeroporto aeroporto = aeroportoService.buscar(id);
		return aeroporto;
	}

	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Cidade.class, cidadePropertyEditor);

	}

	@RequestMapping("/cidade/{nome}")
	@ResponseBody
	public Iterable<Aeroporto> buscarPorCidade(@PathVariable String nome) {
		return aeroportoService.buscarPorCidade(nome);
	}

}
