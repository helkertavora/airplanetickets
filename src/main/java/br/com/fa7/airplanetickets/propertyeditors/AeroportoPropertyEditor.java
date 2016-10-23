package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.Aeroporto;
import br.com.fa7.airplanetickets.modelo.repositorios.AeroportoRepository;

@Component
public class AeroportoPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private AeroportoRepository aeroportoRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idAeroporto = Integer.parseInt(text);
		Aeroporto aeroporto = aeroportoRepositorios.findOne(idAeroporto);
		setValue(aeroporto);
	}

}