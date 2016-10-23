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

import br.com.fa7.airplanetickets.excessoes.PagamentoException;
import br.com.fa7.airplanetickets.modelo.entidades.Pagamento;
import br.com.fa7.airplanetickets.modelo.entidades.Reserva;
import br.com.fa7.airplanetickets.modelo.entidades.TipoPagamento;
import br.com.fa7.airplanetickets.modelo.servicos.PagamentoService;
import br.com.fa7.airplanetickets.modelo.servicos.ReservaService;
import br.com.fa7.airplanetickets.modelo.servicos.TipoPagamentoService;
import br.com.fa7.airplanetickets.propertyeditors.ReservaPropertyEditor;
import br.com.fa7.airplanetickets.propertyeditors.TipoPagamentoPropertyEditor;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private TipoPagamentoService tipoPagamentoService;
	@Autowired
	private TipoPagamentoPropertyEditor tipoPagamentoPropertyEditors;
	@Autowired
	private ReservaPropertyEditor reservaPropertyEditors;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarPagamento(Model model){
		Iterable<Pagamento> pagamento = pagamentoService.listar();
		
		model.addAttribute("titulo", "Listagem de Pagamentos");
		model.addAttribute("pagamentos", pagamento);
		model.addAttribute("tipoPagamentos", tipoPagamentoService.listar());
		model.addAttribute("reservas", reservaService.listar());
		
		return "pagamento/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarPagamentos(@Valid @ModelAttribute Pagamento pagamento, BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			throw new PagamentoException();
		}else{
			pagamentoService.salvar(pagamento);
		}
		model.addAttribute("pagamentos", pagamentoService.listar());
		return "pagamento/tabela-pagamento";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarPagamento(@PathVariable Integer id){
		
		try {
			pagamentoService.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//metodo de update
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Pagamento buscarPagamento(@PathVariable Integer id){
		Pagamento pagamento = pagamentoService.buscar(id);
		return pagamento;
	}
	
	@InitBinder
	public void transformTextInLong(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(TipoPagamento.class, tipoPagamentoPropertyEditors);
		webDataBinder.registerCustomEditor(Reserva.class, reservaPropertyEditors);
	}


}