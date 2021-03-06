<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<div class="modal fade" id="modal-reserva" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form id="form-reserva" method="POST" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Informações da Reserva</h4>
			</div>
			<div class="modal-body">
			
			<label for="voo">Escolha o Voo: </label>
			<select id="voo" name="voo" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${voos}" var="voo">
				<option value="${voo.id}">${voo.sigla} / ${voo.numero} </option>
				</c:forEach>
			</select>
			
			<label for="cliente">Cliente da reserva: </label>
			<select id="cliente" name="cliente" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${clientes}" var="cliente">
				<option value="${cliente.id}">${cliente.nome}</option>
				</c:forEach>
			</select>
			
			<input id="id" name="id" type="hidden">
			<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button id="btn-salvar" type="button" class="btn btn-primary" >Salvar Informacoes</button>
			</div>
		  </form>
		</div>
	</div>
</div>