<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Basic Bootstrap Template</title>
<s:url value="/resources/css" var="css" />
<s:url value="/resources/js" var="js" />
<s:url value="/resources/fonts" var="fonts" />

<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/bootstrap-theme.min.css">

<script src="${js}/jquery-1.10.2.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>
<style>
body {
	background: #d3d3d3;
}

.align-center {
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		$('#mytable')
				.DataTable(
						{
							ajax : {
								url : '/shoppingFrontEnd/product1/all/data',
								dataSrc : ''
							},
							columns : [
									{
										data : 'name',
										mRender : function(data, type, row) {
											return '<img src="/shoppingFrontEnd/resources/Image/'+ data +'.jpg" height="50" width="50">';
										}
									},
									{
										data : 'name'
									},
									{
										data : 'brand'
									},
									{
										data : 'description'
									},
									{
										data : 'supplier'
									},
									{
										data : 'price'
									},
									{
										data : 'quantity'
									},

									{
										data : null,
										mRender : function(data, type, row) {
											//return '<a class="btn btn-primary" href="/NiitProject/product11/userName="'+row.name+'">View Item</a>';
											return "<a class='btn btn-primary' href='/shoppingFrontEnd/deleteorUpdate/"+row.id+"'>Edit</a>";
										}
									},
									{
										data : null,
										mRender : function(data, type, row) {
											return "<a class='btn btn-primary' href='/shoppingFrontEnd/deleteorUpdate/"+row.id+"'>Delete</a>";
										}
									} ]
						});
	});
</script>
</head>
<body>
	<%@include file="adminNavigation.jsp"%>
	<div class="container">
		<!-- Form Container -->

		<div class="form-container">

			<h1>Product Adding Form</h1>
			<form:form method="POST" action="${contextRoot}/productData.do"
				commandName="product" modelAttribute="product"
				class="form-horizontal" enctype="multipart/form-data">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="brand">brand</label>
						<div class="col-md-7">
							<form:input type="text" path="brand" id="brand"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="brand" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="name">name</label>
						<div class="col-md-7">
							<form:input type="text" path="name" id="name"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="name" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="description">description</label>
						<div class="col-md-7">
							<form:input type="text" path="description" id="description"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="description" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="supplier">supplier</label>
						<div class="col-md-7">
							<form:input type="text" path="supplier" id="supplier"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="supplier" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="price">price</label>
						<div class="col-md-7">
							<form:input type="text" path="price" id="price"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="price" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="quantity">quantity</label>
						<div class="col-md-7">
							<form:input type="text" path="quantity" id="quantity"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="quantity" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="ActiveIs">ActiveIs</label>
						<div class="col-md-7">
							<form:input type="text" path="ActiveIs" id="ActiveIs"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="ActiveIs" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-4 control-lable" for="file">Upload
							Product Image</label>
						<div class="col-md-7">
							<form:input type="file" path="file" id="file"
								class="form-control filestyle" />
							<div class="has-error">
								<form:errors path="file" class="help-inline" style="color:red" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-actions floatRight">
						<input type="submit" value="Add" name="action"
							class="btn btn-primary btn-sm">
					</div>
				</div>
			</form:form>

		</div>

		<table id="mytable" class="table table-bordered">
			<thead>
				<!-- 	<th>image name</th> -->
				<!-- 	<th>active</th> -->
				<th>Img_url</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Description</th>
				<th>Supplier</th>
				<th>Price</th>
				<th>Quantity</th>
				<th></th>
				<th></th>
			</thead>
			<tfoot>
				<!-- 	<tr>image name</tr> -->
				<!-- 	<tr>active</tr> -->
				<th>Img_url</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Description</th>
				<th>Supplier</th>
				<th>Price</th>
				<th>Quantity</th>
				<th></th>
				<th></th>
			</tfoot>
		</table>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>