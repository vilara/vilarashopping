<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>VilaraShopping - ${title}</title>
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<%-- <!-- Bootstrap core CSS -->

<!-- Bootstrap core readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"> --%>


<!-- Custom styles for this template -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<!-- Bootstrap Datatles Theme -->
<link
	href="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.css"
	rel="stylesheet">

<!-- Datatable Material Design -->
<!-- <script	src="//cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css"></script>
	<script	src="https://cdn.datatables.net/1.10.16/css/dataTables.material.min.css"></script> -->

<link href="${css}/myapp.css" rel="stylesheet">

</head>


<body>

	<div class="wrapper">

		<!-- Navigation -->

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

			<div class="container">

				<!-- Brand and toogle get grouped for better mobile display -->

				<div class="nav-header">

					<a class="navbar-brand" href="${contextRoot }/home">Vilara
						Shopping</a>
				</div>

			</div>

		</nav>

		<!-- Page Content -->
		<div class="content">

			
			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-xs-12 col-md-offset-2 col-md-8">
						<div class="alert alert-danger fade in">${message}</div>
					</div>
				</div>
			</c:if>

			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-xs-12 col-md-offset-2 col-md-8">
						<div class="alert alert-success">${logout}</div>
					</div>
				</div>
			</c:if>

			<div class="row">

				<div class="col-md-offset-3 col-md-6">

					<div class="panel panel-primary">

						<div class="panel-heading">
							<h4>Login</h4>
						</div>

						<div class="panel-body">
							<form action="${contextRoot}/login" method="POST" class="form-horizontal" id="loginForm">
								<div class="form-group">
									<label for="username" class="col-md-4 control-label">Email:
									</label>
									<div class="col-md-8">
										<input type="text" name="username" id="username"
											class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-4 control-label">Password:
									</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password"
											class="form-control" />
									</div>
								</div>


								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <input type="submit" value="Login"
											class="btn btn-primary" />
									</div>
								</div>
							</form>

						</div>
						<div class="panel-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>

					</div>

				</div>

			</div>

		</div>



	</div>

	<!-- /.container -->


	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	<!-- /.container -->
	<script src="${js}/jquery.js"></script>

	<script src="${js}/jquery.validate.js"></script>

	<script src="${js}/bootstrap.min.js"></script>

	<script src="${js}/myapp.js"></script>

</body>

</html>