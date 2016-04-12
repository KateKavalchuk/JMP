function signUp() {
	var formData = new FormData();
	formData.append("userPhoto", document.getElementById("userPhoto").files[0]);
	$.ajax({
		url : '/support/profilePhoto/',
		data : formData,
		processData : false,
		contentType : false,
		type : 'POST',
		success : function(photo) {
			var employee = {};
			employee.firstName = $('#firstName').val();
			employee.lastName = $('#lastName').val();
			employee.contactNumber = $('#contactNumber').val();
			employee.email = $('#email').val();
			employee.password = $('#password').val();
			employee.photo = photo;
			employee.jobPosition = "kdjsfksdf";
			var department = {};
			department.id = 1;
			department.departmentName="1";
			employee.department = department;
			alert(JSON.stringify(employee));
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "/support/signup/",
				data : JSON.stringify(employee),
				success : function(result) {
					alert("Sucess");
				}
			})
		}
	});
}

function signIn() {
	var employee = {
		"email" : $('#email').val(),
		"password" : $('#password').val(),
	}
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : "/support/signin",
		data : JSON.stringify(employee),
		success : function(data) {
			$("#loginForm").attr("action", "/support/" + data);
			$('#loginForm').submit();
		},
		error : function() {
			alert("айайай");
		}
	})
}