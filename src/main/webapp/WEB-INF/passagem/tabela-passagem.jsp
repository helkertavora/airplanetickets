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
			<td>Passageiro</td>
			<td>Reserva</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${passagens}" var="passagem">
			<tr data-id="${passagem.id}">
			
				<td>${passagem.id}</td>
				<td>${passagem.passageiro.nome}</td>
				<td>${passagem.reserva.voo.numero} / ${passagem.reserva.voo.sigla}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">Passagens cadastradas:<span id="qtd-passagem"> ${passagens.size()}</span></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-passagem">Cadastrar Passagem</button>
			</td>
		</tr>
	</tfoot>
</table>