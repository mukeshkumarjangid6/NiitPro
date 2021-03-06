<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Basic Bootstrap Template</title>
    <s:url value="/resources/css" var="css"/>
<s:url value="/resources/js" var="js"/>
<s:url value="/resources/fonts" var="fonts"/>


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
    
    text-align:center;
}
  </style>
</head>
<body>
<%@include file="Navigation.jsp" %>

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
 	<td>Category</td>
 	<td>Supplier</td>
 	<td>Price</td>
 	<td>Quantity</td>
 	</tr>
 	<tr>
 <td><img src='/NiitProject/resources/Image/${msg.name}.jpg' height="200" width="200"></td>
 	<td>${msg.name}</td>
 <td>${msg.brand}</td>
 	<td>${msg.description}</td>
 	<td>${msg.category}</td>
 	<td>${msg.supplier}</td>
 	<td>${msg.price}</td>
 	<td>${msg.quantity}</td>
 	</tr>
 	</tbody>
</table>

<footer>
<div style="position:fixed;bottom:10px;left:10px;background:#4679BC;padding:4px;border-radius:2px;border:1px solid #4679AA"><a href="http://code2care.org" title="more ..." style="padding:6px;text-decoration:none;font-size:12px;color:#fff;letter-spacing: 1.5px;">Meilleour Global Services</a></div>
</footer>
   </div> 
</body>
</html>