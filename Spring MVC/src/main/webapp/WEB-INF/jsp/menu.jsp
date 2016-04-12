<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/menu.css" />" rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="menu-wrapper">
		<div class="profile">
			<img src="/support/profilePhoto/" class="profile-photo" />
			<ul class="list-group">
				<li id="welcome" class="list-group-item"><spring:message
						code="welcome" /><br>${sessionScope.USER.firstName}&nbsp;${sessionScope.USER.lastName}!</li>
			</ul>
		</div>
		<div class="list-group">
			<a href="${contextPath}/request" class="list-group-item"><spring:message
					code="create.request" /></a> <a href="${contextPath}/request"
				class="list-group-item"><spring:message code="kb" /></a> <a
				href="#" class="list-group-item"> <spring:message
					code="assign.to.me.requests" /></a> <a href="${contextPath}/requests/"
				class="list-group-item"> <spring:message
					code="departmnets.request" />
			</a> <a href="#" class="list-group-item"> <spring:message
					code="requests.statistic" /></a>
		</div>
	</div>
</body>
</html>