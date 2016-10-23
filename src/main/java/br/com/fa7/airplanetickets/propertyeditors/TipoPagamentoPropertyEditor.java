package br.com.fa7.airplanetickets.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fa7.airplanetickets.modelo.entidades.TipoPagamento;
import br.com.fa7.airplanetickets.modelo.repositorios.TipoPagamentoRepository;

@Component
public class TipoPagamentoPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private TipoPagamentoRepository tipoPagamentoRepositorios;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Integer idTipoPagamento = Integer.parseInt(text);
		TipoPagamento tipoPagamento = tipoPagamentoRepositorios.findOne(idTipoPagamento);
		setValue(tipoPagamento);
	}

}