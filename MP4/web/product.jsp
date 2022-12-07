<%-- 
TODO:
Product page contains the name of the product, the product’s description, and the category of the product.
Has ‘Qty.’ buttons and an ‘Add to Cart’ button
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    if(session.getAttribute("name")==null)
    {
        response.sendError(401);
        return;
    }
%>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Name</title>
        <link rel="stylesheet" href="includes/nav.css">
        <link rel="stylesheet" href="shop.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body class="h-100">
        <div class="container-fluid h-100">
            
            <div class="row fixed-top">
                <!-- nav bar -->
                <div>
                    <jsp:include page="includes/nav.jsp" />
                </div>

                <!-- secondary nav bar -->
                <div class="navbar navbar-expand bg-secondary" style="height: 40px;">
                    <div class="container-fluid w-75 ps-3 pe-3">
                        <ul class="nav nav-pills">  
                            <li class="nav-item">
                                <a class="nav-link link-black" href="ShopServlet?category=All">< Back</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <!-- main content -->
            <div class="row h-100 w-75 ps-2 pe-2 mx-auto" style="margin-top: 140px;">
                
                <%

                    Product product = (Product)session.getAttribute("product");

                    int productId = product.getId();
                    String productName = product.getName();
                    String imgURL = product.getImgURL();
                    double productPrice = product.getBasePrice();
                    String productDescription = product.getDescription();
                    int productQuantity = product.getQuantity();
                        
                %>
                    
                    <!-- image frame -->
                    <div class="col-sm-7 h-100 p-3">
                        <div class="bg-black w-100" style="height:600px">
                            <img src="<%=imgURL%>" class="img-fluid h-100 w-100">
                        </div>
                    </div>     
                                                         
                    <!-- product information panel -->
                    <div class="col-sm-5 h-100 p-3 d-flex flex-column">
                        <h1><%= productName %></h1>
                        <h4>₱ <%= productPrice %></h4>
                        
                        <label class="mt-4 mb-2">Quantity</label>                        
                        <div class="col-sm-6 d-inline-flex mb-5">
                            <!-- decrement product quantity -->
                            <form action="ProductServlet" method="post" style="width: 12px; height:12px;">
                                <input type="hidden" name="operation" value="decrement">
                                <input type="hidden" name="id" value="<%=productId%>">
                                <input type="image" name="submit" src="image/minus-sign.png" style="width: 12px; height: 12px;">
                            </form>
                                
                            <!-- current product quantity -->   
                            <label class="me-4 ms-4"><%=productQuantity%></label>
                                
                            <!-- increment product quantity --> 
                            <form action="ProductServlet" method="post" style="width: 12px; height:12px;">
                                <input type="hidden" name="operation" value="increment">
                                <input type="hidden" name="id" value="<%=productId%>">
                                <input type="image" name="submit" src="image/plus-sign.png" style="width: 12px; height: 12px;">
                            </form>                            
                        </div>
                                
                        <!-- hidden form field for submit button -->
                        <form action="CartServlet" method="post" class="mb-4">
                            <input type="hidden" name="id" value="<%=productId%>">
                            <input type="hidden" name="quantity" value="<%=productQuantity%>">
                            <input type="submit" class="btn btn-primary w-100" value="Add to Cart">
                        </form>
                            
                        <p><%= productDescription %></p>
                        
                    </div>
                    
            </div>          
        </div>
    </body>
</html>
