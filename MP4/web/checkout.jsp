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
    </head>
    <body>
        <h1>Your order is on the way!</h1>
        <h3>Your total is <%=request.getAttribute("total")%></h3>
    </body>
</html>
