<%-- 
    Document   : completeUpload
    Created on : 09-Jan-2021, 02:33:24
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Done</title>
    </head>
    <body>
        
       <%
           //enter the path of the img folder on your pc
           MultipartRequest m = new MultipartRequest(request, "D:\\FCI\\Level4\\Internet Applications\\Project IA (2)\\Project IA\\web\\img") ; 
        
       %>

        <h3>Your file has been uploaded!</h3>

    </body>
</html>



