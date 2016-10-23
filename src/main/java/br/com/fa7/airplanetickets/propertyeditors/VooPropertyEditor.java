package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.Voo;
import br.com.fa7.airplanetickets.modelo.repositorios.VooRepository;

@Component
public class VooPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private VooRepository vooRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idVoo = Integer.parseInt(text);
		Voo voo = vooRepositorios.findOne(idVoo);
		setValue(voo);
	}

}