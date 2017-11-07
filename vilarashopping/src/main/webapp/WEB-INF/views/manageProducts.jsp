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
					<sf:form class="form-horizontal" enctype="multipart/form-data"
						modelAttribute="product" action="${contextRoot }/manage/products"
						method="POST">

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								product Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								brand Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								description</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description product" class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								unit price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								the quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Enter the quantity" class="form-control" />
							</div>
						</div>
						<!-- File element -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />


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

						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
						<sf:hidden path="isActive" />

					</sf:form>
				</div>
			</div>

		</div>

	</div>

	<div class="row">


		<div class="col-xs-12">
			<h3>Available</h3>
			<hr />
		</div>

		<div class="col-xs-12">
			<div style="overflow: auto">

				<table id="adminProductsTable"
					class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
							<th>Img</th>
							<th>Brand</th>
							<th>Name</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>

						</tr>

					</thead>

					<%-- 		<tbody>
						<tr>
							<td>4</td>
							<td><img class="adminDataTableImg"
								src="${contextRoot }.resources/images/PRODCB0596960E.jpg"
								alt="Macbook Pro" /></td>
							<td>Macbook Pro</td>
							<td>3</td>
							<td>&#8377; 54000.00</td>
							<td>
								<!-- toggle Switch --> <label class="switch"> <input
									type="checkbox" checked="checked" id="teste" value="4" />
									<div class="slider"></div>
							</label>
							</td>
							<td><a href="${contextRoot }/manage/4/product"
								class="btn btn-warning"> <span
									class="glyphicon glyphicon-pencil"></span>
							</a></td>
						</tr>

						<tr>
							<td>4</td>
							<td><img class="adminDataTableImg"
								src="${contextRoot }.resources/images/PRODCB0596960E.jpg"
								alt="Macbook Pro" /></td>
							<td>Macbook Pro</td>
							<td>3</td>
							<td>&#8377; 54000.00</td>
							<td>
								<!-- toggle Switch --> <label class="switch"> <input
									type="checkbox" value="4" />
									<div class="slider"></div>
							</label>
							</td>
							<td><a href="${contextRoot }/manage/4/product"
								class="btn btn-warning"> <span
									class="glyphicon glyphicon-pencil"></span>
							</a></td>
						</tr>

					</tbody> --%>

					<tfoot>
						<th>Id</th>
						<th>Img</th>
						<th>Brand</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tfoot>
				</table>
			</div>


		</div>

	</div>