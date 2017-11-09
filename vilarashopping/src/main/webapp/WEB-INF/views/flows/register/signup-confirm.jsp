<%@include file="../shared/flows-header.jsp"%>

<div class="row">

	<!-- Column to display the personal details  -->
	<div class="col-sm-6">

		<div class="panel panel-primary">

			<div class="panel-heading">
				<h4>Personal Details</h4>
			</div>

			<div class="panel-body">
			</div>

			<div class="panel-footer">
			<a href="${flowExecutionUrl }&_eventId_personal" class="btn btn-primary">Personal Edit</a>
			</div>


		</div>


	</div>


	<!-- Column to display the address  -->
	<div class="col-sm-6">

		<div class="panel panel-primary">

			<div class="panel-heading">
				<h4>Personal Details</h4>
			</div>

			<div class="panel-body">
			</div>

			<div class="panel-footer">
				<a href="${flowExecutionUrl }&_eventId_billing" class="btn btn-primary">Biling Edit</a>
			</div>


		</div>


	</div>
	
	
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">
			<div class="text-center">
				<a href="${flowExecutionUrl }&_eventId_success" class="btn btn-primary">Confirm</a>
			</div>
		</div>
	</div>


</div>

<%@include file="../shared/flows-footer.jsp"%>
