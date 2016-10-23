package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.EmpresaAerea;
import br.com.fa7.airplanetickets.modelo.repositorios.EmpresaAereaRepository;

@Service
public class EmpresaAereaService {

	@Autowired 
	private EmpresaAereaRepository repositorio;
	
	public void salvar(EmpresaAerea empresaAerea){
		if (empresaAerea.getId() != null){
			EmpresaAerea empresaAereaSaved = this.buscar(empresaAerea.getId());
			empresaAerea.setEstaAtivo(empresaAereaSaved.getEstaAtivo());
			empresaAerea.setDataRegistro(empresaAereaSaved.getDataRegistro());
		}		
		repositorio.save(empresaAerea);
	}
	
	public  Iterable<EmpresaAerea> listar(){
		return repositorio.findAll();
	}
	
	public EmpresaAerea buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		EmpresaAerea empresaAerea = this.buscar(id);
		if(empresaAerea != null) repositorio.delete(empresaAerea);
}
}
