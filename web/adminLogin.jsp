<%-- 
    Document   : adminLogin
    Created on : Jan 2, 2021, 11:33:23 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Staff</title>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="staff.css">
</head>
<body>
    <div class="container-fluid bg">
    <div class="row">
        <div class="col-md-4 col-sm-12 col-xs-12">
            
        </div>
        <div class="col-md-4 col-sm-12 col-xs-12">
        <form class="form-container" method="post" action="ValidateAdmin">
          <div class="form-group">
            <h2 align="center" class="heading">Admin LOGIN</h2>
          </div>
          <div class="form-group">
            <label for="id">Login ID</label>
            <input type="text" class="form-control" name="id" id="id" placeholder="Enter Your Id">
          </div>
          <div class="form-group">
            <label for="Password">Password</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="Enter Your Password">
          </div>
        
           <div class="form-group">
               <button type="submit" class="btn btn-primary btn-block" name="submit" value="submit" >Submit</button>
          </div>
        </form>
        </div>
        <div class="col-md-4 col-sm-12 col-xs-12">
            
        </div>
    </div>
</div>    
</body>
</html>
