<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr id="cabecalho">
			<td>#</td>
			<td>Data</td>
			<td>Tipo do Pagamento</td>
			<td>Reserva</td>
			<td>Valor do pagamento R$:</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pagamentos}" var="pagamento">
			<tr data-id="${pagamento.id}">
			
				<td>${pagamento.id}</td>
				<fmt:formatDate value="${pagamento.data}" pattern="dd/MM/yyyy' at: 'hh:mm:ss"/>
				<td>${pagamento.tipoPagamento.descricao}</td>
				<td>${pagamento.reserva.voo.numero} / ${passagem.reserva.voo.sigla}</td>
				<td><fmt:formatNumber value="${pagamento.valor}" type="currency"/></td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">Pagamentos cadastrados:<span id="qtd-pagamento"> ${pagamentos.size()}</span></td>
		</tr>
		<tr>
			<td colspan="6">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-pagamento">Cadastrar Pagamento</button>
			</td>
		</tr>
	</tfoot>
</table>