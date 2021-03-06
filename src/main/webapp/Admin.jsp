<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <html>
 
<!-- Beginning of top -->

<head>
    <title>Admin Home</title>

    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="OneTemplate/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="OneTemplate/assets/css/style.css">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="OneTemplate/assets/plugins/line-icons/line-icons.css">
    <link rel="stylesheet" href="OneTemplate/assets/plugins/font-awesome/css/font-awesome.min.css">    
    <link rel="stylesheet" href="OneTemplate/assets/plugins/pace/pace-flash.css">
    <link rel="stylesheet" href="OneTemplate/assets/plugins/YTPlayer/css/YTPlayer.css">
    <link rel="stylesheet" href="OneTemplate/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">    
    <link rel="stylesheet" href="OneTemplate/assets/plugins/revolution-slider/examples-sources/rs-plugin/css/settings.css" type="text/css" media="screen">

    <!-- load css for cubeportfolio -->
    <link rel="stylesheet" type="text/css" href="OneTemplate/assets/plugins/cbp-plugin/cubeportfolio/css/cubeportfolio.min.css">

    <!-- load main css for this page -->
    <link rel="stylesheet" type="text/css" href="OneTemplate/assets/plugins/cbp-plugin/templates/lightbox-gallery/css/main.css">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="OneTemplate/assets/css/custom.css">
    
    
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

