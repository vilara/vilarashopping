<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">

	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>

			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>

				</div>

				<div class="panel panel-body">
					<!--  Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot }/manage/products" method="POST">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								product Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product name" class="form-control" />
								<em class="help-block">Please enter product name!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand" class="form-control" />
								<em class="help-block">Please enter brand!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description product" class="form-control"></sf:textarea>
								<em class="help-block">Please enter the description
									products!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								unit price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit price" class="form-control" />
								<em class="help-block">Please enter the unit price!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quatity">Enter
								the quatity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quatity" id="quatity"
									placeholder="Enter the quatity" class="form-control" />
								<em class="help-block">Please enter the quatity!</em>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<%-- <sf:select class="form-control" path="categoryId" id="categoryId" items="${categories}"
								itemLabel="name"
								itemValue="id" /> --%>
								
							
							</div>
						</div>




						<div class="form-group">

							<div class="col-md-offset-4 col-md-4">
								<input type="submit" name="submit" id="Submit" value="Submit"
									class="form-control btn-primary" />
							</div>
						</div>
						<!-- Hidden fields for products -->
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<%-- <sf:hidden path="supplierId" />
						<sf:hidden path="categoryId" /> --%>
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
						<sf:hidden path="isActive" />

					</sf:form>
				</div>
			</div>

		</div>

	</div>
</div>