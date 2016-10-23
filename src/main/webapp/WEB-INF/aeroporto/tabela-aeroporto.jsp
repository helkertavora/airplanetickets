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
			<td>Nome</td>
			<td>Cidade</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${aeroportos}" var="aeroporto">
			<tr data-id="${aeroporto.id}">
			
				<td>${aeroporto.id}</td>
				<td>${aeroporto.nome}</td>
				<td>${aeroporto.cidade.nome}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">Aeroportos cadastrados:<span id="qtd-aeroporto"> ${aeroportos.size()}</span></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-aeroporto">Cadastrar Aeroporto</button>
			</td>
		</tr>
	</tfoot>
</table>