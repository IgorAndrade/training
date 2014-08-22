<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			
<s:message code="erro.regranegocio.CadastroRepetido"></s:message>
		</h1>
		<ol class="breadcrumb">
			<li><i class="fa fa-dashboard"></i> <a href="index.html">Dashboard</a>
			</li>
			<li class="active"><i class="fa fa-file"></i> Blank Page</li>
		</ol>
		<c:if test="${not empty param.erro}">
                <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div>
            </c:if>
	</div>
</div>