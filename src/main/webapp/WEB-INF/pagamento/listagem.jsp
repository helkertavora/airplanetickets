<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request"/>
	<style type="text/css">
		@IMPORT url("${path}/static/css/datepicker.css");
		@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
		@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		@IMPORT url("${path}/static/css/estilo.css");
	</style>
</head>
<body>
	<div class="container">
	<jsp:include page="/templates/menu-aplicacao.jsp"></jsp:include>
	<c:if test="${not empty mensagemError}">
		<div>
			<div class="alert alert-danger">${mensagemError}</div>
		</div>
	</c:if>
	<c:if test="${not empty mensagemSucesso}">
		<div>
			<div class="alert alert-success">${mensagemSucesso}</div>
		</div>
	</c:if>
	<section id="sessao-pagamento">
		<jsp:include page="tabela-pagamento.jsp"></jsp:include>
	</section>
	<jsp:include page="modal-pagamento.jsp" />
	</div>
</body>
<script src="${path}/static/js/jquery.js"></script>
<script src="${path}/static/js/jquery-2.1.4.min.js"></script>
<script src="${path}/static/js/jquery-validate.min.js"></script>
<script src="${path}/static/js/jquery-validate.js"></script>
<script src="${path}/static/js/jquery-ui.js"></script>
<script src="${path}/static/js/jquery-ui.min.js"></script>
<script src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/static/js/pagamento/pagamento.js"></script>
</html>