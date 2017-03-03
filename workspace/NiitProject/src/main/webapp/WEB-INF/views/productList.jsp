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
   


<link rel="stylesheet" href="${css}/bootstrap-theme.min.css">
<link rel="stylesheet" href="${css}/bootstrap.min.css">
   <script src="${js}/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${js}/bootstrap.min.js"></script>

<script type="text/javascript" src="${js}/jquery.dataTables.js"></script>
   <%@include file="Navigation.jsp" %>
  
  <style>

body {
    background: #d3d3d3;
}

.align-center {
    
    text-align:center;
}
  </style>
  
  <script type="text/javascript">
  $(function(){
		$('#mytable').DataTable({
			ajax: {
		        url: 'NiitProject/product1/all/data',
		        dataSrc: ''
		    },
		    columns: [
		        { data: 'Name' }
		       /* { data: 'Brand' },
		        { data: 'Description' },
		        { data: 'Category' },
		        { data: 'Supplier' },
		        { data: 'Img_url' },
		        { data: 'Price' },
		        { data: 'Quantity' }
		        {data: null,
		        	mRender: function ( data, type, row ) {
		                return '<img src="/NiitProject/resources/Image/'+ row.id +'.jpg" height="50" width="50">';
		            }
		        },
		        {data: null,
		        	mRender: function ( data, type, row ) {
		                return '<a class="btn btn-primary" href="'+data+'">View Item</a> &nbsp;<a class="btn btn-primary" href="'+data+'">Add To Cart</a> ';
		            }	
		        }
		        */
		    ]
		} );
	});
  </script>
</head>
<body>

<table id="mytable" class="table table-bordered">
 	<thead>
 <!-- 	<th>image name</th> -->
 <!-- 	<th>active</th> -->
 	<th>Name</th>
 <!-- <th>Brand</th>
 	<th>Description</th>
 	<th>Category</th>
 	<th>Supplier</th>
 	<th>Img_url</th>
 	<th>Price</th>
 	<th>Quantity</th> -->
 	</thead>
<tfoot>
 <!-- 	<tr>image name</tr> -->
 <!-- 	<tr>active</tr> -->
	<th>Name</th>
 	<!-- <th>Brand</th>
 	<th>Description</th>
 	<th>Category</th>
 	<th>Supplier</th>
 	<th>Img_url</th>
 	<th>Price</th>
 	<th>Quantity</th> -->
 	</tfoot>
  	</table>

<footer>
<div style="position:fixed;bottom:10px;left:10px;background:#4679BC;padding:4px;border-radius:2px;border:1px solid #4679AA"><a href="http://code2care.org" title="more ..." style="padding:6px;text-decoration:none;font-size:12px;color:#fff;letter-spacing: 1.5px;">Meilleour Global Services</a></div>
</footer>
   <!--  <script src="${js}/jquery-1.10.2.js"></script>
    <script src="${js}/bootstrap.min.js"></script> -->
</body>
</html>