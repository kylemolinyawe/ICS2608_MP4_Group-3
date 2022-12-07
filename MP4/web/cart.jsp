
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
    if(session.getAttribute("cart")==null)
{
    response.sendError(460);
    return;
}%>

<!DOCTYPE html>
<html class="h-100">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body class="h-100">
        <div class="container-fluid h-100">
            
            <!-- nav bar -->
            <div class="row">
                <jsp:include page="includes/nav.jsp" />
            </div>
        
            <!-- secondary nav bar -->
            <div class="row navbar navbar-expand bg-secondary" style="height: 40px;">
                <div class="container-fluid w-75 ps-3 pe-3">
                    <ul class="nav nav-pills">  
                        <li class="nav-item">
                            <a class="nav-link link-black" href="ShopServlet?category=All">< Continue Ordering</a>
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
                        <div class="col-sm-7">
                            <label>PRODUCT</label>
                        </div>

                        <!-- quantity column -->
                        <div class="col-sm-3">
                            <label>QUANTITY</label>
                        </div>

                        <!-- price/total column -->
                        <!-- TODO: align right -->
                        <div class="col-sm-2" style="text-align: right;">
                            <label>TOTAL</label>
                        </div>
                    </div>  
                    <hr>
                    
                    <%
                        ArrayList<Product> cart = (ArrayList<Product>)session.getAttribute("cart");
                                         
                        // case for when an item is being added to the cart for the first time
                        if(cart != null && cart.size()>0){
                                               
                            for(int i=0; i<cart.size(); i++){

                            String productName = cart.get(i).getName();
                            String imgURL = cart.get(i).getImgURL();
                            Double productPrice = cart.get(i).getPrice();
                            int productQuantity = cart.get(i).getQuantity();              
                            int productId = cart.get(i).getId();
                            double basePrice = cart.get(i).getBasePrice();                                                      
                    %>                   
                    <!-- row in the products list -->
                    <div class="row mb-3">
                        <!-- product name column -->
                        <div class="col-sm-7 d-flex flex-row">

                            <!-- image frame -->
                            <div class="bg-secondary me-3" style="width: 100px; height: 100px">
                                <img src="<%=imgURL%>" class="img-fluid h-100 w-100">
                            </div>
                            
                            <div class="d-flex flex-column">
                                <h5 class="mb-0"><%=productName%></h5>
                                <label class="text-gray">₱ <%=basePrice%></label>
                            </div>
                            
                        </div>

                        <!-- quantity column -->
                        <div class="col-sm-3 d-inline-flex">

                            <!-- hidden form for decrementing or adding to the quantity -->
                            <!-- decrement product quantity -->
                            <form action="CartServlet" method="post" style="width: 12px; height:12px;">
                                <input type="hidden" name="operation" value="decrement">
                                <input type="hidden" name="id" value="<%=productId%>">
                                <input type="image" name="submit" src="image/minus-sign.png" style="width: 12px; height: 12px;">
                            </form>
                                
                            <!-- current product quantity -->   
                            <label class="me-4 ms-4"><%=productQuantity%></label>
                                
                            <!-- increment product quantity --> 
                            <form action="CartServlet" method="post" style="width: 12px; height:12px;">
                                <input type="hidden" name="operation" value="increment">
                                <input type="hidden" name="id" value="<%=productId%>">
                                <input type="image" name="submit" src="image/plus-sign.png" style="width: 12px; height: 12px;">
                                
                            <!-- remove from cart -->
                            </form>
                                <form action="CartServlet" method="post" class="ms-5" style="width: 12px; height:12px;">
                                <input type="hidden" name="operation" value="remove">
                                <input type="hidden" name="id" value="<%=productId%>">
                                <input type="image" name="submit" src="image/trash-can.png" style="width: 12px; height: 12px;">                                       
                            </form>
                                
                        </div>

                        <!-- price/total column -->
                        <div class="col-sm-2">
                            <h5 class="text-end">₱ <%=productPrice%></h5>
                        </div>
                    </div>

                    
                    <%
                            }
                        } 

                        // case for when cart is empty
                        else{
                    %>
                            <!-- product name column -->
                                <div class="col-sm-7 d-flex flex-row">
                                    <label>Your cart is empty.</label>
                                </div>

                                <!-- quantity column -->
                                <div class="col-sm-3">
                                    <label></label>
                                </div>

                                <!-- price/total column -->
                                <div class="col-sm-2">
                                    <label></label>
                                </div>
                            </div>
                    
                    <%
                        }
                    %>  
                    
                    <%
                      Double cartTotal = (Double)session.getAttribute("total");  
                    %>
                    <hr>
                    <!-- footer row -->
                    <div class="row">
                        <div class="col-sm-7 d-flex flex-row">
                            
                        </div>
                        <div class="col-sm-3 d-inline-flex">
                            
                        </div>
                        <div class="col-sm-2 d-flex flex-column">
                            <h5 class="text-end">₱ <%=cartTotal%></h5>
                            
                            <form action='CheckoutServlet'>
                                  <input type='hidden' name='submit' value='ok'>
                                  <input type='submit' class='btn btn-primary w-100 mt-3' value='Checkout'>
                            </form>
                            
                        </div>                                             
                    </div>
                        
                </div>                 
            </div>
                
        </div>        
    </body>
</html>
