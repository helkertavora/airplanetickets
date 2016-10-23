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
			<td>Sigla</td>
			<td>N°</td>
			<td>Previsão Saida</td>
			<td>Previsão Chegada</td>
			<td>Aeroporto Saida</td>
			<td>Aeroporto Chegada</td>
			<td>Valor</td>
			<td>Empresa Aerea</td>
			<td>Qtd Assentos Disp.</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${voos}" var="voo">
			<tr data-id="${voo.id}">
			
				<td>${voo.id}</td>
				<td>${voo.sigla}</td>
				<td>${voo.numero}</td>
				<fmt:formatDate value="${voo.dataHoraPrevistoSaida}" pattern="dd/MM/yyyy' at: 'hh:mm:ss"/>
				<fmt:formatDate value="${voo.dataHoraPrevistoChegada}" pattern="dd/MM/yyyy' at: 'hh:mm:ss"/>
				<td>${voo.aeroportoSaida.nome}</td>
				<td>${voo.aeroportoChegada.nome}</td>
				<td><fmt:formatNumber value="${voo.valor}" type="currency"/></td>
				<td>${voo.empresaAerea.nome}</td>
				<td>${voo.quantidadeAssentosDisponiveis}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="11">Voos cadastrados:<span id="qtd-voo"> ${voos.size()}</span></td>
		</tr>
		<tr>
			<td colspan="11">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-voo">Cadastrar Voo</button>
			</td>
		</tr>
	</tfoot>
</table>