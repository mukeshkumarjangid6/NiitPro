<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Result Page</title>
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
		<div class="success">

			<ul class="nav navbar-nav">
				<li><h1>${msg}</h1></li>
				<li class="active"><h3>
						<a class="btn btn-primary" href="${contextRoot}/user/index">Back</a>
					</h3></li>
			</ul>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>