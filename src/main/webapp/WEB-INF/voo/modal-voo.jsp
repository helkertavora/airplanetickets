<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<div class="modal fade" id="modal-voo" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form id="form-voo" method="POST" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Informações do Voo</h4>
			</div>
			<div class="modal-body">
			<label for="sigla">Sigla do Voo: </label>
			<input id="sigla" name="sigla" class="form-control">
			
			<label for="numero">Numero: </label>
			<input id="numero" name="numero" class="form-control">
			
			<label for="dataHoraPrevistoSaida">Data Hora Previsto Saida: </label>
			<input id="dataHoraPrevistoSaida" name="dataHoraPrevistoSaida" class="form-control">
			
			<label for="dataHoraPrevistoChegada">Data Hora Previsto Chegada: </label>
			<input id="dataHoraPrevistoChegada" name="dataHoraPrevistoChegada" class="form-control">
			
			<label for="aeroportoSaida">Aeroporto de Saida: </label>
			<select id="aeroportoSaida" name="aeroportoSaida" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${aeroportos}" var="aeroporto">
				<option value="${aeroporto.id}">${aeroporto.nome}</option>
				</c:forEach>
			</select>
			
			<label for="aeroportoChegada">Aeroporto de Chegada: </label>
			<select id="aeroportoChegada" name="aeroportoChegada" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${aeroportos}" var="aeroporto">
				<option value="${aeroporto.id}">${aeroporto.nome}</option>
				</c:forEach>
			</select>
			
			<label for="valor">Valor: </label>
			<input id="valor" name="valor" class="form-control" required>
			
			<label for="empresaAerea">Empresa Aerea: </label>
			<select id="empresaAerea" name="empresaAerea" class="form-control" >
			<option value="">---selecione---</option>
				<c:forEach items="${empresaAereas}" var="empresaAerea">
				<option value="${empresaAerea.id}">${empresaAerea.nome}</option>
				</c:forEach>
			</select>
			
			<label for="quantidadeAssentosDisponiveis">Quantidade de Assentos Disponiveis: </label>
			<input id="quantidadeAssentosDisponiveis" name="quantidadeAssentosDisponiveis" class="form-control" required>
			
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