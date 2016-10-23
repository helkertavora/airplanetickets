<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<fmt:setLocale value="pt_BR"/>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr id="cabecalho">
			<td>#</td>
			<td>Nome</td>
			<td>CPF</td>
			<td>CNPJ</td>
			<td>email</td>
			<td>telefone</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${clientes}" var="cliente">
			<tr data-id="${cliente.id}">
			
				<td>${cliente.id}</td>
				<td>${cliente.nome}</td>
				<td>${cliente.cpf}</td>
				<td>${cliente.cnpj}</td>
				<td>${cliente.email}</td>
				<td>${cliente.telefone}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Clientes cadastrados:<span id="qtd-cliente"> ${clientes.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-cliente">Cadastrar Cliente</button>
			</td>
		</tr>
	</tfoot>
</table>