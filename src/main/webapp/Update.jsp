<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	import="com.pojos.java.AssociatePOJO"	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Form</title>

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
		
		
		//Validate phone number
		 function validatePhone(phoneNum) {
			var re = /^[1-9]{1}[0-9]{9}$/;

			if (re.test(phoneNum)) {
				document.getElementById('phoneNum');
				document.getElementById('phoneError').style.display = "none";

				return true;
			} else {

				alert("Please Enter only Ten(10) digits without spaces, dashes, or dots.");
				return false;
			}
		} 
		//Phone function
		 function validateFormPhone() {
			var error = 0;

			// Validate email
			if (!validatePhone(document.getElementById('phoneNum').value)) {
				document.getElementById('phoneError').style.display = "block";
				error++;
			}

			// Blocks submission if errors exist
			if (error > 0) {
				return false;
			}
		} 
		
		function validateZip(zip) {
		
			var re = /^[0-9]{5}$/;

			if (re.test(zip)) {
				document.getElementById('zip');
				document.getElementById('zipError').style.display = "none";

				return true;
			} else {

				alert("Please Enter A Valid Five Digit Zip.");
				return false;
			}
		}
		//Email function
		function validateFormZip() {
			var error = 0;

			// Validate email
			if (!validateZip(document.getElementById('zip').value)) {
				document.getElementById('zipError').style.display = "block";
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
				<b>Admin Update Form</b>
			</h1>
			<ul class="pull-right breadcrumb">
				<li><a href="Admin.jsp">Home</a></li>
				<li><a href="/FrontDeskAssist/AdminController?behavior=listAssociates">Admin Dashboard</a></li>
				 <li><a href="Create.jsp">Add an Associate</a></li>
				<li><a href="Search.jsp">Search For an Associate</a></li> 
				<li> <a href="LogOut.jsp">Log Out</a></li>
			</ul>
		</div>
	</div>
	<!--/breadcrumbs-->
	<!--=== End Breadcrumbs ===-->
	
	
	<!-- Search Functions -->
	
	
	
	<div class="container">
		<div class="row margin-bottom-30">
			<div class="col-md-8 mb-margin-bottom-30">
				<div class="headline">
					<h2>Admin Update Form</h2>
				</div>
	
				<br />
				
				 
				<%AssociatePOJO associate = (AssociatePOJO) request.getAttribute("associate");%>
				<form class="form-horizontal" action="AdminController" method="POST" id="adminUpdateForm">
					<fieldset>
						<div class="form-group">
							<label>Username</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="associateUN" name="associateUN"
										class="form-control" data-val="true" value="${associate.username}"
										placeholder="Username"
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
										class="form-control" data-val="true" value="${associate.firstName}" 
										placeholder="First Name"
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
										class="form-control" data-val="true" value="${associate.lastName}"
										placeholder="Last Name"
										required> <span class="field-validation-valid"
										data-valmsg-for="lastName" data-valmsg-replace="true"></span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>Gender</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<c:choose>
										<c:when test="${associate.sex == 'M'}">
											<input type="radio" name="sex" value="M" id="Male" checked/>Male
											&nbsp; <input type="radio" name="sex" value="F" id="Female" />Female<br>
										</c:when>
										<c:when test="${associate.sex == 'F'}">
											<input type="radio" name="sex" value="M" id="Male"/>Male
											&nbsp; <input type="radio" name="sex" value="F" id="Female" checked/>Female<br>
										</c:when>
										<c:otherwise>
											<input type="radio" name="sex" value="M" id="Male"/>Male
											&nbsp; <input type="radio" name="sex" value="F" id="Female"/>Female<br>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							
						</div>
						
						<div class="form-group">
							<label>Email</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="email" name="email" class="form-control"
										onblur="validateEmail(value)" value="${associate.email}" 
										placeholder="Email" required>
									<span id="emailError"></span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>Phone Number</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
										<input type="text" id="phoneNum" name="phoneNum"
										class="form-control" onblur="validatePhone(value)" 
										value=
										"<% 
											if (associate != null) {
												if (associate.getPhoneNumber() != 0) {
													out.println(associate.getPhoneNumber());
												}
											}
										%>"
										placeholder="Phone Enter: XXXXXXXXXX" required> <span id="phoneError"></span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>Address</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="address" name="address"
										class="form-control" data-val="true" value="${associate.address}"
										placeholder="Address"
										required> <span class="field-validation-valid"
										data-valmsg-for="subject" data-valmsg-replace="true"></span>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>City</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="city" name="city" class="form-control"
										data-val="true" value="${associate.city}"
										placeholder="City" required> <span
										class="field-validation-valid" data-valmsg-for="subject"
										data-valmsg-replace="true"></span>

								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>State</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="state" name="state" class="form-control"
										data-val="true" value="${associate.state}"
										placeholder="State: XX" required> <span
										class="field-validation-valid" data-valmsg-for="subject"
										data-valmsg-replace="true"></span>

								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>Zip Code</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<input type="text" id="zip" name="zip" class="form-control"
										onblur="validateZip(value)"
										value=
									    "<%
											if (associate != null) {
												if (associate.getZip() != 0) {
													out.println(associate.getZip());
												}
											}
										%>"
										placeholder="Zip" required> <span id="zipError"></span>										
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<fieldset>
							<label>Select the date the associate is arriving.</label>
								<section> <label class="label">Date
									of Arrival.</label> <label class="input"> <i
									class="icon-append fa fa-calendar"></i> <input type="text"
									name="date" id="date">
								</label> </section>
							</fieldset>
						</div>

						<div class="form-group">
							<label>How will the associate be traveling to Revature?</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<select id="methTrans" name="methTrans" class="form-control">
										<!-- data-val="true" placeholder="Zip" required> -->
										<option value="Car" name="car" id="car">Car</option>
										<option value="Bus" name="bus" id="bus">Bus</option>
										<option value="Plane" name="plane" id="plane">Plane</option>
										<option value="Train" name="train" id="train">Train</option>
										<option value="Boat" name="boat" id="boat">Boat</option>
									</select>
									
									<script>
										function setSelectedIndex(a, b) {
											for (var i = 0; i < a.options.length; i++) {
												if (a.options[i].text == b) {
													a.options[i].selected = true;
													return;
												}
											}
										
										}
										
										var ra = "${associate.methodOfTrans}";
										//window.alert(ra);
										setSelectedIndex(document.getElementById("methTrans"), ra);
									</script>
									
									<!--  <span class="field-validation-valid" data-valmsg-for="methTrans" data-valmsg-replace="true"></span> -->
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label>Will the associate be using a car during Revature training?</label>
							<div class="row margin-bottom-20">
								<div class="col-md-8 col-md-offset-0">
									<c:choose>
										<c:when test="${associate.carDuringTraining == 'Yes'}">
											<input type="radio" name="hasCar" value="Yes" id=6 checked/>Yes<input
											type="radio" name="hasCar" value="No" id=7/>No<br>
										</c:when>
										<c:when test="${associate.carDuringTraining == 'No'}">
											<input type="radio" name="hasCar" value="Yes" id=6/>Yes<input
											type="radio" name="hasCar" value="No" id=7 checked/>No<br>
										</c:when>
										<c:otherwise>
											<input type="radio" name="hasCar" value="Yes" id=6/>Yes<input
											type="radio" name="hasCar" value="No" id=7/>No<br>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						
						<input type="hidden" name="crudMethod" value="update">
						
						<p>
							<button type="submit" name="send"
								class="btn btn-u rounded-3x btn-u-orange pulse-grow">Submit Form</button>
							&nbsp;
							<button type="reset" name="reset" id="reset"
								onclick="window.location.reload()" value="Reset Form"
								class="btn btn-u rounded-3x btn-u-orange pulse-grow">Reset Form</button>
							&nbsp;
							<button type="button" name="Home"
								class="btn btn-u rounded-3x btn-u-orange pulse-grow"
								onclick="window.location.href='Admin.jsp'">Home</button>
						</p>

					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<!--/col-md-9-->
	<!-- <div class="tab-content"> -->
	<!-- Datepicker Forms -->
	<!-- <div class="tab-pane fade in active" id="home-1">
			<form action="" id="sky-form" class="sky-form">
				<header>Datepicker</header>

				<fieldset>
					<div class="row">
						<section> <label class="label">Select single
							date</label> <label class="input"> <i
							class="icon-append fa fa-calendar"></i> <input type="text"
							name="date" id="date">
						</label> </section>
					</div>
					<label class="label">Select date range</label>
					<div class="row">
						<section class="col col-6"> <label class="input">
							<i class="icon-append fa fa-calendar"></i> <input type="text"
							name="start" id="start" placeholder="Start date">
						</label> </section>
						<section class="col col-6"> <label class="input">
							<i class="icon-append fa fa-calendar"></i> <input type="text"
							name="finish" id="finish" placeholder="Expected finish date">
						</label> </section>
					</div>
				</fieldset>
			</form>
		</div>
	</div> -->






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
	<!-- Corey Made Files -->
	
	<script type="text/javascript">
		jQuery(document).ready(function() {
			App.init();
			Masking.initMasking();
			Datepicker.initDatepicker();
			Validation.initValidation();
			
			var ra = "${associate.arrivalDate}";
			var date = new Date(ra+"T05:00:00");  
			$("#date").datepicker("setDate", date);
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