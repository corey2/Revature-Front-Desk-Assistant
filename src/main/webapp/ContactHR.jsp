<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
        <link rel="stylesheet" href="Template/assets/plugins/flexslider/flexslider.css">
	 	<link rel="stylesheet" href="Template/assets/plugins/ladda-buttons/css/custom-lada-btn.css">
    	<link rel="stylesheet" href="Template/assets/css/plugins/hover-effect/css/custom-hover-effects.css">  
       
        <!-- CSS Page Style -->
        <link rel="stylesheet" href="Template/assets/css/pages/page_contact.css">

        <!-- CSS Theme -->
        <link rel="stylesheet" href="Template/assets/css/themes/orange.css" id="style_color">

        <!-- CSS Customization -->
        <link rel="stylesheet" href="Template/assets/css/custom.css">
        
      <% 
    	if (application.getAttribute("userRole") == null) {
    		RequestDispatcher next = request.getRequestDispatcher("Error.jsp");
    		next.forward(request, response);
    	} 
      %>
        
</head>

<body>

 <script>
    function validateEmail(email){

    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if(re.test(email)){

    document.getElementById('email');    
    document.getElementById('emailError').style.display = "none";

    return true;

    }else{

    alert("Please Enter A Valid Email.");
    

    return false;
    }
    }
        //Email function
        function validateFormEmail(){
	 
            var error = 0;
	  	 	   
            // Validate email
            if(!validateEmail(document.getElementById('email').value)){
	  
                document.getElementById('emailError').style.display = "block";
		
                error++;
            }
	  	  
            // Blocks submission if errors exist
            if(error > 0){
	  
                return false;
            }
        } 
    </script>




    <script type="text/javascript"
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRn7RgCCtbzpb3zjzJ-XPdrqxnDZQoKWw&callback=initialize">
    </script>
    <script>
        var mapcode = new google.maps.Geocoder();
        //var myCenter = new google.maps.LatLng(30.518117, -90.468784);
        var myCenter = new google.maps.LatLng(38.953393, -77.350448);
        var marker;
        var map;
        function initialize() {
            mapcode = new google.maps.Geocoder;
            var mapProp = {
                center: myCenter,
                zoom: 15,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            map = new google.maps.Map(document.getElementById("googleMap"), mapProp);

            marker = new google.maps.Marker({
                position: myCenter,
                animation: google.maps.Animation.BOUNCE
            });

            marker.setMap(map);
            google.maps.event.addListener(marker, 'click', function () {
                map.setZoom(18);
                map.setCenter(marker.getPosition());
            });

            google.maps.event.addListener(map, 'center_changed', function () {
                window.setTimeout(function () {
                    map.panTo(marker.getPosition());
                }, 5000);
            });

            var infowindow = new google.maps.InfoWindow({
                content: "Revature <br/> 11730 Plaza America Drive Suite 205 <br/> Reston, VA 20190 <br/> 703.570.8181"
            });

            google.maps.event.addListener(marker, 'click', function () {
                infowindow.open(map, marker);
            });

        }

        function codeAddress() {
            var add = document.getElementById('address').value;
            mapcode.geocode({ 'address': add }, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    map.setCenter(results[0].geometry.location);
                    var hint = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                } else {
                    alert('This code is not successful ' + status);
                }
            });
        }
        google.maps.event.addDomListener(window, 'load', initialize);


    </script>
    
    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left"><b>Contact Human Resources</b></h1>
            <ul class="pull-right breadcrumb">
                <li><a href="Associate.jsp">Home</a></li>
               <li><a href="AssociateController?action=listAssociate&username=${username}">Associate Form</a></li> 
                <li><a href="I9Form.jsp">I-9 Forms</a></li>
                <li><a href="EmergencyContact.jsp">Emergency Contact Forms</a></li>
                <li> <a href="LogOut.jsp">Log Out</a></li>
            </ul>
        </div>
    </div><!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->    
    </br>
    <div id="panel" align="center">
        <input id="address" type="text" style="color:#f26925; font-weight: bold; background-color:#fff; width:200px;"
               value="Corporate Office Address">
        <br />
        <br />
        <input type="button" class="btn btn-u rounded-3x btn-u-orange pulse-grow" value="Search Location" onclick="codeAddress()">&nbsp;
   	 	<button type="button" name="Home" class="btn btn-u rounded-3x btn-u-orange pulse-grow"
                        onclick="window.location.href='Associate.jsp'">Home</button></p>
    </div>
    <br />
    <div id="googleMap" class="map"></div>
    
    <!--=== Content Part ===-->

    <div class="container content">



        <div class="row margin-bottom-30">
            <div class="col-md-9 mb-margin-bottom-30">
                <div class="headline"><h2>Contact Form</h2></div>
                <p>Please contact Human Resources if you have any questions.</p><br />
                <form class="form-horizontal" action="sendMessageToHR" method="POST" id="contactHRForm">
                    <fieldset>
                        
                        <!-- The application should be able to figure out for itself the name and the email of the user -- Corey
                        <div class="form-group"> 
                            <label>Name</label>
                            <div class="row margin-bottom-20">
                                <div class="col-md-7 col-md-offset-0">
                                    <input type="text" id="name" name="name" class="form-control" data-val="true" placeholder="Name" required>                           
                                    <span class="field-validation-valid" data-valmsg-for="name" data-valmsg-replace="true"></span>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <div class="row margin-bottom-20">
                                <div class="col-md-7 col-md-offset-0">
                                    <input type="text" id="email" name="email" class="form-control" onblur="validateEmail(value)" placeholder="Email" required>                             
                                    <span id="emailError"></span>
                                </div>
                            </div>
                        </div>
                        
                        -->
                        
                        <div class="form-group">
                            <label>Subject</label>
                            <div class="row margin-bottom-20">
                                <div class="col-md-7 col-md-offset-0">
                                    <input type="text" id="subject" name="subject" class="form-control" data-val="true" placeholder="Subject" required>
                                    <span class="field-validation-valid" data-valmsg-for="subject" data-valmsg-replace="true"></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Message</label>
                            <div class="row margin-bottom-20">
                                <div class="col-md-11 col-md-offset-0">
                                    <textarea rows="8" id="message" name="message" class="form-control" data-val="true" placeholder="Message..." required></textarea>                          
                                    <span class="field-validation-valid" data-valmsg-for="message" data-valmsg-replace="true"></span>
                                   
                                </div>
                            </div>
                        </div>
                        <p><button type="submit" name="send" class="btn btn-u rounded-3x btn-u-orange pulse-grow">Send Message</button>&nbsp;
                        <button type="reset" name="reset" id="reset"
                        onclick="window.location.reload()" value="Reset Form" 
                        class="btn btn-u rounded-3x btn-u-orange pulse-grow">Reset Form</button>&nbsp;
                        <button type="button" name="Home" class="btn btn-u rounded-3x btn-u-orange pulse-grow"
                        onclick="window.location.href='Associate.jsp'">Home</button></p>
                      
                    </fieldset>
                </form>
            </div><!--/col-md-9-->

            <div class="col-md-3">
                <!-- Contacts -->
                <div class="headline"><h2>Contact</h2></div>
                <ul class="list-unstyled who margin-bottom-30">
                    <li><a href="#"><i class="fa fa-home"></i>11730 Plaza America Drive</br>Suite 205</br>Reston, VA 20190</a></li>
                    <li><a href="#"><i class="fa fa-envelope"></i>felice@revature.com</a></li>
                    <li><a href="#"><i class="fa fa-envelope"></i>hr@revature.com</a></li>
                    <li><a href="#"><i class="fa fa-phone"></i>703.570.8181</a></li>
                    <li><a href="http://www.Revature.com" target="_blank"><i class="fa fa-globe"></i>http://www.Revature.com</a></li>
                </ul>

                <!-- Business Hours -->
                <div class="headline"><h2>Business Hours</h2></div>
                <ul class="list-unstyled margin-bottom-30">
                    <li><strong>Monday - Friday</strong></li>
                    <li><strong>9 - 5</strong></li>
                </ul>

                <!-- Why we are? -->
                <div class="headline"><h2><b><i>Why Choose Revature?</i></b></h2></div>
                <p><b>Make Money Losing Weight (Somehow)</b></p>
                <ul class="list-unstyled">
                    <li><i class="fa fa-check color-green"></i>Get the Technical Skills You Need to Succeed</li>
                    <li><i class="fa fa-check color-green"></i>Paid Training!</li>
                    <li><i class="fa fa-check color-green"></i>Paid Housing!</li>
                    <li><i class="fa fa-check color-green"></i>Learn .NET, C#, Java, SQL skills</li>
                </ul>
            </div><!--/col-md-3-->
        </div><!--/row-->
         </div><!--/container-->
    <!--=== End Content Part ===-->
<!-- JS Global Compulsory -->
    <script type="text/javascript" src="Template/assets/plugins/flexslider/jquery.flexslider-min.js"></script>
    <!-- JS Page Level -->
    <script type="text/javascript" src="Template/assets/js/app.js"></script>
    <script type="text/javascript" src="Template/assets/js/pages/page_contacts.js"></script>
    
    
</body>
</html>