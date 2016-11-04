<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>I-9 Form</title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="Template/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="Template/assets/css/style.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="Template/assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="Template/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="Template/assets/plugins/sky-forms/version-2.0.1/css/custom-sky-forms.css">
    <!--[if lt IE 9]>
        <link rel="stylesheet" href="assets/plugins/sky-forms/version-2.0.1/css/sky-forms-ie8.css">
    <![endif]-->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- CSS Theme -->    
    <link rel="stylesheet" href="Template/assets/css/themes/orange.css" id="style_color">
    
    <!-- CSS Customization -->
    <link rel="stylesheet" href="Template/assets/css/custom.css">
</head> 

<body>
	<!-- <h2>I9 Form</h2>
	<button type="button" name="Home"
		class="btn btn-u rounded-3x btn-u-orange"
		onclick="window.location.href='Associate.jsp'">Home</button>
	</p> -->
 <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left"><b>I-9 Forms</b></h1>
            <ul class="pull-right breadcrumb">
                <li><a id="Home" href="Associate.jsp">Home</a></li>
                <li><a href="ContactHR.jsp">Contact Human Resources</a></li>
            <!--     <li><a href="I9Form.jsp">I-9 Forms</a></li> -->
                <li><a href="EmergencyContact.jsp">Emergency Contact Forms</a></li>
                <li> <a href="LogOut.jsp">Log Out</a></li>
            </ul>
        </div>
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->    
	<div class="container">
	<div class="row" align="center">
	<div class="container">
		<iframe id="I9Form" style="border: 1px solid #666CCC"
			title="PDFI9Form" src="pdfs/I9Form.pdf" frameborder="1"
			scrolling="auto" height="1100" width="100%"></iframe>
	</div>
	</div>
	</div>
<!-- JS Global Compulsory -->           
<script type="text/javascript" src="Template/assets/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="Template/assets/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="Template/assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
<!-- JS Implementing Plugins -->
<!-- <script type="text/javascript" src="Template/assets/plugins/back-to-top.js"></script> -->
<!-- Masking Form -->
<script src="Template/assets/plugins/sky-forms/version-2.0.1/js/jquery.maskedinput.min.js"></script>
<!-- Datepicker Form -->
<script src="Template/assets/plugins/sky-forms/version-2.0.1/js/jquery-ui.min.js"></script>
<!-- Validation Form -->
<script src="Template/assets/plugins/sky-forms/version-2.0.1/js/jquery.validate.min.js"></script>
<!-- JS Page Level -->           
<script type="text/javascript" src="Template/assets/js/app.js"></script>
<script type="text/javascript" src="Template/assets/js/plugins/masking.js"></script>
<script type="text/javascript" src="Template/assets/js/plugins/datepicker.js"></script>
<script type="text/javascript" src="Template/assets/js/plugins/validation.js"></script>
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