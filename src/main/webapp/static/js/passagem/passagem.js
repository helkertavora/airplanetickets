$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'passagem';
	var dadosPassagem = $('#form-passagem').serialize();
	
	$.post(url, dadosPassagem)
	.done(function(pagina){
		$('#sessao-passagem').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-passagem').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#passageiro option').attr('selected', false);
	$('#reserva option').attr('selected', false);
};
	

	var aplicarListeners = function(){
		$('#modal-passagem').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "passagem/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var passagem = parseInt( $('#qtd-passagem').text() );
					$('#qtd-passagem').text(passagem - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "passagem/"+id;
			
			$.get(url)
			.success(function(passagem){
				$('#id').val(passagem.id);
				var id2 = passagem.passageiro.id;
				$('#passageiro option[value='+id2+']').attr('selected', true);
				var id = passagem.reserva.id;
				$('#reserva option[value='+id+']').attr('selected', true);
				$('#modal-passageiro').modal('show');
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

