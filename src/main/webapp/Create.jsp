<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add a User Form</title>

<!-- Meta -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico">

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="Template/assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="Template/assets/css/style.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet"
	href="Template/assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="Template/assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="Template/assets/plugins/sky-forms/version-2.0.1/css/custom-sky-forms.css">
	<link rel="stylesheet" href="Template/assets/plugins/ladda-buttons/css/custom-lada-btn.css">
    	<link rel="stylesheet" href="Template/assets/css/plugins/hover-effect/css/custom-hover-effects.css">  
<!--[if lt IE 9]>
        <link rel="stylesheet" href="assets/plugins/sky-forms/version-2.0.1/css/sky-forms-ie8.css">
    <![endif]-->
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- CSS Theme -->
<link rel="stylesheet" href="Template/assets/css/themes/orange.css"
	id="style_color">

<!-- CSS Customization -->
<link rel="stylesheet" href="Template/assets/css/custom.css">

 	<% 
    	if (application.getAttribute("userRole") == null) {
    		RequestDispatcher next = request.getRequestDispatcher("Error.jsp");
    		next.forward(request, response);
    	} 
    	int userNumber = (int) application.getAttribute("userRole");
    	if (userNumber != 2) {
    		RequestDispatcher next = request.getRequestDispatcher("Error.jsp");
    		next.forward(request, response);
    	} 
    %>

</head>

<body>

	<script>
		function validateEmail(email) {

			var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

			if (re.test(email)) {

				document.getElementById('email');
				document.getElementById('emailError').style.display = "none";

				return true;

			} else {

				alert("Please Enter A Valid Email.");

				return false;
			}
		}
		//Email function
		function validateFormEmail() {

			var error = 0;

			// Validate email
			if (!validateEmail(document.getElementById('email').value)) {

				document.getElementById('emailError').style.display = "block";

				error++;
			}

			// Blocks submission if errors exist
			if (error > 0) {

				return false;
			}
		}
	</script>
	<!-- <h2>Associate Form</h2>
  <button type="button" name="Home" class="btn btn-u rounded-3x btn-u-orange"
                        onclick="window.location.href='Associate.jsp'">Home</button></p> -->

	<!--=== Breadcrumbs ===-->
	<div class="breadcrumbs">
		<div class="container">
			<h1 class="pull-left">
				<b>Add a User Form</b>
			</h1>
			<ul class="pull-right breadcrumb">
				<li><a href="Admin.jsp">Home</a></li>
				<li><a href="/FrontDeskAssist/AdminController?behavior=listAssociates">Admin
						Dashboard</a></li>
				  <li><a href="Update.jsp">Update Associate</a></li>
				<li><a href="Search.jsp">Search for an Associate</a></li> 
				<li> <a href="LogOut.jsp">Log Out</a></li>
			</ul>
		</div>
	</div>
	<!-- <div id="Associate">
		<form action="AdminController" method="POST">
			<h4>Please enter associate info.</h4>
			<ul>
				<li>Username: <input type="text" name="username" /></li>
				<li>First Name: <input type="text" name="fName" value="" /></li>
				<li>Last Name: <input type="text" name="lName" /></li>
				<li>Email: <input type="text" name="email" value="" /></li>
				<li><input type="hidden" name="crudMethod" value="add"></li>
				<li><input type="submit" value="Submit" /></li>
			</ul>
		</form>
	</div> -->
	<div class="container">
		<div class="row margin-bottom-30">
			<div class="col-md-8 mb-margin-bottom-30">
				<div class="headline">
					<h2>Add a User Form</h2>
				</div>

				<br />
				<form class="form-horizontal" action="sendLoginEmail" method="POST">
					<div class="form-group">
						<label>Type of user</label>
						<div class="row margin-bottom-20">
							<div class="col-md-8 col-md-offset-0">
								<input type="radio" name="userType" value="associate" id="associateRadio" checked/>Associate
								&nbsp; <input type="radio" name="userType" value="admin" id="adminRadio" />Admin<br>
							</div>
						</div>
					
					
						<div class="form-group">
							<label>User Name</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="newUN" name="newUN"
										class="form-control" data-val="true" placeholder="User Name"
										required> <span class="field-validation-valid"
										data-valmsg-for="username" data-valmsg-replace="true"></span>

								</div>
							</div>
						</div>
						<div class="form-group">
							<label>First Name</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="firstName" name="firstName"
										class="form-control" data-val="true" placeholder="First Name"
										required> <span class="field-validation-valid"
										data-valmsg-for="firstName" data-valmsg-replace="true"></span>

								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Last Name</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="lastName" name="lastName"
										class="form-control" data-val="true" placeholder="Last Name"
										required> <span class="field-validation-valid"
										data-valmsg-for="lastName" data-valmsg-replace="true"></span>

								</div>
							</div>
						</div>
						<div class="form-group">
							<label>Email</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="email" name="email" class="form-control"
										onblur="validateEmail(value)" placeholder="Email" required>
									<span id="emailError"></span>
								</div>
							</div>
						</div>
						<input type="hidden" name="crudMethod" value="create">
						<input type="hidden" name="passwordType" value="temp">
						
						<p>
							<button type="submit" name="submit" value="Submit"
								class="btn btn-u rounded-3x btn-u-orange pulse-grow">Add User</button>
								<input type="hidden" name="crudMethod" value="create">
						<!-- 	<li><input type="submit" value="Submit" /></li>  -->
							&nbsp;
							<button type="reset" name="reset" id="reset"
								onclick="window.location.reload()" value="Reset Form"
								class="btn btn-u rounded-3x btn-u-orange pulse-grow">Reset Form</button>
							&nbsp;
							<button type="button" name="Home"
								class="btn btn-u rounded-3x btn-u-orange pulse-grow"
								onclick="window.location.href='Admin.jsp'">Home</button>
						</p>

					
				</form>
			</div>
		</div>
	</div>

	





	<!-- JS Global Compulsory -->
	<script type="text/javascript"
		src="Template/assets/plugins/jquery-1.10.2.min.js"></script>
	<script type="text/javascript"
		src="Template/assets/plugins/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript"
		src="Template/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
	<!-- <script type="text/javascript"
		src="Template/assets/plugins/back-to-top.js"></script> -->
	<!-- Masking Form -->
	<script
		src="Template/assets/plugins/sky-forms/version-2.0.1/js/jquery.maskedinput.min.js"></script>
	<!-- Datepicker Form -->
	<script
		src="Template/assets/plugins/sky-forms/version-2.0.1/js/jquery-ui.min.js"></script>
	<!-- Validation Form -->
	<script
		src="Template/assets/plugins/sky-forms/version-2.0.1/js/jquery.validate.min.js"></script>
	<!-- JS Page Level -->
	<script type="text/javascript" src="Template/assets/js/app.js"></script>
	<script type="text/javascript"
		src="Template/assets/js/plugins/masking.js"></script>
	<script type="text/javascript"
		src="Template/assets/js/plugins/datepicker.js"></script>
	<script type="text/javascript"
		src="Template/assets/js/plugins/validation.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init();
			Masking.initMasking();
			Datepicker.initDatepicker();
			Validation.initValidation();
		});
	</script>
	<!--[if lt IE 9]>
    <script src="assets/plugins/respond.js"></script>
    <script src="assets/plugins/html5shiv.js"></script>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <script src="assets/plugins/sky-forms/version-2.0.1/js/sky-forms-ie8.js"></script>
<![endif]-->

	<!--[if lt IE 10]>
    <script src="assets/plugins/sky-forms/version-2.0.1/js/jquery.placeholder.min.js"></script>
<![endif]-->

</body>
</html>