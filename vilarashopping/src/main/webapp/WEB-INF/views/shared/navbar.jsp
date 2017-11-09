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
				<li id=home"><a href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li id="ablout"><a href="${contextRoot}/about">About</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
				<li id="listProducts"><a href="${contextRoot}/show/all/products">View Products</a></li>
				<li id="manageProducts"><a href="${contextRoot}/manage/products">Manage Products</a></li>
			</ul>
			
			
			<ul class="nav navbar-nav navbar-right">
			
			<li id="register"><a href="${contextRoot}/register">Sign Up</a></li><!-- id=register é o nome da pasta onde esta o inicio do web flow signup-flow.xml -->
			<li id="Login"><a href="${contextRoot}/login">Login</a></li>
			
			</ul>
		</div>
	</div>
</nav>
