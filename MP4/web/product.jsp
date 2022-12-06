<%-- 
TODO:
Product page contains the name of the product, the product’s description, and the category of the product.
Has ‘Qty.’ buttons and an ‘Add to Cart’ button
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h-100">
    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Name</title>
        <link rel="stylesheet" href="includes/nav.css">
        <link rel="stylesheet" href="shop.css">
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
                
                <%
                    // get the product index and products list
                    int index = (Integer)request.getAttribute("index");
                    ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");

                    Product product = products.get(index);

                    int productId = product.getId();
                    String productName = product.getName();
                    String imgURL = product.getImgURL();
                    double productPrice = product.getBasePrice();
                    String productDescription = product.getDescription();
                    String productCategory = product.getCategory(); 
                        
                %>
                    
                    <!-- image panel -->
                    <div class="col-sm-6 h-100 p-3">
                        <div class="bg-secondary w-100" style="height:500px">
                            
                        </div>
                    </div>     
                                                         
                    <!-- product information panel -->
                    <div class="col-sm-6 h-100 p-3 d-flex flex-column">
                        <h2><%= productName %></h2>
                        <h4>PHP <%= productPrice %></h4>
                        
                        <!-- hidden form field -->
                       <form action="CartServlet" method="post">
                            <input type="hidden" name="id" value="<%=productId%>">
                            <input type="submit" class="btn btn-primary" value="Add to Cart">
                        </form>
                            
                        <p><%= productDescription %>e</p>
                    </div>
                    
            </div>          
        </div>
    </body>
</html>
