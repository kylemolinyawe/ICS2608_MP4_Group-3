<%-- 
TODO:
Panel display of items being sold in the online shop.
Can be filtered into specific categories (each category has a minimum of 5 items)
When an item is clicked, uses URL Rewriting to move to the product’s page.
Have each item displayed read from a item object file
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); %>
<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link rel="nav-bar" href="includes/nav-bar.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    </head>
    <body class="h-100">
        <div class="container-fluid h-100">
            
            <!-- nav bar -->
            <div class="row">
                <jsp:include page="includes/nav.jsp" />
            </div>
        
            <!-- categories bar -->
            <div class="row" style="height: 40px;">
                <div class="container-fluid w-75 ps-3 pe-3 navbar navbar-fixed-top p-0 bg-light">
                    <ul class="nav nav-pills">
                        

                        
                        <%
                            // scriptlet that sets currentcategory to what is currently in the request.getParameter("category")
                            // which allows for each nav-item to be dynamically active on the website
                            String currentCategory;
                            if(request.getParameter("category") != null){
                                currentCategory = request.getParameter("category");
                            } else{
                                currentCategory = "All";
                            }                       
                        %>
                        <li class="nav-item">
                            <a class="nav-link rounded-0 <%if(currentCategory.contains("All")){out.print("active text-light");}else{out.print("text-dark");}%>" 
                            href="ShopServlet?category=All">All</a>
                        </li>      
                        <li class="nav-item">
                            <a class="nav-link rounded-0 <%if(currentCategory.contains("Breakfast")){out.print("active text-light");}else{out.print("text-dark");}%>" 
                            href="ShopServlet?category=Breakfast">Breakfast</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link rounded-0 <%if(currentCategory.contains("Pastry")){out.print("active text-light");}else{out.print("text-dark");}%>"
                            href="ShopServlet?category=Pastry">Pastry</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link rounded-0 <%if(currentCategory.contains("Drinks")){out.print("active text-light");}else{out.print("text-dark");}%>" 
                            href="ShopServlet?category=Drinks">Drinks</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        
            <!-- main content -->
            <div class="row h-100 w-75 ps-2 pe-2 mx-auto">
                
                <!-- products panel -->
                <div class="container- fluid border d-inline-flex d-row justify-content-start pt-3" style="flex-wrap: wrap;">    
                    
                    <!--  scriptlet which generates each product on the website -->
                    <%
                        
                        // when using request.getAttribute there must be an explicit type conversion
                        // to preserve the object's type when passed from servlet to JSP    
                        ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");
                        // create n product articles based on the size of the products collection
                        for(int i = 0; i<products.size(); i++){

                            Product product = products.get(i);
                            
                            int productId = product.getId();
                            String productName = product.getName();
                            String imgURL = product.getImgURL();
                            double productPrice = product.getBasePrice();
                            String productDescription = product.getDescription();
                            String productCategory = product.getCategory();
                            
                    %>                  
                            <!-- products container -->
                            <div class="border p-3 ms-3 mb-3 rounded-3" style="width: 250px; height: 410px;">
                                
                                <!-- image frame -->
                                <div class="bg-secondary" style="width: 100%; height: 200px;">
                                    <img src="<%= imgURL %>">
                                </div>

                                <!-- product name -->
                                <!-- NOTE: account longest product name for final height -->
                                <div class="container-fluid p-0 pt-3" style="height: 75px">
                                    <h5 class=name><%= productName %></h5>
                                </div>
                                <hr>

                                <!-- product price and order button -->
                                <div class="container-fluid p-0"  style="height:">
                                    <p class="fw-bold p-0 m-0 mb-3">PHP <%= productPrice %></p>
                                    <% if(session.getAttribute("cart") == null){ %>
                                    <a href="login.jsp">
                                        <button class="btn btn-primary w-100">Order</button>
                                    </a>
                                    
                                    <% } else{%>   
                                    <a href="ProductServlet?id=<%=productId%>">
                                        <button class="btn btn-primary w-100">Order</button>
                                    </a>
                                    <% }%>
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
