<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration Form</title>

<s:url value="/resources/css" var="css" />
<s:url value="/resources/js" var="js" />
<s:url value="/resources/fonts" var="fonts" />


<script src="${js}/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="${css}/bootstrap.min.css">
<link rel="stylesheet" href="${css}/bootstrap-theme.min.css">
<script src="${js}/bootstrap.min.js"></script>

</head>
<body>
	<%@include file="Navigation.jsp"%>


	<div class="container">
		<!-- Form Container -->

		<div class="form-container">

			<h1>Registration Form</h1>
			<form:form method="POST" commandName="user" modelAttribute="user"
				class="form-horizontal">
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
						<label class="col-md-3 control-lable" for="email">email</label>
						<div class="col-md-7">
							<form:input type="text" path="email" id="email"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="email" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="password">password</label>
						<div class="col-md-7">
							<form:input type="password" path="password" id="password"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="password" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="contact">contact</label>
						<div class="col-md-7">
							<form:input type="text" path="contact" id="categoryId"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="contact" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="role">role</label>
						<div class="col-md-7">
							<form:input type="text" path="role" id="role"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="role" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="enabled">enabled</label>
						<div class="col-md-7">
							<form:input type="text" path="enabled" id="enabled"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="enabled" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div style="text-align: center;">
						<input type="submit" value="Register" name="_eventId_submit"
							class="btn btn-primary btn-sm">
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>