<!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->
<body id="body" data-spy="scroll" data-target=".navbar-fixed-top" class="demo-lightbox-gallery">
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Admin.jsp">
                    <span>A</span>dministration  
                    <!-- <img src="assets/img/logo1.png" alt="Logo"> -->
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li class="page-scroll home">
                        <a id="adminDashbdNB" href="/FrontDeskAssist/AdminController?behavior=listAssociates">Admin Dashboard</a>
                    </li>
                   <li class="page-scroll">
                        <a href="Search.jsp">Search for Associate</a>
                    </li>
                     <li class="page-scroll">
                        <a href="Create.jsp">Add User</a>
                    </li>
                   <li class="page-scroll">
                        <a id="updateAssocNB" href="Update.jsp">Update Associate</a>
                    </li>
                    <li class="page-scroll">
                        <a href="ChangePassword.jsp">Change Password</a>
                    </li>
                    <li class="page-scroll">
                        <a href="LogOut.jsp">Log Out</a>
                    </li>           
                  <!-- <li class="page-scroll">
                        <a href="#contact">Contact</a>
                    </li>                    
                    <li class="page-scroll">
                        <a href="../index.html">Main</a>
                    </li>  -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Section -->
    <section id="intro" class="intro-section">
        <div class="fullscreenbanner-container">
            <div class="fullscreenbanner">
                <ul>
                    <!-- SLIDE  -->
                     <li data-transition="curtain-1" data-slotamount="5" data-masterspeed="700"> 
                        <!-- MAIN IMAGE -->
                        <img src="OneTemplate/assets/img/RevImg/PlazaAmerica-RestonVA.jpg" alt="slidebg1" data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat">

                        <!-- LAYERS -->
                        <div class="tp-caption rs-caption-1 sft start"
                            data-x="center"
                            data-hoffset="0"
                            data-y="100"
                            data-speed="800"
                            data-start="2000"
                            data-easing="Back.easeInOut"
                            data-endspeed="300">
                             REVATURE | ADVANCING TALENT & TECHNOLOGIES
                        </div>

                        <!-- LAYER -->
                        <div class="tp-caption rs-caption-2 sft"
                            data-x="center"
                            data-hoffset="0"
                            data-y="200"
                            data-speed="1000"
                            data-start="3000"
                            data-easing="Power4.easeOut"
                            data-endspeed="300"
                            data-endeasing="Power1.easeIn"
                            data-captionhidden="off"
                            style="z-index: 6">
                             Revature is a leading-edge technology solutions<br>
                            firm with an unparalleled talent development platform <br>
                            that empowers people and companies to move forward, faster.
                        </div>

                        <!-- LAYER -->
                        <div class="tp-caption rs-caption-3 sft"
                            data-x="center"
                            data-hoffset="0"
                            data-y="360"
                            data-speed="800"
                            data-start="3500"
                            data-easing="Power4.easeOut"
                            data-endspeed="300"
                            data-endeasing="Power1.easeIn"
                            data-captionhidden="off"
                            style="z-index: 6">
                           <span class="page-scroll"><a name="adminDashbd" href="/FrontDeskAssist/AdminController?behavior=listAssociates" class="btn-u btn-brd btn-brd-hover btn-u-light">Administration Dashboard</a></span>
                           <span class="page-scroll"><a name="search" href="Search.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Search for an Associate</a></span> 
                           <span class="page-scroll"><a name="create" href="Create.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Add a User</a></span>
                           <span class="page-scroll"><a name="update" href="Update.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Update Associate</a></span> 
                           <span class="page-scroll"><a name="changePassword" href="ChangePassword.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Change Password</a></span> 
                        </div>
                    </li>

                    <!-- SLIDE -->
                     <li data-transition="slideup" data-slotamount="5" data-masterspeed="1000">
                       <!--  MAIN IMAGE -->
                        <img src="OneTemplate/assets/img/RevImg/ClassTwo.jpg" alt="slidebg1"  data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat">

                       <!--  LAYERS -->
                        <div class="tp-caption rs-caption-1 sft start"
                            data-x="center"
                            data-hoffset="0"
                            data-y="100"
                            data-speed="800"
                            data-start="1500"
                            data-easing="Back.easeInOut"
                            data-endspeed="300">
                            DEDICATED ADVANCED TEAMS
                        </div> 

                        <!-- LAYER -->
                         <div class="tp-caption rs-caption-2 sft"
                            data-x="center"
                            data-hoffset="0"
                            data-y="200"
                            data-speed="1000"
                            data-start="2500"
                            data-easing="Power4.easeOut"
                            data-endspeed="300"
                            data-endeasing="Power1.easeIn"
                            data-captionhidden="off"
                            style="z-index: 6">
                            Revature delivers custom-tailored and cost-effective <br>
                            solutions designed to empower your business with talent <br>
                            and technologies that help put you ahead.                          
                        </div> 

                        <!-- LAYER -->
                         <div class="tp-caption rs-caption-3 sft"
                            data-x="center"
                            data-hoffset="0"
                            data-y="360"
                            data-speed="800"
                            data-start="3500"
                            data-easing="Power4.easeOut"
                            data-endspeed="300"
                            data-endeasing="Power1.easeIn"
                            data-captionhidden="off"
                            style="z-index: 6">
                           <span class="page-scroll"><a name="adminDashbd" href="/FrontDeskAssist/AdminController?behavior=listAssociates" class="btn-u btn-brd btn-brd-hover btn-u-light">Administration Dashboard</a></span>
                           <span class="page-scroll"><a name="search" href="Search.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Search for an Associate</a></span> 
                           <span class="page-scroll"><a name="create" href="Create.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Add a User</a></span>
                           <span class="page-scroll"><a name="update" href="Update.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Update Associate</a></span> 
                           <span class="page-scroll"><a name="changePassword" href="ChangePassword.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Change Password</a></span> 
                        </div>
                    </li> 

                    <!-- SLIDE -->
                    <li data-transition="slideup" data-slotamount="5" data-masterspeed="700">
                        <!-- MAIN IMAGE -->
                        <img src="OneTemplate/assets/img/RevImg/JoeVacca.jpg"  alt="slidebg1"  data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat">

                        <!-- LAYERS -->
                        <div class="tp-caption rs-caption-1 sft start"
                            data-x="center"
                            data-hoffset="0"
                            data-y="110"
                            data-speed="800"
                            data-start="1500"
                            data-easing="Back.easeInOut"
                            data-endspeed="300">
                            NEXT GEN TALENT WITH NEXT GEN SKILLS
                        </div>

                        <!-- LAYER -->
                        <div class="tp-caption rs-caption-2 sfb"
                            data-x="center"
                            data-hoffset="0"
                            data-y="210"
                            data-speed="800"
                            data-start="2500"
                            data-easing="Power4.easeOut"
                            data-endspeed="300"
                            data-endeasing="Power1.easeIn"
                            data-captionhidden="off"
                            style="z-index: 6">
                           	 Get the experience you need fast by learning <br>
                            leading edge programming skills in our intensive <br>
                            10-week program in a team-focused setting.  
                        </div>

                        <!-- LAYER -->
                        <div class="tp-caption rs-caption-3 sfb"
                            data-x="center"
                            data-hoffset="0"
                            data-y="370"
                            data-speed="800"
                            data-start="3500"
                            data-easing="Power4.easeOut"
                            data-endspeed="300"
                            data-endeasing="Power1.easeIn"
                            data-captionhidden="off"
                            style="z-index: 6">
                           <span class="page-scroll"><a name="adminDashbd" href="/FrontDeskAssist/AdminController?behavior=listAssociates" class="btn-u btn-brd btn-brd-hover btn-u-light">Administration Dashboard</a></span>
                           <span class="page-scroll"><a name="search" href="Search.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Search for an Associate</a></span> 
                           <span class="page-scroll"><a name="create" href="Create.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Add a User</a></span>
                           <span class="page-scroll"><a name="update" href="Update.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Update Associate</a></span> 
                           <span class="page-scroll"><a name="changePassword" href="ChangePassword.jsp" class="btn-u btn-brd btn-brd-hover btn-u-light">Change Password</a></span> 
                        </div>
                    </li>                    
                </ul>
                <div class="tp-bannertimer tp-bottom"></div>
                <div class="tp-dottedoverlay twoxtwo"></div>
            </div>
        </div>
    </section>
    <!-- End Intro Section -->

