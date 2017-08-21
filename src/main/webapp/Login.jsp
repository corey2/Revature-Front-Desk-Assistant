<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Revature Front Desk Assistant</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="Template/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="Template/assets/css/style.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="Template/assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="Template/assets/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="Template/assets/plugins/ladda-buttons/css/custom-lada-btn.css">
    <link rel="stylesheet" href="Template/assets/css/plugins/hover-effect/css/custom-hover-effects.css">  

    <!-- CSS Page Style -->    
    <link rel="stylesheet" href="Template/assets/css/pages/page_log_reg_v2.css">    

    <!-- CSS Theme -->    
    <link rel="stylesheet" href="Template/assets/css/themes/orange.css" id="style_color">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="Template/assets/css/custom.css">
</head> 

<body>

<!--=== Content Part ===-->    
<form action='LoginController' method="POST">
<div class="container">
    <!--Reg Block-->
    <div class="reg-block">
        <div class="reg-block-header">
            <h2>Sign In</h2>
            <img src="OneTemplate/assets/img/RevImg/RevImg.jpg" alt="Revature" style="width:300px;height:250px;">
           <!--  <ul class="social-icons text-center">
                <li><a class="rounded-x social_facebook" data-original-title="Facebook" href="#"></a></li>
                <li><a class="rounded-x social_twitter" data-original-title="Twitter" href="#"></a></li>
                <li><a class="rounded-x social_googleplus" data-original-title="Google Plus" href="#"></a></li>
                <li><a class="rounded-x social_linkedin" data-original-title="Linkedin" href="#"></a></li>
            </ul> -->
           <!--  <p>Don't Have Account? Click <a class="color-green" href="page_registration1.html">Sign Up</a> to registration.</p>        -->     
        </div>

		<c:if test="${!empty loginFail}">
			<p style="color:red">Your username or password is incorrect</p>
		</c:if>

        <div class="input-group margin-bottom-20">
            <span class="input-group-addon"><i class="fa fa-users"></i></span>
            <input type="text" name="username" id="username" class="form-control" data-val="true" placeholder="User Name">
           <!--  <span class="field-validation-valid" data-valmsg-for="name" data-valmsg-replace="true"></span> -->
            
            <!--  <input type="text" id="name" name="name" class="form-control" data-val="true" placeholder="Name" required>                           
             <span class="field-validation-valid" data-valmsg-for="name" data-valmsg-replace="true"></span> -->
            
            
        </div>
        <div class="input-group margin-bottom-20">
            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
            <input type="password" name="password" id="password" class="form-control" data-val="true" placeholder="Password">
            <!--   <span class="field-validation-valid" data-valmsg-for="password" data-valmsg-replace="true"></span> -->
        </div>
        <hr>
        <label class="checkbox">
            <input type="checkbox"> 
            <p>Always stay signed in</p>
        </label>
                                
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <button type="submit" value="submit" name="login" class="btn-u btn-block pulse-grow">Log In</button></br></br>
                <a href="index.jsp"><button type="button" value=home" name="Home" class="btn-u btn-block pulse-grow">Home</button></a></br></br>
                <h5><a href="ForgotPassword.jsp">Forgot your password?</a></h5>
                
            </div>
        </div>
    </div>
    <!--End Reg Block-->
</div><!--/container-->
</form>
<!--=== End Content Part ===-->

<!-- JS Global Compulsory -->           
<script type="text/javascript" src="Template/assets/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="Template/assets/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="Template/assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
<!-- JS Implementing Plugins -->           
<!-- <script type="text/javascript" src="Template/assets/plugins/back-to-top.js"></script> -->
<script type="text/javascript" src="Template/assets/plugins/countdown/jquery.countdown.js"></script>
<script type="text/javascript" src="Template/assets/plugins/backstretch/jquery.backstretch.min.js"></script>
<script type="text/javascript">
    $.backstretch([
      "Template/assets/img/bg/5.jpg",
      "Template/assets/img/bg/4.jpg",
      ], {
        fade: 1000,
        duration: 7000
    });
</script>
<!-- JS Page Level -->           
<script type="text/javascript" src="Template/assets/js/app.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
    });
</script>
<!--[if lt IE 9]>
    <script src="assets/plugins/respond.js"></script>
    <script src="assets/plugins/html5shiv.js"></script>
<![endif]-->

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-29166220-1']);
  _gaq.push(['_setDomainName', 'htmlstream.com']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

</body>
</html> 