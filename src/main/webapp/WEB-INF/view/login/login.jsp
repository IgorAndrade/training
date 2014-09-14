<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Page Heading -->
<div class="row">
	<div class="col-xs-12">
		<h1 class="page-header"><s:message code="form.login.title" />  </h1>
	</div>
</div>
<div class="row">
	<div class="col-md-6">
		<f:form action="logar" method="POST">
			<div class="form-group">
				<label for="InputEmail"><s:message code="form.login.login" />
				</label> <input type="text" class="form-control" name="login"
					id="InputEmail"
					placeholder="<s:message code="form.login.login.title" />">
			</div>
			<div class="form-group">
				<a href="#" class="pull-right"><s:message
						code="form.login.btn" /></a>
				<label for="InputPassword"><s:message
						code="form.login.senha" /></label>
				 <input type="password"
					class="form-control" name="senha" id="InputPassword">
			</div>
			<div class="row">
				<div class="col-xs-6">
					<button type="submit" class="btn btn-primary"><s:message code="form.login.btn.logar"/></button>
				</div>
				<div class="col-xs-6">
					<a href='<s:url value="/user"/>' class="btn btn-default pull-right"><s:message code="form.login.btn.cad"/></a>
				</div>
			</div>
		</f:form>
	</div>
</div> 