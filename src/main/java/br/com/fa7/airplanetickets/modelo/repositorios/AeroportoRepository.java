package br.com.fa7.airplanetickets.modelo.repositorios;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.fa7.airplanetickets.modelo.entidades.Aeroporto;

public interface AeroportoRepository extends CrudRepository<Aeroporto, Integer> {

	@Cacheable(value="findByCidadeCache")
	@Query("from Aeroporto a join a.cidade c where c.nome=:cidadeName")
	public Iterable<Aeroporto> findByCidade(@Param("cidadeName") String categoryName);
	
}
