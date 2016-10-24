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
		@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
		@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
		@IMPORT url("${path}/static/css/jquery-ui.css");
		@IMPORT url("${path}/static/css/estilo.css");
		
	</style>
</head>
<body>
	<div class="container">
	<jsp:include page="/templates/menu-aplicacao.jsp"></jsp:include>

	<section id="home" >
		<h1>bem vindo ao AirplaneTickets!!</h1>
		<img alt="" style="width: 1140px; height: 500px" src="${path}/static/images/fa7.jpg">
	</section>
	
	</div>
</body>
<script src="${path}/static/js/jquery.js"></script>
<script src="${path}/static/js/jquery-2.1.4.min.js"></script>
<script src="${path}/static/js/jquery-ui.js"></script>
<script src="${path}/static/js/jquery-ui.min.js"></script>
<script src="${path}/static/js/jquery.validate.js"></script>
<script src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/static/js/pizzarias.js"></script>
</html>