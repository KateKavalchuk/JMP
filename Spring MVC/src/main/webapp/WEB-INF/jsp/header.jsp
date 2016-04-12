<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link href="<c:url value="/resources/css/header.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
</head>
<body style="color: #FFF;">
	<span id="languages"><a style="color: #FFF;" href="?language=en"><spring:message
				code="english" /></a>&nbsp&nbsp<a style="color: #FFF;" href="?language=ru"><spring:message
				code="russian" /></a></span>
	<span id="logout"><a  style="color: #FFF;" href="<c:url value="/logout"></c:url>"><spring:message
				code="logout" /></a></span>
</body>
</html>