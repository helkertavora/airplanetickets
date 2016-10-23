$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'ingredientes';
	var dadosIgrediente = $('#form-ingrediente').serialize();
	
	$.post(url, dadosIgrediente)
	.done(function(pagina){
		$('#sessao-ingredientes').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-ingrediente').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#categoria').val('');
};
	

	var aplicarListeners = function(){
		$('#modal-ingrediente').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "ingredientes/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var ingredientes = parseInt( $('#qtd-ingrediente').text() );
					$('#qtd-ingrediente').text(ingredientes - 1);
				}
			});
		});
		
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "ingredientes/"+id;
			
			$.get(url)
			.success(function(ingrediente){
				$('#id').val(ingrediente.id);
				$('#nome').val(ingrediente.nome);
				$('#categoria').val(ingrediente.categoria);
				
				$('#modal-ingrediente').modal('show');
			});
				
		});
		
		
	}

	$(document).ready(function(){
		   $(".excluir").click( function(event) {
		      var apagar = confirm('Deseja realmente excluir este registro?');
		      if (apagar){
		    	 
		      }else{
		         event.preventDefault();
		      }	
		   });
		});
	


