<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/layout.css" />"
	rel="stylesheet">
<title><tiles:insertAttribute name="title" ignore="true" />Support
	Center</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.USER}">
			<script type="text/javascript">
				window.location = "/support/";
			</script>
		</c:when>
		<c:otherwise>
			<div class="header">
				<tiles:insertAttribute name="header" />
			</div>
			<div class="menu">
				<tiles:insertAttribute name="menu" />
			</div>
			<div class="content">
				<tiles:insertAttribute name="content" />
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>
