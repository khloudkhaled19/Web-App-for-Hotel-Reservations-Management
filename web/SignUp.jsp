<%-- 
    Document   : index
    Created on : Dec 30, 2020, 12:35:52 PM
    Author     : Nada Abdelrahman
--%>
 <meta charset="utf-8">
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title> Resgistration </title>
        <script src="TestCaptcha.js"></script>
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"async defer></script>
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min.css" />
	<link type="text/css" rel="stylesheet" href="CSS/style.css" />
	
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="booking" class="section">
      <div class="section-center">
       <div class="container">
	<div class="row">
	  <div class="col-md-7 col-md-push-5">
		<div class="booking-cta">
		  <h1>To Make your reservation</h1>
		   <p>Sign in to see deals up to 50%, easily manage your current bookings, and so much more...</p>
		    </div></div>
                         <div class="col-md-4 col-md-pull-7">  <h3> Registration Form</h3>
			  <div class="booking-form">
			   <form method="Post" action="ValidateSignUp">
                             <div class="form-group">
	                     <span class="form-label">First Name</span>
                             <input class="form-control" name="FName" type="text" placeholder="Enter Your First Name "><br>
                                    <span class="form-label">Second Name</span>
                                    <input class="form-control" name="SName" type="text" placeholder="Enter Your Second Name "><br>
                                     <span class="form-label">Phone Number</span>
                                     <input class="form-control" name="phone" type="number" placeholder="Enter Your Phone number "><br>
                                     <span class="form-label">User Name </span>
                                     <input class="form-control" name="userName" type="text" placeholder="Enter Your user name "> <br>
                                      <span class="form-label">Email </span>
				       <input class="form-control" name="email" type="email" placeholder="Enter Your email ">
					</div>	
				      <div class="form-btn">
                                         <div id="html_element"></div><br>
                                          <button class="submit-btn" >Create</button><br><br>
                                            <a href="signin.jsp">already have an account ?</a>
								</div></form>
						</div>
					</div>
				</div></div></div></div>
</body>

</html>