$(document)
		.ready(
				function() {

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

												if (row.quantity < 1) {

													str += '<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart"></span></strike></a>';
												} else {

													str += '<a href="'
															+ window.contextRoot
															+ '/cart/add/'
															+ data
															+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
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
					$adminProductstable.DataTable({

						lengthMenu : [
								[ 10, 30, 50, -1 ],
								[ '10 Records', '30 Records', '50 records',
										'ALL' ] ],
						pageLength : 5,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [ {
							data : 'id'
						}, {
							data : 'code', 
							bSortable : false,
							mRender : function(data, type, row) { return '<img src="' + window.contextRoot + '/resources/images/' +data + '.jpg" class="adminDataTableImg"/>'; } },
								 {
							data : 'brand'
						}, {
							data : 'name'
						}, {
							data : 'quantity',
							mRender : function(data, type, row) { if (data < 1) {
								 return '<span style="color:red">Out of Stock!</span>'; }
							 return data; 
							}
						}, {
							data : 'unitPrice'
						}, {
							data : 'isActive', 
							bSortable : false,
							mRender : function(data, type, row)
							{ 
							  var str = ''; 
							  str += '<label class="switch">'; 
							  
							  if (data) {
								
								  str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
							}else{
								
								str += '<div class="slider"></div></label>';
							}
							  return str;
							}
						}, {
							data : 'id',
							bSortable : false,
							mRender : function(data, type, row)
							{ 
								var str = ''; 
								  str += '<a href="' + window.contextRoot + '/manage/'+data+'/product" class="btn btn-warning"> <span	class="glyphicon glyphicon-pencil"></span></a>'; 
								return str;
							}
							
						}
						

						], 
						
						initComplete: function(){
							var api = this.api();
							api.$('.switch input[type="checkbox"]')
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
						}
					

					});
				});