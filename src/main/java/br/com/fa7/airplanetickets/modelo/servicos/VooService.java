package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.Voo;
import br.com.fa7.airplanetickets.modelo.repositorios.VooRepository;

@Service
public class VooService {

	@Autowired 
	private VooRepository repositorio;
	
	public void salvar(Voo voo){
		if (voo.getId() != null){
			Voo vooSaved = this.buscar(voo.getId());
			voo.setEstaAtivo(vooSaved.getEstaAtivo());
			voo.setDataRegistro(vooSaved.getDataRegistro());
		}		
		
		repositorio.save(voo);
	}
	
	public  Iterable<Voo> listar(){
		return repositorio.findAll();
	}
	
	public Voo buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Voo voo = this.buscar(id);
		if(voo != null) repositorio.delete(voo);
}
}
