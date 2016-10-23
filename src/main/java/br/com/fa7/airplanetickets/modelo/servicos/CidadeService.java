package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.Cidade;
import br.com.fa7.airplanetickets.modelo.repositorios.CidadeRepository;

@Service
public class CidadeService {

	@Autowired 
	private CidadeRepository repositorio;
	
	public void salvar(Cidade cidade){
		repositorio.save(cidade);
	}
	
	public  Iterable<Cidade> listar(){
		return repositorio.findAll();
	}
	
	public Cidade buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Cidade cidade = this.buscar(id);
		if(cidade != null) repositorio.delete(cidade);
}
}
