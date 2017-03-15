<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
<script type="text/javascript">
	$(function() {
		$('#mytable')
				.DataTable(
						{
							ajax : {
								url : '/shoppingFrontEnd/product1/all/categories',
								dataSrc : ''
							},
							columns : [
									/* {
										data : null,
										mRender : function(data, type, row) {
											return '<img src="/shoppingFrontEnd/resources/Image/'+ row.name +'.jpg" height="50" width="50">';
										}
									}, */
									{
										data : 'name'
									},
									{
										data : 'description'
									},
									{
										data : 'img_url'
									},
									{
										data : 'active'
									},

									{
										data : null,
										mRender : function(data, type, row) {
											//return '<a class="btn btn-primary" href="/NiitProject/product11/userName="'+row.name+'">View Item</a>';
											return "<a class='btn btn-primary' href='/shoppingFrontEnd/product1/all/categories/"+row.id+"'>Edit</a>";
										}
									},
									{
										data : null,
										mRender : function(data, type, row) {
											return '<a class="btn btn-primary" href="'+row.name+'">Delete</a> ';
										}
									} ]
						});
	});
</script>
</head>
<body>
	<%@include file="adminNavigation.jsp"%>
	<div class="container">
	<table id="mytable" class="table table-bordered">
			<thead>
				<!-- 	<th>image name</th> -->
				<!-- 	<th>active</th> -->
				<!-- <th>Img_url</th> -->
				<th>Name</th>
				<th>Description</th>
				<th>imageURL</th>
				<th>active</th>
				<th></th>
				<th></th>
			</thead>
			<tfoot>
				<!-- 	<tr>image name</tr> -->
				<!-- 	<tr>active</tr> -->
				<!-- <th>Img_url</th> -->
				<th>Name</th>
				<th>Description</th>
				<th>imageURL</th>
				<th>active</th>
				<th></th>
				<th></th>
			</tfoot>
		</table>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>