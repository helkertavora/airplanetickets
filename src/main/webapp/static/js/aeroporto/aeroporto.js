$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'aeroporto';
	var dadosAeroporto = $('#form-aeroporto').serialize();
	
	$.post(url, dadosAeroporto)
	.done(function(pagina){
		$('#sessao-aeroporto').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-aeroporto').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#cidade option').attr('selected', false);
};
	

	var aplicarListeners = function(){
		$('#modal-aeroporto').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "aeroporto/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var aeroporto = parseInt( $('#qtd-aeroporto').text() );
					$('#qtd-aeroporto').text(aeroporto - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "aeroporto/"+id;
			
			$.get(url)
			.success(function(aeroporto){
				$('#id').val(aeroporto.id);
				$('#nome').val(aeroporto.nome);	
				var id = aeroporto.cidade.id;
				$('#cidade option[value='+id+']').attr('selected', true);
				
				
				$('#modal-aeroporto').modal('show');
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
	



