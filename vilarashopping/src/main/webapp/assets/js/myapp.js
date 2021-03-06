$(document)
		.ready(
				function() {

					// validation code for Login

					var $loginForm = $('#loginForm');

					if ($loginForm.length) {

						$loginForm.validate({

							rules : {

								username : {
									required : true,
									email : true
								},

								password : {
									required : true
								}
							},

							messages : {
								username : {
									required : 'Please enter the username',
									email : 'Please enter valid email address'
								},

								password : {
									required : 'Please  enter the password'
								}
							},

							errorElement : 'em',
							errorPlacement : function(error, element) {
								// add the class of help-block
								error.addClass('help-block');
								// add the error element after the input element
								error.insertAfter(element);
							}

						});

					}

					// -------final validação login

					// -------to tackle the csrf token usado para o security
					// springer autorizar o ajax dos codigos abaixo

					var token = $('meta[name="_csrf"]').attr('content');
					var header = $('meta[name="_csrf_header"]').attr('content');

					if (token.length > 0 && header.length > 0) {
						// set the token header for the ajax request
						$(document).ajaxSend(function(e, xhr, options) {

							xhr.setRequestHeader(header, token);
						});
					}

					// ------ inicio code for JQuery dataTable

					var jsonUrl = window.contextRoot
							+ '/json/data/all/products';
					var $table = $('#productListTable');

					var jsonUrl = '';
					if (window.categoryId == '') {
						jsonUrl = window.contextRoot
								+ '/json/data/all/products';
					} else {
						jsonUrl = window.contextRoot + '/json/data/category/'
								+ window.categoryId + '/products';
					}

					$table
							.DataTable({

								lengthMenu : [
										[ 3, 5, 10, -1 ],
										[ '3 Records', '5 Records',
												'10 records', 'ALL' ] ],
								pageLength : 5,
								ajax : {
									url : jsonUrl,
									dataSrc : ''
								},
								columns : [
										{
											data : 'code',
											bSortable : false,
											mRender : function(data, type, row) {
												return '<img src="'
														+ window.contextRoot
														+ '/resources/images/'
														+ data
														+ '.jpg" class="dataTbleImg"/>';
											}
										},
										{
											data : 'name'
										},
										{
											data : 'brand'
										},
										{
											data : 'unitPrice',
											mRender : function(data, type, row) {
												return '&#8377; ' + data
											}
										},
										{
											data : 'quantity',
											mRender : function(data, type, row) {
												if (data < 1) {
													return '<span style="color:red">Out of Stock!</span>';
												}
												return data;
											}
										},
										{
											data : 'id',
											bSortable : false,
											mRender : function(data, type, row) {

												var str = '';
												str += '<a href="'
														+ window.contextRoot
														+ '/show/'
														+ data
														+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>  ';
												
												if(userRole=='ADMIN'){
													str += '<a href="'
														+ window.contextRoot
														+ '/manage/'
														+ data
														+ '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';

												}else{
													
													if (row.quantity < 1) {

														str += '<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart"></span></strike></a>';
													} else {

													
														str += '<a href="'
																+ window.contextRoot
																+ '/cart/add/'
																+ data
																+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
													}	
												}
												

												return str;
											}
										} ],

								/* Materila Design */
								columnDefs : [ {
									targets : [ 0, 1, 2 ],
									className : 'mdl-data-table__cell--non-numeric'
								} ]

							});

					$(function() {
						switch (menu) {
						case 'About Us':
							$('#about').addClass('active');
							break;

						case 'Contact':
							$('#contact').addClass('active');
							break;

						case 'Home':
							$('#home').addClass('active');
							break;

						case 'All Products':
							$('#listProducts').addClass('active');
							break;

						case 'Manage Products':
							$('#manageProducts').addClass('active');
							break;
							
						case 'User Cart':
							$('#userCart').addClass('active');
							break;

						default:
							$('#listProducts').addClass('active');
							$('#a_' + menu).addClass('active');
							break;
						}

					});

					// dismissing the alert after 3 seconds

					var $alert = $('.alert');

					if ($alert.length) {
						setTimeout(function() {
							$alert.fadeOut('slow')
						}, 3000)

					}

					// ---------------------

					$('.switch input[type="checkbox"]')
							.on(
									'change',
									function() {

										var checked = $(checkbox).prop(
												'checked');
										var checkbox = $(this);
										var dMsg = (checked) ? 'You want to activete the product'
												: "You want to desactive the product";

										var value = checkbox.prop('value');

										bootbox
												.confirm({
													size : 'medium',
													title : 'Product actvation & desactivation',
													message : dMsg,
													callback : function(
															confirmed) {
														if (confirmed) {
															console.log(value);
															bootbox
																	.alert({
																		size : 'medium',
																		title : 'Information',
																		message : 'You are going to perform operation on product'
																				+ value
																	});
														} else {
															checkbox.prop(
																	'checked',
																	!checked)
														}
													}

												});
									});

					// -------
					// Datable for admin
					// -------

					var $adminProductstable = $('#adminProductsTable');
					var jsonUrl = window.contextRoot
							+ '/json/data/admin/all/products';
					$adminProductstable
							.DataTable({

								lengthMenu : [
										[ 10, 30, 50, -1 ],
										[ '10 Records', '30 Records',
												'50 records', 'ALL' ] ],
								pageLength : 5,
								ajax : {
									url : jsonUrl,
									dataSrc : ''
								},
								columns : [
										{
											data : 'id'
										},
										{
											data : 'code',
											bSortable : false,
											mRender : function(data, type, row) {
												return '<img src="'
														+ window.contextRoot
														+ '/resources/images/'
														+ data
														+ '.jpg" class="adminDataTableImg"/>';
											}
										},
										{
											data : 'brand'
										},
										{
											data : 'name'
										},
										{
											data : 'quantity',
											mRender : function(data, type, row) {
												if (data < 1) {
													return '<span style="color:red">Out of Stock!</span>';
												}
												return data;
											}
										},
										{
											data : 'unitPrice'
										},
										{
											data : 'isActive',
											bSortable : false,
											mRender : function(data, type, row) {
												var str = '';
												str += '<label class="switch">';

												if (data) {

													str += '<input id="active" type="checkbox" checked="checked" value="'
															+ row.id + '" />';
												} else {
													str += '<input id="active" type="checkbox" value="'
															+ row.id + '" />';
												}
												str += '<div class="slider"></div></label>';

												return str;
											}
										},
										{
											data : 'id',
											bSortable : false,
											mRender : function(data, type, row) {
												var str = '';
												str += '<a href="'
														+ window.contextRoot
														+ '/manage/'
														+ data
														+ '/product" class="btn btn-warning"> <span	class="glyphicon glyphicon-pencil"></span></a>';
												return str;
											}

										}

								],

								initComplete : function() {
									var api = this.api();
									api
											.$('.switch input[type="checkbox"]')
											.on(
													'change',
													function() {

														var checked = $(
																"#active")
																.prop('checked');
														var checkbox = $(this);
														var dMsg = (checked) ? 'You want to activete the product'
																: "You want to desactive the product";
														var value = checkbox
																.prop('value');

														bootbox
																.confirm({
																	size : 'medium',
																	title : 'Product actvation & desactivation',
																	message : dMsg,
																	callback : function(
																			confirmed) {
																		if (confirmed) {
																			console
																					.log(value);

																			var activationUrl = window.contextRoot
																					+ '/manage/product/'
																					+ value
																					+ '/activation';

																			$
																					.post(
																							activationUrl,
																							function(
																									data) {
																								bootbox
																										.alert({
																											size : 'medium',
																											title : 'Information',
																											message : data
																										});
																							});

																		} else {
																			checkbox
																					.prop(
																							'checked',
																							!checked)
																		}
																	}

																});

													});
								}

							});

					// --------------------------------
					// validation code for category

					var $categoryForm = $('#categoryForm');

					if ($categoryForm.length) {
						$categoryForm
								.validate({

									rules : {

										name : {
											required : true,
											minlength : 2
										},

										description : {
											required : true,
											minlength : 2
										}
									},

									messages : {
										name : {
											required : 'Please add the category name',
											minlength : 'The category name should not be less than 2 characters'
										},

										description : {
											required : 'Please add the category descripton',
											minlength : 'The category name should not be less than 2 characters'
										}
									},

									errorElement : 'em',
									errorPlacement : function(error, element) {
										// add the class of help-block
										error.addClass('help-block');
										// add the error element after the input
										// element
										error.insertAfter(element);
									}

								});

					}
					
					//----------------------
					// handling the click envent of refresh cart button
					$('button[name="refreshCart"]').click(function(){
						// fetch the cart line id
						var cartLineId = $(this).attr('value');
						
						var countElement = $('#count_' + cartLineId);
						
						var originalCount = countElement.attr('value');
						
						var currentCount = countElement.val();
						
						// work only when count has changed
						
						if (currentCount !== originalCount) {
							
						if (currentCount < 1 || currentCount > 3) {
							// reverting back to the original count
							// user has given value below 1 and above 3
							countElement.val(originalCount);
							bootbox.alert({
								size: 'medium',
								title: 'Erro',
								message: 'Product count should be minimum 1 and maximum 3!'
							});
						}else{
							
							var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
							// forward it to the controller
							window.location.href = updateUrl;
						}
						
						
						}
					});
					
					//----------------------

				});