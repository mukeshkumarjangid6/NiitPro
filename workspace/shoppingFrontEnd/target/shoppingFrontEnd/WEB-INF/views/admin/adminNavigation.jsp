<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Meilleour Global Services</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="${contextRoot}/admin/adminIndex">Add
					Product</a></li>
			<%-- <li><a href="${contextRoot}/admin/categories">Add Category</a></li> --%>

			<li><security:authorize access="isAuthenticated()">

					<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
				</security:authorize></li>
		</ul>
	</div>
</nav>