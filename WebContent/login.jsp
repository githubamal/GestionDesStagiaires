<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!-- Latest compiled and minified CSS -->
<script src="${context}/resources/lib/jquery/jquery-1.11.3.min.js"></script>

<link rel="stylesheet"
	href="${context}/resources/lib/bootstrap-3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="${context}/resources/lib/bootstrap-3.3.4/css/bootstrap-theme.min.css">

<!-- Style css -->
<link rel="stylesheet" href="${context}/resources/css/style.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="${context}/resources/lib/bootstrap-3.3.4/js/bootstrap.min.js"></script>
<title>Gestion Des Stagiaires</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">
				<img alt="Brand"
				src="${pageContext.request.contextPath}/resources/images/colaimoo.png"
				width="80" height="30">
			</a>
		</div>
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
	</div>
	</nav>
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
				</div>
				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>
					<form action="${pageContext.request.contextPath}/login" method="Post" class="form-horizontal">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="username" value=""
								placeholder="username">
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder="password">
						</div>
						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="admin" value="1"> Administrateur
								</label>
							</div>
						</div>
						<!-- Button -->
						<div class="text-right">
							<input type="reset" class="btn btn-warning" value="Effacer" /> <input
								type="submit" class="btn btn-success" value="Login" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>