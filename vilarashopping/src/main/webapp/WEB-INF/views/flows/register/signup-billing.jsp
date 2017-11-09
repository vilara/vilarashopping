
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../shared/flows-header.jsp" %>

			<div class="container">

				<div class="row">


		<div class="col-md-offset-3 col-md-6">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Address Billing</h4>

				</div>

				<div class="panel panel-body">

					<!--  Form Elements -->
					<sf:form class="form-horizontal" enctype="multipart/form-data"
						id="billingForm" method="POST" modelAttribute="billing">

						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line 1
								</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" id="addressLineOne"
									placeholder="Address Line 1" class="form-control" />
								<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLinetwo">Address Line 2
								</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLinetwo" id="addressLinetwo"
									placeholder="Address Line 2" class="form-control" />
								<sf:errors path="addressLinetwo" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="city">City
								</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" id="city"
									placeholder="City" class="form-control" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" id="state"
									placeholder="State" class="form-control" />
								<sf:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" id="country"
									placeholder="Country" class="form-control" />
								<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" id="postalCode"
									placeholder="Postal Code" class="form-control" />
								<sf:errors path="postalCode" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-3 col-md-10">
								<button type="submit" class="btn btn-primary" name="_eventId_personal"><span class="glyphicon glyphicon-chevron-left"></span>Previous</button>
								<button type="submit" class="btn btn-primary" name="_eventId_confirm">Next<span class="glyphicon glyphicon-chevron-right"></span></button>
							</div>
						</div>


					</sf:form>
				</div>
			</div>

		</div>

	</div>

			</div>
			
<%@include file="../shared/flows-footer.jsp" %>		