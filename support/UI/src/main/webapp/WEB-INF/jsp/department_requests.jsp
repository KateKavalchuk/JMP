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
<body>
	<div style="margin-top: 2%; margin-left: 10%; height: 70%; width: 80%;">
		<h3 style="color: black; margin-bottom: 2%; margin-left: 20%;">
			<spring:message code="departmnets.request" />
		
		</h3>
	</div>
</body>
</html>