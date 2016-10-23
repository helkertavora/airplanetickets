package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.fa7.airplanetickets.modelo.entidades.Voo;

public interface VooRepository extends CrudRepository<Voo, Integer> {

}
