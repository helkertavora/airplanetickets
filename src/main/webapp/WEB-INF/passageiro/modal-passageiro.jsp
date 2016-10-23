<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<div class="modal fade" id="modal-passageiro" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form id="form-passageiro" method="POST" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Informacoes do Passageiro</h4>
			</div>
			<div class="modal-body">
			<label for="dataNascimento">Data de Nascimento: </label>
			<input id="dataNascimento" name="dataNascimento" class="form-control" required>
			
			<label for="nome">Nome: </label>
			<input id="nome" name="nome" class="form-control">
			
			<label for="tipoDocumento">Estado: </label>
			<select id="tipoDocumento" name="tipoDocumento" class="form-control">
			<option value="">---selecione---</option>
				<c:forEach items="${tipoDocumentos}" var="tipoDocumento">
				<option value="${tipoDocumento}">${tipoDocumento}</option>
				</c:forEach>
			</select>
			
			<label for="documento">Documento: </label>
			<input id="documento" name="documento" class="form-control">
			
			<label for="nomeContatoEmergencia">Nome Contato de Emergencia: </label>
			<input id="nomeContatoEmergencia" name="nomeContatoEmergencia" class="form-control">
			
			<label for="relactionamentoContatoEmergencia">Relactionamento Contato de Emergencia: </label>
			<select id="relactionamentoContatoEmergencia" name="relactionamentoContatoEmergencia" class="form-control">
			<option value="">---selecione---</option>
				<c:forEach items="${relactionamentoContatoEmergencias}" var="relactionamentoContatoEmergencia">
				<option value="${relactionamentoContatoEmergencia}">${relactionamentoContatoEmergencia}</option>
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