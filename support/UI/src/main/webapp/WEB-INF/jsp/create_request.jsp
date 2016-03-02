<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
			<spring:message code="create.request" />
		</h3>
		<form:form action="request" method="post" commandName="requestForm">
			<table style="width: 100%; color: black; font-size: 20px;"">
				<tr>
					<td style="width: 15%;"><label>Название:</label></td>
					<td><form:input path="name" cssClass="form-control" /></td>
				</tr>
				<tr>
					<td style="width: 15%;"><label>Описание:</label></td>
					<td><form:textarea path="description" cssClass="form-control" /></td>
				</tr>
			</table>

			<br>

			<form:select path="priority.id" cssClass="dropdown-menu">
				<c:forEach items="${priorities}" var="priority">
					<form:option label="${priority.priority}" value="${priority.id}"></form:option>
				</c:forEach>
			</form:select>
			<input type="submit" class="btn btn-default"
				value="<spring:message code="create.request" />">
		</form:form>
	</div>
</body>
</html>