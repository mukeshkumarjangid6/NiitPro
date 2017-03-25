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
<title>Admin</title>
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
</head>
<body>
	<%@include file="adminNavigation.jsp"%>
	<div class="container">
		<!-- Form Container -->

		<div class="form-container">
			<h1>Product Delete or Update Form</h1>
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
						<label class="col-md-3 control-lable" for="id">id</label>
						<div class="col-md-7">
							<form:input type="text" path="id" id="id" readonly="true"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="id" class="help-inline" />
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
							<label class="col-md-3 control-lable" for="productImg_url">productImg_url</label>
							<div class="col-md-7">
								<form:input type="text" path="productImg_url"
									id="productImg_url" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="productImg_url" class="help-inline" />
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
					<%-- <div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="ActiveIs">ActiveIs</label>
						<div class="col-md-7" class="form-control input-sm">
							<form:radiobuttons path="ActiveIs" items="${ActiveIs}" />
							<div class="has-error">
								<form:errors path="ActiveIs" class="help-inline" />
							</div>
						</div>
					</div>
				</div> --%>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-4 control-lable" for="imageUrl">Upload
								Product Image</label>
							<div class="col-md-7">
								<form:input type="file" path="file" id="imageUrl"
									class="form-control filestyle" />
								<div class="has-error">
									<form:errors path="file" class="help-inline" style="color:red" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Update" name="action"
								class="btn btn-primary btn-sm"> <input type="submit"
								name="action" value="Delete" class="btn btn-primary btn-sm">
						</div>
					</div>
			</form:form>

		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>