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
			<td>Sigla</td>
			<td>Voos da Empresa</td>
			<td>Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${empresaAereas}" var="empresaAerea">
			<tr data-id="${empresaAerea.id}">
			
				<td>${empresaAerea.id}</td>
				<td>${empresaAerea.nome}</td>
				<td>
					<c:forEach items="${empresaAerea.voos}" var="voo">
						(${voo.numero} , ${voo.sigla}) /
					</c:forEach>
				</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button>
					<button type="button" class="btn btn-danger btn-deletar">Apagar</button>
				</td>
			</tr>
		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Empresas Aereas cadastradas:<span id="qtd-empresaAerea"> ${empresaAereas.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-empresaAerea">Cadastrar Empresa Aerea</button>
			</td>
		</tr>
	</tfoot>
</table>