$(document).ready(function(){
	
	aplicarListeners();
});	

$('#btn-salvar').on('click', function(){
	var url = 'cliente';
	var dadosCliente = $('#form-cliente').serialize();
	
	$.post(url, dadosCliente)
	.done(function(pagina){
		$('#sessao-cliente').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-cliente').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#cpf').val('');
	$('#cnpj').val('');
	$('#email').val('');
	$('#telefone').val('');
};
	

	var aplicarListeners = function(){
		$('#modal-cliente').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "cliente/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var clientes = parseInt( $('#qtd-cliente').text() );
					$('#qtd-cliente').text(clientes - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "cliente/"+id;
			
			$.get(url)
			.success(function(cliente){
				$('#id').val(cliente.id);
				$('#nome').val(cliente.nome);
				$('#cpf').val(cliente.cpf);
				$('#cnpj').val(cliente.cnpj);
				$('#email').val(cliente.email);
				$('#telefone').val(cliente.telefone);
				$('#modal-cliente').modal('show');
			});
				
		});

	}
	
	$(function() {
	    $("#").datepicker({
	        dateFormat: 'dd/mm/yy',
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	    });
	});

	$(document).ready(function(){
		   $(".btn-deletar").click( function(event) {
		      var apagar = confirm('Deseja realmente excluir este registro?');
		      if (apagar){
		    	  
		      }else{
		         event.preventDefault();
		      }	
		   });
		});
	


