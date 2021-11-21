<%@page import="com.pojos.java.EmailGenerator"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>E-mail submission confirmation</title>
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
<!-- <form action='LoginController' method="POST"> -->
<div class="container">
    <!--Reg Block-->
    <div class="reg-block">
        <div class="reg-block-header">
            <h2>
            	<!-- The top choice is for when the email is sent from the associate to Revature. 
            		 The bottom choice is for when the email is sent from Revature to an associate.	-->
            	<c:choose>
            		<c:when test="${emailType == 'contactHREmail'}">
            			<p>You have successfully sent an email to Revature.</p>
            			<a href="Associate.jsp"><button id="backToAssociateProfile" class="btn-u btn-block pulse-grow">Back to profile</button></a>
            		</c:when>
            		<c:when test="${emailType == 'newPasswordEmail'}">
            			<p>You have successfully added <%=request.getParameter("firstName")%> <%=request.getParameter("lastName")%> 
            			  to the database. An E-mail has been sent to him/her at <%= request.getParameter("email")%>.</p>
            			<a href="Admin.jsp"><button id="backToAdminProfile" class="btn-u btn-block pulse-grow">Back to profile</button></a>
            		</c:when>
            		<c:when test="${emailType == 'forgotPasswordEmail'}">
            			<p>The email with your new password has been sent to you.</p>
            			<a href="Login.jsp"><button id="backToLoginSuccess" class="btn-u btn-block pulse-grow">Back to profile</button></a>
            		</c:when>
            		<c:when test="${emailType == 'addressNotFoundEmail'}">
            			<p>We cannot find your email in our records. Contact an administrator to check that you have an account with Revature 
            			   Front Desk Assistant and if so, whether the information in the account is correct.</p>
            			<a href="Login.jsp"><button id="backToLoginFailure" class="btn-u btn-block pulse-grow">Back to profile</button></a>
            		</c:when>
            		<c:otherwise>
            			<p>What are you doing here? We don't have anything special for you.</p>
            			<a href="Login.jsp"><button id="backToLoginThree" class="btn-u btn-block pulse-grow">Back to profile</button></a>
            		</c:otherwise>
            	</c:choose>
            </h2>
            <img src="OneTemplate/assets/img/RevImg/RevGlit.gif" alt="Revature" style="width:300px;height:250px;">
        </div>                            
        
        <!-- The code below is made irrelevent by the conditional logic above. 
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
             <a href="AdminController?action=listAssociate"><button id="backToProfile" class="btn-u btn-block pulse-grow">Back to profile</button></a>
                <button type="submit" value="submit" name="login" class="btn-u btn-block pulse-grow">Submit</button></br></br>
                <a href="index.jsp"><button type="button" value=home" name="Home" class="btn-u btn-block pulse-grow">Home</button></a></br></br>
              <h5><a href="Login.jsp">Back to Login Page</a></h5> -->
            </div>
        </div>
        -->
    </div>
    <!--End Reg Block-->
</div><!--/container-->
<!-- </form> -->
<!--=== End Content Part ===-->

<!-- JS Global Compulsory -->           
<script type="text/javascript" src="Template/assets/plugins/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="Template/assets/plugins/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="Template/assets/plugins/bootstrap/js/bootstrap.min.js"></script> 
<!-- JS Implementing Plugins -->           
<script type="text/javascript" src="Template/assets/plugins/back-to-top.js"></script>
<script type="text/javascript" src="Template/assets/plugins/countdown/jquery.countdown.js"></script>
<script type="text/javascript" src="Template/assets/plugins/backstretch/jquery.backstretch.min.js"></script>
<script type="text/javascript">
    $.backstretch([    
      "Template/assets/img/blur/capitol.jpg",
      "Template/assets/img/blur/img1.jpg",
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

<!-- Previous Code -->
<%-- <%@page import="com.pojos.java.EmailGenerator"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>E-mail submission confirmation</title>
  </head>
  <body>
	
	<p>You have successfully sent an email to <%= request.getParameter("email") %></p>
		
	<button id="backToProfile" onclick="window.location.replace('AdminDash.jsp')">Back to profile</button>
		
  </body>
</html> --%>