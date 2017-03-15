<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
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

   
  
  <style>

body {
    background: #d3d3d3;
}
.form_bg {
    background-color: #FFFFFF;
    color: #333333;
    padding:20px;
    border-radius:10px;
    position: relative;
    border:1px solid #fff;
    margin: auto;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    width: 320px;
    height: 280px;
}

.align-center {
    
    text-align:center;
}
  </style>
</head>
<body>
<%@include file="Navigation.jsp" %>
<div class="container">
<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Meilleour</h1>
	               		<hr />
	               	</div>
	            </div> 
    <div class="row">
        <div class="form_bg">
            <form action="${contextRoot}/login" method="post">
                 <h2 class="text-center">Login Page</h2>
                <br/>
                <div class="form-group">
                    <input type="email" class="form-control" id="userid" placeholder="User id">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="pwd" placeholder="Password">
                
                    </div>
                    <br/>
                   <div class="align-center">
                <button type="submit" class="btn btn-default" id="login">Login</button>
                    </div>
            </form>
        </div>
    </div>
</div>
		<%@include file="footer.jsp" %>
</body>
</html>