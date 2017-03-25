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
<script type="text/javascript" src="${js}/bootstrap.min.js"></script>

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
		<h1>${titleMsg}</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Product Image</th>
					<th>Product Name</th>
					<th>Product description</th>
					<th>Product Unit Price</th>
					<th>Purchasing Quantity</th>
					<th>Total Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cartItem" items="${cartitems}">
					<tr>
						<td><img
							src="/shoppingFrontEnd/resources/Image/${cartItem.getProduct().getName()}.jpg"
							height="100" width="100"></td>
						<td>${cartItem.getProduct().getName()}</td>
						<td>${cartItem.getProduct().getDescription()}</td>
						<td>&#8377;&nbsp;${cartItem.getProduct().getPrice()}/-</td>
						<td>${cartItem.sell_quantity}</td>
						<td>&#8377;&nbsp;${cartItem.total_price}/-</td>
						<td><a class="btn btn-primary"
							href="${contextRoot}/user/plusOneProductQuantity/${cartItem.getProduct().getId()}">+</a></td>
						<td><a class="btn btn-primary"
							href="${contextRoot}/user/minusOneProductQuantity/${cartItem.getProduct().getId()}">-</a></td>
						<td><a class="btn btn-primary" href="#">x</a></td>
					</tr>
					<c:set var="cartItemCount"
						value="${cartItem.getCart().getCartItemCount()}" />
					<c:set var="grandTotal"
						value="${cartItem.getCart().getGrandTotal()}" />
				</c:forEach>
			</tbody>
			<tfoot
				style="text-align: right; text-decoration: underline; font-weight: bolder;">
				<tr>
					<c:if test="${cartItemCount > 0}">
						<td>Total Product Counting: ${cartItemCount}</td>
						<td>Grand Total: &#8377;&nbsp;${grandTotal}/-</td>
						<td><a class="btn btn-primary" href="${contextRoot}/checkoutData">CheckOut</a></td>
					</c:if>
				</tr>
			</tfoot>
		</table>

		<%@include file="../footer.jsp"%></div>
	<!--  <script src="${js}/jquery-1.10.2.js"></script>
    <script src="${js}/bootstrap.min.js"></script> -->
</body>
</html>