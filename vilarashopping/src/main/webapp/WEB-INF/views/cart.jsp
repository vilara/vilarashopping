<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="availableCount" value="${userModel.cart.cartLines}" />
<div class="container">
	<c:if test="${not empty message }">

		<div class="alert alert-info">
			<h3 class="text-center">${message }</h3>
		</div>


	</c:if>

	<c:choose>


		<c:when test="${not empty cartLines }">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 50%">Product</th>
						<th style="width: 10%">Price</th>
						<th style="width: 8%">Quantity</th>
						<th style="width: 22%" class="text-center">Subtotal</th>
						<th style="width: 10%"></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${cartLines }" var="cartline">

						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs">
										<img src="${images}/${cartline.product.code}.jpg"
											alt="${cartline.product.name}" class="img-responsive cartImg" />
									</div>
									<div class="col-sm-10">
										<h4 class="nomargin">${cartline.product.name}
											<c:if test="${cartline.available == false}">

												<strong class="unavailable">(Not Available)</strong>

											</c:if>
										</h4>
										<p>Brand - ${cartline.product.name}</p>
										<p>Description - ${cartline.product.description}</p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; ${cartline.buyingPrice}</td>
							<td data-th="Quantity"><input type="number"
								id="count_${cartline.id}" min="1" max="3"
								class="form-control text-center"
								value="${cartline.productCount }"></td>
							<td data-th="Subtotal" class="text-center">&#8377;
								${cartline.total }</td>
							<td class="actions" data-th="">
								<button type="button" name="refreshCart" value="${cartline.id }"
									class="btn btn-info btn-sm">
									<span class="glyphicon glyphicon-refresh"></span>
								</button>
								
								<a href="${contextRoot }/cart/${cartline.id}/delete"  class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</a>
							</td>
						</tr>


					</c:forEach>

				</tbody>
				<tfoot>
					<tr class="visible-xs">
						<td class="text-center"><strong>&#8377;
								${userModel.cart.grandTotal}</strong></td>
					</tr>
					<tr>
						<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><span
								class="glyphicon glyphicon-chevron-left"></span> Continue
								Shopping</a></td>
						<td colspan="2" class="hidden-xs"></td>
						<td class="hidden-xs text-center"><strong>Total
								&#8377; ${userModel.cart.grandTotal}</strong></td>
						<c:choose>
							<c:when test="${availableCount != 0}">
								<td><a href="${contextRoot}/cart/validate" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
							</c:when>							
							<c:otherwise>
								<td><a href="javascript:void(0)" class="btn btn-success btn-block disabled"><strike>Checkout <span class="glyphicon glyphicon-chevron-right"></span></strike></a></td>
							</c:otherwise>
						</c:choose>	
					</tr>
				</tfoot>
			</table>

		</c:when>
		<c:otherwise>
			<div class="jumbotron">

				<h3 class="text-center">Your Cart is Empty!</h3>

			</div>
		</c:otherwise>
	</c:choose>



</div>