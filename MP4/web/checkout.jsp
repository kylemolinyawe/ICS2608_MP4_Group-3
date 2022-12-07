<%-- 
    Document   : checkout
    Created on : 11 27, 22, 11:22:54 PM
    Author     : Kyle Molinyawe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <% 
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
       if(session.getAttribute("name")==null)
        {
            response.sendError(401);
            return;
        }
        if(session.getAttribute("cart")==null)
    {
        response.sendError(460);
        return;
    }
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Success!</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
        
    <body style="height:100%">
        <div class="d-flex justify-content-center text-center" style="height: 100%;">
            <div class="border p-4 rounded-4 d-flex flex-column justify-content-center" style="height: 140px; margin-top:200px;">
                <h4>Your order is on the way!</h4>
                <h4 class="mb-3">Your total is ₱ <%=request.getAttribute("total")%> </h3>
                <form action='login.jsp'>
                    <input type='submit' class="btn btn-primary inline" style="width: 200px;">
                </form>
            </div>
        </div>
    </body>
</html>
