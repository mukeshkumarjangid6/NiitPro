<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<%-- 		<a href="${contextRoot}&_eventId_home">Home</a><br /> --%>
			<br />
			<sf:form modelAttribute="user">
				<sf:label path="name">name:</sf:label>${user.name}
					<br />
				<br />
				<sf:label path="email">Email Id:</sf:label>${user.email}
					<br />
				<br />
				<sf:label path="contact">contact :</sf:label>${user.contact}
					<br />
				<br />
				<sf:label path="role">role :</sf:label>${user.role}
					<br />
				<br />
				<sf:label path="enabled">enabled :</sf:label>${user.enabled}
					<br />
				<br />
				<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
				<input name="_eventId_edit" type="submit" value="Edit" />
				<input name="_eventId_submit" type="submit" value="Confirm Details" />
				<br />
			</sf:form>
		</fieldset>
	</div>
</body>
</html>