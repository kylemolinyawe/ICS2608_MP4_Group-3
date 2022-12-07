<%-- 
    Document   : emptyCartError
    Created on : Dec 7, 2022, 2:24:21 PM
    Author     : Dark Autumnn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="true"%>
<!DOCTYPE html>
<html style="height:100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empty Cart!</title>
        <link rel="styleesheet" href="main.css"><link rel="styleesheet" href="main.css">
    </head>
    <body style="height:100%">
        <div class="d-flex justify-content-center text-center" style="height: 100%;">
            <div class="border p-4 rounded-4 d-flex flex-column justify-content-center" style="height: 140px; margin-top:200px;">
                <h4 class="mb-3">An issue has occurred within accessing the server's files, please try to visit later.</h4>
                <form action='landing.jsp'>
                    <input type='submit' class="btn btn-primary inline" value='Back to Landing' style="width: 200px;">
                </form>
            </div>
        </div>
    </body>
</html>
