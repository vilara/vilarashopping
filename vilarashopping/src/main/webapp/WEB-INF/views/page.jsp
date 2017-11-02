<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<%@include file="./shared/navbar.jsp"%>

	<!-- Page Content -->
	<div class="content">

		<!-- Load only when user clicks home -->
		<c:if test="${userClickHome == true }">
			<%@include file="home.jsp"%>
		</c:if>


		<!-- Load only when user clicks about -->
		<c:if test="${userClickAbout == true }">
			<%@include file="about.jsp"%>
		</c:if>

		<!-- Load only when user clicks contact -->
		<c:if test="${userClickContact == true }">
			<%@include file="contact.jsp"%>
		</c:if>

		<!-- Load only when user clicks contact -->
		<c:if
			test="${userClickAllProducts == true or userClickCategoryProducts == true }">
			<%@include file="listProducts.jsp"%>
		</c:if>

		<!-- Load only when user clicks show product -->
		<c:if test="${userClickShowProduct == true }">
			<%@include file="singleProduct.jsp"%>

		</c:if>
		<!-- Load only when user clicks show manage products -->
		<c:if test="${userClickManageProducts == true }">
			<%@include file="manageProducts.jsp"%>
		</c:if>
	</div>

	<!-- /.container -->


	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>
	<!-- /.container -->
</div>
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	
	<!-- Datatable basic -->
	<script	src="https://cdn.datatables.net/v/dt/dt-1.10.16/datatables.min.js"></script>
	<!-- Bootbox -->
	<script	src="${js}/bootbox.min.js"></script>
    
	
	
	<script src="${js}/myapp.js"></script>

</body>

</html>