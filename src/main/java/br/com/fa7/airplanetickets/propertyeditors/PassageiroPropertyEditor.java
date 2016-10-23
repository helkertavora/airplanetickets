package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.Passageiro;
import br.com.fa7.airplanetickets.modelo.repositorios.PassageiroRepository;

@Component
public class PassageiroPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private PassageiroRepository passageiroRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idPassageiro = Integer.parseInt(text);
		Passageiro passageiro = passageiroRepositorios.findOne(idPassageiro);
		setValue(passageiro);
	}

}