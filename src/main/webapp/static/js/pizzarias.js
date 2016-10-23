$(document).ready(function(){

});	

$('#btn-salvar').on('click', function(){
	var url = 'pizzarias';
	var dadosPizzarias = $('#form-pizzarias').serialize();
	
	$.post(url, dadosPizzarias)
	.done(function(pagina){
		$('#sessao-pizzarias').html(pagina);
		aplicarListeners();
	})
	.fail(function(){
		//console.log(e);
		alert('Erro ao Salvar!');
	}).always(function(){
		$('#modal-pizzarias').modal('hide');
		
	});
	
});

var limparModal = function(){
	$('#id').val('');
	$('#dataCadastro').val('');
	$('#endereco').val('');
	$('#login').val('');
	$('#nome').val('');
	$('#senha').val('');
};

var aplicarListeners = function(){
	$('#modal-pizzarias').on('hide.bs.modal', limparModal);
	
};

$(function() {
    $("#dataCadastro").datepicker({
        dateFormat: 'dd/mm/yy',
        dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
        dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez']
    });
});

var buscar = function(){
	var nomePizza = $('#pizza_pesquisa').val();
	var url = 'cliente/pizza/'+nomePizza;
	
	$.get(url)
	.success(function(view){
		$('#secao-pizzarias').html(view);
	});
};

$(document).ready(function(){
	
	$('#btn-buscar').on('click', buscar);
});










