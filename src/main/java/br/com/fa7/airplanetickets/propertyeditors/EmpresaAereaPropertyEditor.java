package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.EmpresaAerea;
import br.com.fa7.airplanetickets.modelo.repositorios.EmpresaAereaRepository;

@Component
public class EmpresaAereaPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private EmpresaAereaRepository empresaAereaRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idEmpresaAerea = Integer.parseInt(text);
		EmpresaAerea empresaAerea = empresaAereaRepositorios.findOne(idEmpresaAerea);
		setValue(empresaAerea);
	}

}