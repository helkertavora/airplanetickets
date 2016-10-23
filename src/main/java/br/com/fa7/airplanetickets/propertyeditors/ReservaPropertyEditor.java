package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.Reserva;
import br.com.fa7.airplanetickets.modelo.repositorios.ReservaRepository;

@Component
public class ReservaPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private ReservaRepository reservaRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idReserva = Integer.parseInt(text);
		Reserva reserva = reservaRepositorios.findOne(idReserva);
		setValue(reserva);
	}

}