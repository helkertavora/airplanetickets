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
			<td>Estado</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cidades}" var="cidade">
			<tr data-id="${cidade.id}">
			
				<td>${cidade.id}</td>
				<td>${cidade.nome}</td>
				<td>${cidade.estado}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="4">Cidades cadastrados:<span id="qtd-cidade"> ${cidades.size()}</span></td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-cidade">Cadastrar Cidade</button>
			</td>
		</tr>
	</tfoot>
</table>