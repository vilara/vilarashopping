<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">Vilara
				Shopping</a>
		</div>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="nav navbar-nav">
				<li id=home"><a href="${contextRoot}/home">Home <span
						class="sr-only">(current)</span>
				</a></li>
				<li id="ablout"><a href="${contextRoot}/about">About</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
				<li id="listProducts"><a
					href="${contextRoot}/show/all/products">View Products</a></li>

				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageProducts"><a
						href="${contextRoot}/manage/products">Manage Products</a></li>
				</security:authorize>
			</ul>


			<ul class="nav navbar-nav navbar-right">

				<security:authorize access="isAnonymous()">

					<li id="register"><a href="${contextRoot}/register">Sign
							Up</a></li>
					<!-- id=register é o nome da pasta onde esta o inicio do web flow signup-flow.xml -->
					<li id="Login"><a href="${contextRoot}/login">Login</a></li>

				</security:authorize>

				<security:authorize access="isAuthenticated()">


					<li class="dropdown" id="userModel"><a
						class="btn btn-default dropdown-toggle" href="javascript:void(0)"
						id="dropdownMenu1" data-toggle="dropdown">
							${userModel.fullName } <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">

							<security:authorize access="hasAuthority('USER')">
								<li><a href="${contextRoot}/cart"> <span
										class="glyphicon glyphicon-shopping-cart"></span>&#160;<span
										class="badge">${userModel.cart.cartLines }</span> - &#8377;
										${userModel.cart.grandTotal }
								</a></li>
								<li role="separator" class="divider"></li>
							</security:authorize>


							<li id="logout"><a href="${contextRoot}/perform-logout">Logout</a></li>
						</ul></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
<script>
		window.userRole = '${userModel.role}';
	</script>
