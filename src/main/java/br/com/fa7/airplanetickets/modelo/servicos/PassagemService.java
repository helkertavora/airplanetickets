package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.Passagem;
import br.com.fa7.airplanetickets.modelo.repositorios.PassagemRepository;

@Service
public class PassagemService {

	@Autowired 
	private PassagemRepository repositorio;
	
	public void salvar(Passagem passagem){
		repositorio.save(passagem);
	}
	
	public  Iterable<Passagem> listar(){
		return repositorio.findAll();
	}
	
	public Passagem buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Passagem passagem = this.buscar(id);
		if(passagem != null) repositorio.delete(passagem);
}
}
