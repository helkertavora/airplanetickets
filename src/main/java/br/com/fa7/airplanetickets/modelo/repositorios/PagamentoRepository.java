package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.fa7.airplanetickets.modelo.entidades.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {

}
