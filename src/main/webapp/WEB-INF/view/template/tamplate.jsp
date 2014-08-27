<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="br.com.irsa.training.enums.TypeMsg"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><s:message code="sistema.titulo" /></title>

<!-- Bootstrap Core CSS -->
<link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">

<!-- Custom CSS -->
<link href="<s:url value="/css/sb-admin.css"/>" rel="stylesheet">
<link href="<s:url value="/css/style.css"/>" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<s:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp" />
		<div id="page-wrapper">
			<div class="container-fluid" id="corpo">
				<c:if test="${not empty SUCCESS}">
					<div class="alert alert-success">
						<strong><s:message code="success.titulo" /></strong> <c:out value="${SUCCESS}"/> 
					</div>
				</c:if>
				<c:if test="${not empty ERROR}">
					<div class="alert alert-danger">
						<strong><s:message code="erro.titulo" /></strong> <c:out value="${ERROR}"/>
					</div>
				</c:if>

				<jsp:include page="${body}" />
			</div>
			<!-- /.container-fluid -->
			<jsp:include page="footer.jsp" />
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<!-- jQuery Version 1.11.0 -->
	<script src="<s:url value="/js/jquery-1.11.0.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<s:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>