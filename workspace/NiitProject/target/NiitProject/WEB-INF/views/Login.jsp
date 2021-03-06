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
   <%@include file="Navigation.jsp" %>
  
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

<div class="container">
<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Meilleour</h1>
	               		<hr />
	               	</div>
	            </div> 
    <div class="row">
        <div class="form_bg">
            <form action="#" method="post">
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
<footer>
<div style="position:fixed;bottom:10px;left:10px;background:#4679BC;padding:4px;border-radius:2px;border:1px solid #4679AA"><a href="http://code2care.org" title="more ..." style="padding:6px;text-decoration:none;font-size:12px;color:#fff;letter-spacing: 1.5px;">Meilleour Global Services</a></div>
</footer>
    <script src="${js}/jquery-1.10.2.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
</body>
</html>