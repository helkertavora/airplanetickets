$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'reserva';
	var dadosReserva = $('#form-reserva').serialize();
	
	$.post(url, dadosReserva)
	.done(function(pagina){
		$('#sessao-reserva').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-reserva').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#voo option').attr('selected', false);
	$('#cliente option').attr('selected', false);
};
	

	var aplicarListeners = function(){
		$('#modal-reserva').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "reserva/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var reserva = parseInt( $('#qtd-reserva').text() );
					$('#qtd-reserva').text(reserva - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "reserva/"+id;
			
			$.get(url)
			.success(function(reserva){
				$('#id').val(reserva.id);
				var id = reserva.voo.id;
				$('#voo option[value='+id+']').attr('selected', true);
				var id2 = reserva.cliente.id;
				$('#cliente option[value='+id2+']').attr('selected', true);
				$('#modal-reserva').modal('show');
			});
				
		});

	}
	$(document).ready(function(){
		   $(".btn-deletar").click( function(event) {
		      var apagar = confirm('Deseja realmente excluir este registro?');
		      if (apagar){
		    	  
		      }else{
		         event.preventDefault();
		      }	
		   });
		});

	
