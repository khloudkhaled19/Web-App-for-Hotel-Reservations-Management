<%-- 
    Document   : payment
    Created on : 07-Jan-2021, 02:09:31
    Author     : Khloud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function validatePayment(form){
                for (var i = 0; i < (form.elements.length - 1); i++)
                {
                    if (form.elements[i].value === "")
                    {
                        alert("Fill out all Fields");
                        document.payment.username.focus();
                        document.payment.reservation.focus();
                        return false;
                    }
                    if (!/^[0-9]*$/g.test(document.payment.reservation.value)) {
                        alert("Enter numeric values in reservation id!");
                        return false;
                    }
                    if (!/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(document.payment.username.value)) {
                        alert("Enter alphabetic characters in username!");
                        return false;
                    }
                    
                    
                    
                    return true;
                }
                
            };
            
            
        </script>
    </head>
    <body>
        <form action="checkPayment.jsp" method="Get" name="payment" onsubmit="return validatePayment(this)">
            <table border="1">
                <tr> 
                    <td> Username:</td>
                    <td><input type="text" name="username"  /></td>  
                </tr>
                <tr> 
                    <td> Reservation ID:</td>
                    <td><input type="number" name="reservation"  /></td>  
                </tr>
                
                <tr>
                    <td colspan="2"> <input type="submit" value="Check" /></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
