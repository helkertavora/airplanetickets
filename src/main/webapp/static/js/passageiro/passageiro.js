$(document).ready(function(){
	
	aplicarListeners();
	
});	

$('#btn-salvar').on('click', function(){
	var url = 'passageiro';
	var dadosPassageiro = $('#form-passageiro').serialize();
	
	$.post(url, dadosPassageiro)
	.done(function(pagina){
		$('#sessao-passageiro').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-passageiro').modal('hide');
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#dataNascimento').val('');
	$('#nome').val('');
	$('#tipoDocumento').val('');
	$('#documento').val('');
	$('#nomeContatoEmergencia').val('');
	$('#relactionamentoContatoEmergencia').val('');
	
};
	

	var aplicarListeners = function(){
		$('#modal-passageiro').on('hide.bs.modal', limparModal);
		
		$('.btn-deletar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var csrf = $('#_csrf').val();
			
			$.ajax({
				url : "passageiro/"+id,
				type: 'DELETE',
				headers: {'X-CSRF-TOKEN': csrf },
				success: function(result){
					$('tr[data-id="'+id+'"]').remove();
					var passageiro = parseInt( $('#qtd-passageiro').text() );
					$('#qtd-passageiro').text(passageiro - 1);
				}
			});
		});
	
		$('.btn-editar').on('click', function(){
			var id = $(this).parents('tr').data('id');
			var url = "passageiro/"+id;
			
			$.get(url)
			.success(function(passageiro){
				$('#id').val(passageiro.id);
				$('#dataNascimento').val(passageiro.dataNascimento);
				$('#nome').val(passageiro.nome);
				$('#tipoDocumento').val(passageiro.tipoDocumento);
				$('#documento').val(passageiro.documento);
				$('#nomeContatoEmergencia').val(passageiro.nomeContatoEmergencia);
				$('#relactionamentoContatoEmergencia').val(passageiro.relactionamentoContatoEmergencia);
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
	
	$(function() {
	    $("#dataNascimento").datepicker({
	        dateFormat: 'dd/mm/yy',
	        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
	        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
	        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
	        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
	        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
	    });
	});

