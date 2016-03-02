<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
<script src="<c:url value="/resources/js/index.js" />"></script>
<title>Support center</title>
</head>
<body style="color: #FFF; ">
	<div class="image-form">
		<img src="<c:url value="/resources/images/main.jpeg" />"
			class="main-image" />
	</div>
	<div class="login-form">
		<span id="languages"><a style="color: #FFF; " href="?language=en"><spring:message code="english" /></a>&nbsp&nbsp<a
			href="?language=ru" style="color: #FFF; "><spring:message code="russian" /></a></span>
		<form class="login" id="loginForm">
			<div class="form-group">
				<label for="email"><spring:message code="email" /></label><input
					type="email" class="form-control" id="email" placeholder="Email"
					required="required"
					oninvalid="setCustomValidity('<spring:message
						code="invalid-email" />')"
					onchange="try{setCustomValidity('')}catch(e){}">
			</div>
			<div class="form-group">
				<label for="password"><spring:message code="password" /></label><input
					type="password" class="form-control" id="password"
					placeholder="Password" required="required"
					oninvalid="setCustomValidity('<spring:message
						code="empty-password" />')"
					onchange="try{setCustomValidity('')}catch(e){}">
			</div>
<!-- 			<div class="checkbox"> -->
<%-- 				<label> <input type="checkbox" id="employee"> <spring:message --%>
<%-- 						code="employee" /> --%>
<!-- 				</label> -->
<!-- 			</div> -->
			<button type="button" class="btn btn-default" id="sign-in"
				onclick="signIn()">
				<spring:message code="sign-in" />
			</button>
			<button type="button" class="btn btn-default"
				onclick="location.href = 'resources/redirectpages/registration.jsp'">
				<spring:message code="register" />
			</button>
		</form>
	</div>
</body>
</html>
