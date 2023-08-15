<%-- 
    Document   : signin
    Created on : Dec 30, 2020, 4:45:30 PM
    Author     : DELL
--%>

 <meta charset="utf-8">
        <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title> signin </title>
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
                                    <div class="col-md-4 col-md-pull-7">  <h3> sign in Form</h3>
						<div class="booking-form">
                                                    <form action="ValidateEmail" method="post">
								<div class="form-group">
                                                                        <span class="form-label">Email </span>
                                                                        <input class="form-control" name="email" type="email" placeholder="Enter Your email "><br>
                                                                        <span class="form-label">Password</span><br>
                                                                        <input class="form-control" name="password" type="password" placeholder="Enter Your Password "><br>
                                                                        <input type="checkbox" name="remember-me" id="remember-me"/> &nbsp; Remember me
								</div>	
								<div class="form-btn">
                                                                    <button class="submit-btn">Continue</button><br><br>
                                                                    <a href="SignUp.jsp">Create New Account</a>
								</div>
							</form>
						</div></div></div></div></div></div>
</body>

</html>