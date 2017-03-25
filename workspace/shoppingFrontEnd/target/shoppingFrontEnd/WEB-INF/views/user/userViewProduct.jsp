<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
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

<script src="${js}/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/bootstrap-theme.min.css">
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
	<%@include file="userNavigation.jsp"%>

	<div class="container">
		<table id="mytableProduct" class="table table-bordered">
			<tbody>
				<!-- 	<th>image name</th> -->
				<!-- 	<th>active</th> -->
				<tr>
					<td></td>
					<td>Name</td>
					<td>Brand</td>
					<td>Description</td>
					<!-- <td>Category</td> -->
					<td>Supplier</td>
					<td>Price</td>
					<!-- <td>Quantity</td> -->
				</tr>
				<tr>
					<td><img
						src='/shoppingFrontEnd/resources/Image/${msg.name}.jpg'
						height="200" width="200"></td>
					<td>${msg.name}</td>
					<td>${msg.brand}</td>
					<td>${msg.description}</td>
					<%-- <td>${msg.category}</td> --%>
					<td>${msg.supplier}</td>
					<td>&#8377;&nbsp;${msg.price}/-</td>
					<%-- <td>${msg.quantity}</td> --%>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><a class="btn btn-primary"
						href="${contextRoot}/user/index">Back</a></td>
					<td><a class="btn btn-primary"
						href="${contextRoot}/user/addProductToCartItem/${msg.id}">Add
							To Cart</a></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<%@include file="../footer.jsp"%>
	</div>
</body>
</html>