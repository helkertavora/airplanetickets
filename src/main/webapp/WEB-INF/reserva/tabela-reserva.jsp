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
			<td>Voo sigla</td>
			<td>Voo Numero</td>
			<td>Cliente da reserva</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reservas}" var="reserva">
			<tr data-id="${reserva.id}">
			
				<td>${reserva.id}</td>
				<td>${reserva.voo.sigla}</td>
				<td>${reserva.voo.numero}</td>
				<td>${reserva.cliente.nome}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Reservas cadastradas:<span id="qtd-reserva"> ${reservas.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-reserva">Cadastrar Reserva</button>
			</td>
		</tr>
	</tfoot>
</table>