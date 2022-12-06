
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session.getAttribute("cart")==null)
{
    response.sendRedirect("ShopServlet?category=All");
    return;
}%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="nav-bar" href="includes/nav-bar.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body class="h-100">
        <div class="container-fluid h-100">
            
            <!-- nav bar -->
            <div class="row">
                <jsp:include page="includes/nav.jsp" />
            </div>
        
            <!-- secondary nav bar -->
            <div class="row navbar navbar-expand bg-light" style="height: 40px;">
                <div class="container-fluid w-75 ps-3 pe-3">
                    <ul class="nav nav-pills">  
                        <li class="nav-item">
                            <a class="nav-link link-dark" href="ShopServlet?category=All">< Back</a>
                        </li>
                    </ul>
                </div>
            </div>
        
            <!-- main content -->
            <div class="row h-100 w-75 ps-2 pe-2 mx-auto">
                
                <!-- header -->
                <div class="row">
                    <h2 class="mt-3 mb-3">My Cart</h2>
                </div>
                
                <!-- cart -->
                <div class="container-fluid h-100">
                    
                    <!-- header row -->
                    <div class="row">
                        <!-- product column -->
                        <div class="col-sm-8">
                            <label>PRODUCT</label>
                        </div>

                        <!-- quantity column -->
                        <div class="col-sm-3">
                            <label>QUANTITY</label>
                        </div>

                        <!-- price/total column -->
                        <!-- TODO: align right -->
                        <div class="col-sm-1">
                            <label>TOTAL</label>
                        </div>
                    </div>  
                    <hr>
                    
                    <%
                        ArrayList<Product> cart = (ArrayList<Product>)session.getAttribute("cart");

                        for(int i=0; i<cart.size(); i++){

                        String productName = cart.get(i).getName();
                        Double productPrice = cart.get(i).getPrice();
                        int productQuantity = cart.get(i).getQuantity();                                            
                    %>
                    
                    <!-- products list -->
                    <div class="row">
                        <!-- product name column -->
                        <div class="col-sm-8 d-flex flex-row">
                            <div class="bg-primary" style="width: 100px; height: 100px">
                            </div>
                            <label><%=productName%></label>
                        </div>

                        <!-- quantity column -->
                        <div class="col-sm-3">
                            <label><%=productQuantity%></label>
                        </div>

                        <!-- price/total column -->
                        <div class="col-sm-1">
                            <label><%=productPrice%></label>
                        </div>
                    </div>
                    <%
                        }
                    %>                   
                </div>
                    
            </div>
        </div>        
    </body>
</html>
