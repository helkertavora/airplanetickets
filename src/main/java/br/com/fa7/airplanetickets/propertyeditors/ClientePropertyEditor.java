package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.Cliente;
import br.com.fa7.airplanetickets.modelo.repositorios.ClienteRepository;

@Component
public class ClientePropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private ClienteRepository clienteRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idCliente = Integer.parseInt(text);
		Cliente cliente = clienteRepositorios.findOne(idCliente);
		setValue(cliente);
	}

}