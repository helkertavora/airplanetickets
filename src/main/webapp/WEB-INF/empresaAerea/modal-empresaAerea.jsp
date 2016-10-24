<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<div class="modal fade" id="modal-empresaAerea" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		<form id="form-empresaAerea" method="POST" >
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Informacoes da Empresa Aerea</h4>
			</div>
			<div class="modal-body">
			<label for="nome">Nome: </label>
			<input id="nome" name="nome" class="form-control">
			
			<label for="sigla">Sigla: </label>
			<input id="sigla" name="sigla" class="form-control">
						
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