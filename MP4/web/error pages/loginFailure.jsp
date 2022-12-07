<%-- 
    Document   : failed
    Created on : 11 9, 22, 9:05:25 PM
    Author     : Kyle Molinyawe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="True"%>
<!DOCTYPE html>
<html style="height:100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unsuccessful Login</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body style="height:100%">
        <div class="d-flex justify-content-center text-center" style="height: 100%;">
            <div class="border p-4 rounded-4 d-flex flex-column justify-content-center" style="height: 140px; margin-top:200px;">
                <h4 class="mb-3">Your username/password might be incorrect. Please head to the login page and try again.</h4>
                <form action='login.jsp'>
                    <input type='submit' class="btn btn-primary inline" value='Go Back' style="width: 200px;">
                </form>
            </div>
        </div>
    </body>
</html>
