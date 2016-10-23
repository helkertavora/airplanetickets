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
			<td>Data de Nascimento</td>
			<td>Nome</td>
			<td>Tipo do Documento</td>
			<td>Documento</td>
			<td>Nome Contato de Emergência</td>
			<td>Relactionamento Contato de Emergência</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${passageiros}" var="passageiro">
			<tr data-id="${passageiro.id}">
			
				<td>${passageiro.id}</td>
				<td>
				<fmt:formatDate value="${passageiro.dataNascimento}" pattern="dd/MM/yyyy"/>
				</td>
				<td>${passageiro.nome}</td>
				<td>${passageiro.tipoDocumento}</td>
				<td>${passageiro.documento}</td>
				<td>${passageiro.nomeContatoEmergencia}</td>
				<td>${passageiro.relactionamentoContatoEmergencia}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">Passageiros cadastrados:<span id="qtd-passageiro"> ${passageiros.size()}</span></td>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-passageiro">Cadastrar Passageiro</button>
			</td>
		</tr>
	</tfoot>
</table>