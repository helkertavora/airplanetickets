$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'voo';
	var dadosVoo = $('#form-voo').serialize();
	
	$.post(url, dadosVoo)
	.done(function(pagina){
		$('#sessao-voo').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-voo').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#sigla').val('');
	$('#numero').val('');
	$('#dataHoraPrevistoSaida').val('');
	$('#dataHoraPrevistoChegada').val('');
	$('#aeroportoSaida option').attr('selected', false);
	$('#aeroportoChegada option').attr('selected', false);
	$('#valor').val('');
	$('#empresaAerea option').attr('selected', false);
	$('#quantidadeAssentosDisponiveis').val('');
};
	

	var aplicarListeners = function(){
		$('#modal-voo').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "voo/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var voo = parseInt( $('#qtd-voo').text() );
					$('#qtd-voo').text(voo - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "voo/"+id;
			
			$.get(url)
			.success(function(voo){
				$('#id').val(voo.id);
				$('#sigla').val(voo.sigla);
				$('#numero').val(voo.numero);
				$('#dataHoraPrevistoSaida').val(voo.dataHoraPrevistoSaida);
				$('#dataHoraPrevistoChegada').val(voo.dataHoraPrevistoChegada);
				var id = voo.aeroportoSaida.id;
				$('#aeroportoSaida option[value='+id+']').attr('selected', true);
				var id2 = voo.aeroportoChegada.id;
				$('#aeroportoChegada option[value='+id2+']').attr('selected', true);
				$('#valor').val(voo.valor);	
				var id3 = voo.empresaAerea.id;
				$('#empresaAerea option[value='+id3+']').attr('selected', true);
				$('#quantidadeAssentosDisponiveis').val(voo.quantidadeAssentosDisponiveis);
				$('#modal-voo').modal('show');
			});
				
		});

	}
	
	$(function() {
	    $("#dataHoraPrevistoSaida, #dataHoraPrevistoChegada").datepicker({
	        dateFormat: 'dd/mm/yy',
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	    });
	});

	


