<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">Airplane Tickets</a>
    </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      <li><a href="cidade">Cidades</a></li>
      <li><a href="aeroporto">Aeroportos</a></li>
      <li><a href="cliente">Clientes</a></li>
      <li><a href="passageiro">Passageiros</a></li>
      <li><a href="empresaAerea">Empresas Aereas</a></li>  
      <li><a href="voo">Voos</a></li> 
      <li><a href="reserva">Reservas</a></li>
      <li><a href="passagem">Passagens</a></li>   
      <li><a href="pagamento">Pagamentos</a></li>   
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li>
        	<form action="${path}/sair" method="post">
        	<input type="hidden" name="_csrf" value="${_csrf.token}">
        	</form>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>