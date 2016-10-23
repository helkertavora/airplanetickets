package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.fa7.airplanetickets.modelo.entidades.Passageiro;

public interface PassageiroRepository extends CrudRepository<Passageiro, Integer> {

}