<!-- Bottom -->
 <div class="copyright-section">
            <p>2016 &copy; All Rights Reserved   <a target="_blank" href="https://www.russellgooch.com">Team Sudo</a></p>
            <ul class="social-icons">
                <li><a href="http://www.facebook.com" data-original-title="Facebook" class="social_facebook rounded-x"></a></li>
                <li><a href="http://www.twitter.com" data-original-title="Twitter" class="social_twitter rounded-x"></a></li>
                <li><a href="https://plus.google.com/" data-original-title="Goole Plus" class="social_googleplus rounded-x"></a></li>
                <li><a href="http://www.pinterest.com" data-original-title="Pinterest" class="social_pintrest rounded-x"></a></li>
                <li><a href="http://www.linkedin.com" data-original-title="Linkedin" class="social_linkedin rounded-x"></a></li>
            </ul>
            <span class="page-scroll"><a href="#intro"><i class="fa fa-angle-double-up back-to-top"></i></a></span>
        </div>
    </section>
    <!-- End Contact Section -->

    <!-- JS Global Compulsory -->
    <script type="text/javascript" src="OneTemplate/assets/plugins/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/jquery-migrate-1.2.1.min.js"></script>    
    <script type="text/javascript" src="OneTemplate/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- JS Implementing Plugins -->
    <script type="text/javascript" src="OneTemplate/assets/plugins/jquery.easing.min.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/pace/pace.min.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/jquery.parallax.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/counter/waypoints.min.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/counter/jquery.counterup.min.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>    
    <script type="text/javascript" src="OneTemplate/assets/plugins/revolution-slider/examples-sources/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/plugins/revolution-slider/examples-sources/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
    <!-- load caPortfolio plugin -->
    <script type="text/javascript" src="OneTemplate/assets/plugins/cbp-plugin/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
    <!-- load main js -->
    <script type="text/javascript" src="OneTemplate/assets/plugins/cbp-plugin/templates/lightbox-gallery/js/main.js"></script>

    <!-- JS Page Level-->
    <script type="text/javascript" src="OneTemplate/assets/js/app.js"></script>
    <script type="text/javascript" src="OneTemplate/assets/js/plugins/owl-carousel.js"></script>    
    <script type="text/javascript">
        jQuery(document).ready(function() {
            App.init();
            App.initCounter();
            App.initParallaxBg();
            OwlCarousel.initOwlCarousel();            
        });
    </script>

    <script type="text/javascript">
        var revapi;
        jQuery(document).ready(function() {
           revapi = jQuery('.fullscreenbanner').revolution(
            {
                delay:15000,
                startwidth:1170,
                startheight:500,
                hideThumbs:10,
                fullWidth:"on",
                fullScreen:"on",
                dottedOverlay:"twoxtwo",
                fullScreenOffsetContainer: "",
            });
        });
    </script>

    <script type="text/javascript">
        paceOptions = {
          // Disable the 'elements' source
          elements: false,

          // Only show the progress on regular and ajax-y page navigation,
          // not every request
          restartOnRequestAfter: false
        }
    </script>

</body>

</html>

