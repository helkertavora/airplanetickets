$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'pagamento';
	var dadosPagamento = $('#form-pagamento').serialize();
	
	$.post(url, dadosPagamento)
	.done(function(pagina){
		$('#sessao-pagamento').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-pagamento').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#data').val('');
	$('#tipoPagamento option').attr('selected', false);
	$('#reserva option').attr('selected', false);
	$('#valor').val('');
};
	

	var aplicarListeners = function(){
		$('#modal-pagamento').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "pagamento/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var pagamento = parseInt( $('#qtd-pagamento').text() );
					$('#qtd-pagamento').text(pagamento - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "pagamento/"+id;
			
			$.get(url)
			.success(function(pagamento){
				$('#id').val(pagamento.id);
				$('#data').val(pagamento.data);
				var id = pagamento.tipoPagamento.id;
				$('#tipoPagamento option[value='+id+']').attr('selected', true);
				var id2 = pagamento.reserva.id;
				$('#reserva option[value='+id2+']').attr('selected', true);
				$('#valor').val(pagamento.valor);
				$('#modal-pagamento').modal('show');
			});	
		});
	}
	
	$(function() {
	    $("#data").datepicker({
	        dateFormat: 'dd/mm/yy',
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	    });
	});

	$(function() {
	    $("#data").timepicker({
	                timeOnlyTitle: 'Escolha o horario',
	                timeText: 'Horario',
	                hourText: 'Hora',
	                minuteText: 'Minutos',
	                secondText: 'Segundos',
	                millisecText: 'Milissegundos',
	                microsecText: 'Microssegundos',
	                timezoneText: 'Fuso horÃ¡rio',
	                currentText: 'Agora',
	                closeText: 'Fechar',
	                timeFormat: 'HH:mm',
	                amNames: ['a.m.', 'AM', 'A'],
	                pmNames: ['p.m.', 'PM', 'P'],
	                isRTL: false
	    });
	});