package br.com.fa7.airplanetickets.modelo.servicos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fa7.airplanetickets.modelo.entidades.Reserva;
import br.com.fa7.airplanetickets.modelo.repositorios.ReservaRepository;


@Service
public class ReservaService {

    private static final Logger log = LoggerFactory.getLogger("system");

    @Autowired
    private ReservaRepository reservaRepository;
    
    public void salvar(Reserva reserva){
		if (reserva.getId() != null){
			Reserva reservaSaved = this.buscar(reserva.getId());
			reserva.setEstaAtivo(reservaSaved.getEstaAtivo());
			reserva.setDataRegistro(reservaSaved.getDataRegistro());
		}	    	
    	
    	reservaRepository.save(reserva);
	}
	
	public  Iterable<Reserva> listar(){
		return reservaRepository.findAll();
	}
	
	public Reserva buscar(Integer id){
		return reservaRepository.findOne(id);
	}
	
	public void remover(Integer id){
		Reserva reserva = this.buscar(id);
		if(reserva != null) reservaRepository.delete(reserva);
}

    //only for test
    public void validate() {

        log.info("Start validate...");

        reservaRepository.save(new Reserva());
        reservaRepository.save(new Reserva());
        reservaRepository.save(new Reserva());
        reservaRepository.save(new Reserva());

        log.info("Reserva found with findAll():");
        log.info("-------------------------------");
        for (Reserva reserva : reservaRepository.findAll()) {
            log.info(reserva.toString());
            log.info(reservaRepository.findOne(reserva.getId()).toString());
        }
    }

}
