package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.Pagamento;
import br.com.fa7.airplanetickets.modelo.repositorios.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired 
	private PagamentoRepository repositorio;
	
	public void salvar(Pagamento pagamento){
		repositorio.save(pagamento);
	}
	
	public  Iterable<Pagamento> listar(){
		return repositorio.findAll();
	}
	
	public Pagamento buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Pagamento pagamento = this.buscar(id);
		if(pagamento != null) repositorio.delete(pagamento);
}
}
