package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.TipoPagamento;
import br.com.fa7.airplanetickets.modelo.repositorios.TipoPagamentoRepository;

@Service
public class TipoPagamentoService {

	@Autowired 
	private TipoPagamentoRepository repositorio;
	
	public void salvar(TipoPagamento tipoPagamento){
		if (tipoPagamento.getId() != null){
			TipoPagamento tipoPagamentoSaved = this.buscar(tipoPagamento.getId());
			tipoPagamento.setEstaAtivo(tipoPagamentoSaved.getEstaAtivo());
			tipoPagamento.setDataRegistro(tipoPagamentoSaved.getDataRegistro());
		}			
		
		repositorio.save(tipoPagamento);
	}
	
	public  Iterable<TipoPagamento> listar(){
		return repositorio.findAll();
	}
	
	public TipoPagamento buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		TipoPagamento tipoPagamento = this.buscar(id);
		if(tipoPagamento != null) repositorio.delete(tipoPagamento);
}
}
