package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.fa7.airplanetickets.modelo.entidades.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Integer> {

}
