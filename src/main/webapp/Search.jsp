<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.pojos.java.AssociatePOJO, java.util.Date, java.text.*"
	pageEncoding="ISO-8859-1" import="com.pojos.java.AssociatePOJO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search for Associate</title>

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
<link rel="stylesheet"
	href="Template/assets/plugins/ladda-buttons/css/custom-lada-btn.css">
<link rel="stylesheet"
	href="Template/assets/css/plugins/hover-effect/css/custom-hover-effects.css">
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
	<!--=== Breadcrumbs ===-->
	<div class="breadcrumbs">
		<div class="container">
			<h1 class="pull-left">
				<b>Search for Associate</b>
			</h1>
			<ul class="pull-right breadcrumb">
				<li><a href="Admin.jsp">Home</a></li>
				<li><a
					href="/FrontDeskAssist/AdminController?behavior=listAssociates">Admin
						Dashboard</a></li>
				<li><a href="Update.jsp">Update Associate</a></li>
				<li><a href="Create.jsp">Add an Associate</a></li>
				<li><a href="LogOut.jsp">Log Out</a></li>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row margin-bottom-30">
			<div class="col-md-8 mb-margin-bottom-30">
				<div class="headline">
					<h2>Search for an Associate Form</h2>
				</div>

				<br />
				<form class="form-horizontal" action="AdminController" method="POST"
					id="searchForm">

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
					<input type="hidden" name="crudMethod" value="read">

					<p>
						<button type="submit" name="submitSearch" value="Search"
							class="btn btn-u rounded-3x btn-u-orange pulse-grow">Find
							Associate</button>
						<input type="hidden" name="crudMethod" value="add">
						<!-- 	<li><input type="submit" value="Submit" /></li>  -->
						&nbsp;
						<button type="reset" name="reset" id="reset"
							onclick="window.location.href='Search.jsp'" value="Reset Form"
							class="btn btn-u rounded-3x btn-u-orange pulse-grow">Reset
							Form</button>
						&nbsp;
						<button type="button" name="Home"
							class="btn btn-u rounded-3x btn-u-orange pulse-grow"
							onclick="window.location.href='Admin.jsp' ">Home</button>
					</p>


				</form>
				<hr>





				<!--Hover Rows-->
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-orange margin-bottom-40">
								<div class="panel-heading">
									<h3 class="panel-title">
										<i class="fa fa-gear"></i>Associate Information
									</h3>
								</div>
								<table class="table table-hover">

									<thead>
										<tr>
											<th>Username</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Gender</th>
											<th>Address</th>
											<th>City</th>
											<th>State</th>
											<th>Zip</th>
											<th>Arrival Date</th>
											<th>Transport</th>
											<th>Has Car?</th>
											<th>Email</th>
											<th>Phone</th>
										</tr>
									</thead>
									<tbody>


	<%
		if (request.getAttribute("associate") != null) {
			Object unconverted = request.getAttribute("associate");
			AssociatePOJO associate = (AssociatePOJO) unconverted;	

			//sex
			String sex = associate.getSex();
    		if (sex != null) {
	    		if (sex.equals("M")) {
	    			sex = "Male";
	    		} else if (sex.equals("F")) {
	    			sex = "Female";
	    		} else {
    				sex = "Other";
    			}
    		} else {
    			sex = "";
    		}
    		
    		//zip code
    		String zipString = Integer.toString(associate.getZip());
			if (associate.getZip() == 0) {
				zipString = "";
			} else if (zipString.length() != 5) {					
				zipString = "Zip error: "+associate.getZip();
			} else {
				zipString = ""+associate.getZip();
			}	
			
			//Arrival Date
			String dateString = "";
			if (associate.getArrivalDate() != null) {
				Date date = associate.getArrivalDate();
				SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
				dateString = formatter.format(date);
			}
			
			//Car during training?
			String hasCar = "";
			int hc = associate.getCarDuringTraining();
			if (hc == 0) {
				hasCar = "No";
			}
			if (hc == 1) {
				hasCar = "Yes";
			}
			
			//Phone Number
			String phoneString = Long.toString(associate.getPhoneNumber());
			String phoneDisplay = null;
			if (phoneString.length() == 0) {
				phoneDisplay = "Seeing this message on the admin dashboard should be impossible";
			} else if (phoneString.length() == 1) {
				phoneDisplay = "";
			} else if (phoneString.length() == 10) {
				phoneDisplay = phoneString.substring(0, 3)+"-"+phoneString.substring(3, 6)+"-"+phoneString.substring(6, 10);
			} else {
				phoneDisplay = "Invalid phone: "+associate.getPhoneNumber();	
			}
			
			//Everything else that can be null
			if (associate.getAddress() == null) {
				associate.setAddress("");
			}
			if (associate.getCity() == null) {
				associate.setCity("");	
			}
			if (associate.getState() == null) {
				associate.setState("");	
			}
			if (associate.getMethodOfTrans() == null) {
				associate.setMethodOfTrans("");	
			}
			
			out.write(
				"<td>" + associate.getUsername() + "</td>" 
				+ "<td>" + associate.getFirstName() + "</td>"
				+ "<td>" + associate.getLastName() + "</td>"
				+ "<td>" + sex + "</td>"
				+ "<td>" + associate.getAddress() + "</td>"
				+ "<td>" + associate.getCity() + "</td>"
				+ "<td>" + associate.getState() + "</td>"
				+ "<td>" + zipString + "</td>"
				+ "<td>" + dateString + "</td>"
				+ "<td>" + associate.getMethodOfTrans() + "</td>"
				+ "<td>" + hasCar + "</td>"
				+ "<td>" + associate.getEmail() + "</td>"
				+ "<td>" + phoneDisplay + "</td>"
			);
		}
	%>


									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<%--  <form action="AdminController" method="GET">
              	<input type="hidden" name="action" value="delete">
              	<input type="hidden" name="username" value="${associate.username}">
              	<input type="submit" value="Delete Associate"/>
              </form>   --%>
				<!--  <h4><a href="Delete.jsp">Click here to delete an Associate</a></h4>     -->


				<form action="AdminController" method="GET">
					<input type="hidden" name="behavior" value="update"> <input
						type="hidden" name="associateUN" id="UNForUpdateButton"
						value="${associate.username}">
					<button type="submit" name="updateButton" value="Update Associate"
						class="btn btn-u rounded-3x btn-u-orange outline-outward">Update
						Associate</button>
				</form>
				</br>
				<form action="AdminController" method="POST"
					onSubmit="if(!confirm('Are you sure you want to delete this Associate?')){return false;}">
					<input type="hidden" name="crudMethod" value="delete"> <input
						type="hidden" name="associateUN" id="UNForDeleteButton"
						value="${associate.username}">
					<button type="submit" name="deleteButton" value="Delete Associate"
						class="btn btn-u rounded-3x btn-u-orange outline-outward">Delete
						Associate</button>
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





<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.pojos.java.AssociatePOJO"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Associate Finder</title>
</head> --%>
<%-- <body>
	<form action="AdminController" method="POST" id="searchForm">
		<h2>Type in the first and last name of the associate you want to view</h2>
		<input type="text" name="firstName" placeholder="First Name"><br>
		<input type="text" name="lastName" placeholder="Last Name"><br>
		<input type="hidden" name="crudMethod" value="read">
		<input type="submit" name="submitSearch" value="Search">
	</form>
	
	<%
		if (request.getAttribute("associate") != null) {
			Object unconverted = request.getAttribute("associate");
			AssociatePOJO associate = (AssociatePOJO) unconverted;	
		
			out.write("<h4>Matching Associate:</h4>");
			
			out.write(
				"Username = " + associate.getUsername() + "<br>" 
				+ "First Name = " + associate.getFirstName() + "<br>"
				+ "Last Name = " + associate.getLastName() + "<br>"
				+ "Gender = " + associate.getSex() + "<br>"
				+ "Address = " + associate.getAddress() + "<br>"
				+ "City = " + associate.getCity() + "<br>"
				
			);
		}
	%>

</body>
</html> --%>