package br.com.fa7.airplanetickets.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.Cliente;
import br.com.fa7.airplanetickets.modelo.repositorios.ClienteRepository;

@Service
public class ClienteService {

	@Autowired 
	private ClienteRepository repositorio;
	
	public void salvar(Cliente cliente){
		if (cliente.getId() != null){
			Cliente clienteSaved = this.buscar(cliente.getId());
			cliente.setEstaAtivo(clienteSaved.getEstaAtivo());
			cliente.setDataRegistro(clienteSaved.getDataRegistro());
		}			
		repositorio.save(cliente);
	}
	
	public  Iterable<Cliente> listar(){
		return repositorio.findAll();
	}
	
	public Cliente buscar(Integer id){
		return repositorio.findOne(id);
	}
	
	public void remover(Integer id){
		Cliente cliente = this.buscar(id);
		if(cliente != null) repositorio.delete(cliente);
}
}
