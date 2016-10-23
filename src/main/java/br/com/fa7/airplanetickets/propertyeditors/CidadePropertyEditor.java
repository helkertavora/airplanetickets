package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.Cidade;
import br.com.fa7.airplanetickets.modelo.repositorios.CidadeRepository;

@Component
public class CidadePropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private CidadeRepository cidadeRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idCidade = Integer.parseInt(text);
		Cidade cidade = cidadeRepositorios.findOne(idCidade);
		setValue(cidade);
	}

}