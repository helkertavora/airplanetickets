package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.fa7.airplanetickets.modelo.entidades.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	
}
