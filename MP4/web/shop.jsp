<%-- 
TODO:
Panel display of items being sold in the online shop.
Can be filtered into specific categories (each category has a minimum of 5 items)
When an item is clicked, uses URL Rewriting to move to the product’s page.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="nav.css">
        <link rel="stylesheet" href="shop.css">
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <script> <!-- JQuery script for adding navbar -->
            $(function(){
              $("#nav-placeholder").load("nav.jsp");
            });
        </script>
    </body>
</html>
