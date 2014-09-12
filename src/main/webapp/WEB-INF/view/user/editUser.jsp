<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			<s:message code="form.user.titulo" />
		</h1>
		<ol class="breadcrumb">
			<li><i class="fa fa-home"></i> <a href="home"><s:message
						code="breadcrumb.home" /></a></li>
			<li class="active"><i class="fa fa-edit"></i> <s:message
					code="form.user.titulo" /></li>
		</ol>
	</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<form role="form">
				<div class="form-group">
					<label class="control-label" for="nome"><s:message code="form.user.nome"/></label>
					 <input class="form-control" id="nome" name="nome" />
				</div>
				<div class="form-group">
					<label class="control-label" for="email"><s:message code="form.user.email"/></label>
					 <input class="form-control" id="email" name="email" placeholder="Login">
					<p class="help-block">Example block-level help text here.</p>
				</div>
				<button id="salvar"><s:message code="form.user.btn.salvar" /></button>
			</form>
		</div>
	</div>
<script type="text/javascript" src="<s:url value="/js/form.js"/>" > </script>

