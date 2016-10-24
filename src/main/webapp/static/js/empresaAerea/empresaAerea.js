$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'empresaAerea';
	var dadosEmpresaAerea = $('#form-empresaAerea').serialize();
	
	$.post(url, dadosEmpresaAerea)
	.done(function(pagina){
		$('#sessao-empresaAerea').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-empresaAerea').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#sigla').val('');
	
};
	

	var aplicarListeners = function(){
		$('#modal-empresaAerea').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "empresaAerea/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var empresaAerea = parseInt( $('#qtd-empresaAerea').text() );
					$('#qtd-empresaAerea').text(empresaAerea - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "empresaAerea/"+id;
			
			$.get(url)
			.success(function(empresaAerea){
				$('#id').val(empresaAerea.id);
				$('#nome').val(empresaAerea.nome);
				$('#sigla').val(empresaAerea.sigla);
				$('#modal-empresaAerea').modal('show');
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


