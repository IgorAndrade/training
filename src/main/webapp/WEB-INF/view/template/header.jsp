<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href='<s:url value="home" />'> <s:message code="sistema.titulo" /></a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
					class="caret"></b></a>
				<ul class="dropdown-menu message-dropdown">
					<li class="message-preview"><a href="#">
							<div class="media">
								<span class="pull-left"> <img class="media-object"
									src="http://placehold.it/50x50" alt="">
								</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
					</a></li>
					<li class="message-preview"><a href="#">
							<div class="media">
								<span class="pull-left"> <img class="media-object"
									src="http://placehold.it/50x50" alt="">
								</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
					</a></li>
					<li class="message-preview"><a href="#">
							<div class="media">
								<span class="pull-left"> <img class="media-object"
									src="http://placehold.it/50x50" alt="">
								</span>
								<div class="media-body">
									<h5 class="media-heading">
										<strong>John Smith</strong>
									</h5>
									<p class="small text-muted">
										<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
					</a></li>
					<li class="message-footer"><a href="#">Read All New
							Messages</a></li>
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-bell"></i> <b
					class="caret"></b></a>
				<ul class="dropdown-menu alert-dropdown">
<%-- 					<li><a href="#">Alert Name <span --%>
<%-- 							class="label label-default">Alert Badge</span></a></li> --%>
<%-- 					<li><a href="#">Alert Name <span --%>
<%-- 							class="label label-primary">Alert Badge</span></a></li> --%>
<%-- 					<li><a href="#">Alert Name <span --%>
<%-- 							class="label label-success">Alert Badge</span></a></li> --%>
<%-- 					<li><a href="#">Alert Name <span class="label label-info">Alert --%>
<%-- 								Badge</span></a></li> --%>
<%-- 					<li><a href="#">Alert Name <span --%>
<%-- 							class="label label-warning">Alert Badge</span></a></li> --%>
<%-- 					<li><a href="#">Alert Name <span --%>
<%-- 							class="label label-danger">Alert Badge</span></a></li> --%>
<!-- 					<li class="divider"></li> -->
<!-- 					<li><a href="#">View All</a></li> -->
				</ul></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i>
				 <c:if test="${not empty userLogado}">
				 ${userLogado.nome }
				 </c:if> <b	class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="fa fa-fw fa-user"></i> <s:message code="menu.profile"/></a></li>
<!-- 					<li><a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>		</li> -->
<!-- 					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a></li> -->
					<li class="divider"></li>
					<li><a href='<s:url value="/logout"></s:url>'><i class="fa fa-fw fa-power-off"></i> <s:message code="menu.sair" /></a></li>
				</ul></li>
		</ul>
		<sec:authorize access="isAuthenticated()" >
		<jsp:include page="menu.jsp"/>
		</sec:authorize>
	</nav>
</body>

</html>
