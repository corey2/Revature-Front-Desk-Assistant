<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	import="com.pojos.java.AssociatePOJO, java.util.Date, java.text.*"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Dashboard</title>

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
	<!-- <h2>Associate Form</h2>
  <button type="button" name="Home" class="btn btn-u rounded-3x btn-u-orange"
                        onclick="window.location.href='Admin.jsp'">Home</button></p> -->

	<!--=== Breadcrumbs ===-->
	<div class="breadcrumbs">
		<div class="container">
			<h1 class="pull-left">
				<b>Admin Dashboard</b>
			</h1>
			<ul class="pull-right breadcrumb">
				<li><a name="Home" href="Admin.jsp">Home</a></li>
				<li><a href="Update.jsp">Update Associate</a></li>
				<li><a href="Create.jsp">Add an Associate</a></li>
				<li><a href="Search.jsp">Search for an Associate</a></li>
				<li><a href="LogOut.jsp">Log Out</a></li>
			</ul>
		</div>
	</div>
	<!--/breadcrumbs-->
	<!--=== End Breadcrumbs ===-->

	<!-- New Table -->
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
								<th>Email</th>
								<th>Phone</th>
								<th>Address</th>
								<th>City</th>
								<th>State</th>
								<th>Zip</th>
								<th>Arrival Date</th>
								<th>Transport</th>
								<th>Has Car?</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="associate" items="${associates}">
								<% AssociatePOJO associate = (AssociatePOJO) pageContext.getAttribute("associate");	%>
								
								<tr>
									<td>${associate["username"]}</td>									
									<td>${associate["firstName"]}</td>
									<td>${associate["lastName"]}</td>									
									<td>
									<%
							    		String sex = associate.getSex();
							    		if (sex != null) {
								    		if (sex.equals("M")) {
								    			out.println("Male");
								    		} else if (sex.equals("F")) {
								    			out.println("Female");
								    		} else {
							    				out.println("Other");
							    			}
							    		} else {
							    			out.println();
							    		}
									%>
									</td>
									<td>${associate["email"]}</td>
									<td>
									<% 
										String phoneString = Long.toString(associate.getPhoneNumber());
										if (phoneString.length() == 0) {
											out.println("Seeing this message on the admin dashboard should be impossible");
										} else if (phoneString.length() == 1) {
											out.println("");
										} else if (phoneString.length() == 10) {
											String display = phoneString.substring(0, 3)+"-"+phoneString.substring(3, 6)+"-"+phoneString.substring(6, 10);
											out.println(display);
										} else {
											out.println("Invalid phone: "+associate.getPhoneNumber());	
										}
									%>
									</td>
									<td>${associate["address"]}</td>
									<td>${associate["city"]}</td>
									<td>${associate["state"]}</td>
									<td>
									<% 
										String zipString = Integer.toString(associate.getZip());
										if (associate.getZip() == 0) {
											out.println();
										} else if (zipString.length() != 5) {					
											out.println("Zip error: "+associate.getZip());
										} else {
											out.println(associate.getZip());
										}	
									%>
									</td>
									<td>
									<% 
										if (associate.getArrivalDate() != null) {
											Date date = associate.getArrivalDate();
											SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
											out.println(formatter.format(date));
										}
									%>
									</td>
									<td>${associate["methodOfTrans"]}</td>
									<td>${associate["carDuringTraining"]}</td>
									
									

									<c:url value="/AdminController" var="updateURL">
										<c:param name="behavior" value="update" />
										<c:param name="associateUN" value="${associate['username']}" />
									</c:url>

									<c:url value="/AdminController" var="deleteURL">
										<c:param name="behavior" value="delete" />
										<c:param name="associateUN" value="${associate['username']}" />
									</c:url>

									<%-- <td><a href="${updateURL}">Update</a></td>
									<td><a href="${deleteURL}">Delete</a></td>
 --%>

									<td>
										<div>
											<a href="${updateURL}">Update</a>
											|
											<a href="${deleteURL}">Delete</a>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--End Hover Rows-->
	<!-- JS Global Compulsory -->
	<script type="text/javascript"
		src="Template/assets/plugins/jquery-1.10.2.min.js"></script>
	<script type="text/javascript"
		src="Template/assets/plugins/jquery-migrate-1.2.1.min.js"></script>
	<script type="text/javascript"
		src="Template/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<!-- JS Implementing Plugins -->
<!-- 	<script type="text/javascript"
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