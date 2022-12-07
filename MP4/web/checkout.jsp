<%-- 
    Document   : checkout
    Created on : 11 27, 22, 11:22:54 PM
    Author     : Kyle Molinyawe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Success!</title>
    </head>
    <body>
        <h1>Hello World! Your total is <%=request.getAttribute("Total").toString() %></h1>
    </body>
</html>
