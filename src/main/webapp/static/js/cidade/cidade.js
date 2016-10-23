$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'cidade';
	var dadosCidade = $('#form-cidade').serialize();
	
	$.post(url, dadosCidade)
	.done(function(pagina){
		$('#sessao-cidade').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-cidade').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#estado').val('');
	
};
	

	var aplicarListeners = function(){
		$('#modal-cidade').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "cidade/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var cidade = parseInt( $('#qtd-cidade').text() );
					$('#qtd-cidade').text(cidade - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "cidade/"+id;
			
			$.get(url)
			.success(function(cidade){
				$('#id').val(cidade.id);
				$('#nome').val(cidade.nome);
				$('#estado').val(cidade.estado);
				$('#modal-cidade').modal('show');
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
	


