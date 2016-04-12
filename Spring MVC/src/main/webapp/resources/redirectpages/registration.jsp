<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link href="<c:url value="/resources/css/registration.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery/jquery.form.js" />"></script>
<script src="<c:url value="/resources/js/index.js" />"></script>
</head>
<body>
	<div class="image-form">
		<div class="login-form">
			<div class="form-group">
				<div class="form-group">
					<label for="firstName"><spring:message code="first-name" /></label><input
						type="text" class="form-control" id="firstName"
						placeholder="First name" required="required"
						oninvalid="setCustomValidity('<spring:message
						code="empty-first-name" />')"
						onchange="try{setCustomValidity('')}catch(e){}">
				</div>
				<div class="form-group">
					<label for="lastName"><spring:message code="last-name" /></label><input
						type="text" class="form-control" id="lastName"
						placeholder="Last name" required="required"
						oninvalid="setCustomValidity('<spring:message
						code="empty-last-name" />')"
						onchange="try{setCustomValidity('')}catch(e){}">
				</div>
				<div class="form-group">
					<label for="contactNumber"><spring:message
							code="contact-number" /></label><input type="tel" class="form-control"
						id="contactNumber" placeholder="Contact number"
						required="required"
						oninvalid="setCustomValidity('<spring:message
						code="empty-contact-number" />')"
						onchange="try{setCustomValidity('')}catch(e){}">
				</div>
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
			<div class="form-group">
				<label for="password"><spring:message code="password" /></label><input
					type="password" class="form-control" id="password"
					placeholder="Password" required="required"
					oninvalid="setCustomValidity('<spring:message
						code="empty-password" />')"
					onchange="try{setCustomValidity('')}catch(e){}">
			</div>
			<div class="form-group">
				<div class=" fileUpload btn btn-default">
					<label><spring:message code="photo" /></label> <input name="photo"
						type="file" placeholder="Photo" class="upload form-control"
						id="userPhoto" />
				</div>
			</div>
			<button type="button" class="btn btn-default" id="register"
				onclick="signUp()">
				<spring:message code="register" />
			</button>
		</div>
	</div>
</body>
</html>
