package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.fa7.airplanetickets.modelo.entidades.Aeroporto;

public interface AeroportoRepository extends CrudRepository<Aeroporto, Integer> {

}
