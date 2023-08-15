<%-- 
    Document   : navbar
    Created on : Jan 1, 2021, 5:43:35 PM
    Author     : Nada Abdelrahman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="CSS/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
                
<!--        navbar contet      -->
  <div>  
  <nav class="navbarWeb">
  <div class="container">
    <div class="navbar-header">
      <a href="index.html"><img class="logo"> </a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="act"><a href="home.jsp">Hotels</a></li>
        <li><a href="">Reservation</a></li>
        <li><a href="">Service</a></li>
      
       <li class="nav-item dropdown"> <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">  <%="Name"%></a>
       <div class="dropdown-menu"> <a class="dropdown-item" href="#">profile</a> <a class="dropdown-item" href="#">help</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">logout</a> </div>
        </li>
      </ul>
    </div>
  </div>
</nav>
</div>
    </body>
</html>
