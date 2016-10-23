<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<div class="modal fade" id="modal-passagem" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form id="form-passagem" method="POST" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Informações da Passagem</h4>
			</div>
			<div class="modal-body">
			
			<label for="passageiro">Escolha o Passageiro: </label>
			<select id="passageiro" name="passageiro" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${passageiros}" var="passageiro">
				<option value="${passageiro.id}">${passageiro.nome}</option>
				</c:forEach>
			</select>
			
			<label for="reserva">Escolha a reserva: </label>
			<select id="reserva" name="reserva" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${reservas}" var="reserva">
				<option value="${reserva.id}">${reserva.voo.numero} / ${reserva.voo.sigla}</option>
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