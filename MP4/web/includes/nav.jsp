<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<!--
n
-->
<nav class="navbar navbar-expand-lg bg-primary" style="height: 80px;">
    <div class="container-fluid w-75 ps-3 pe-3">
        
        <!-- website logo -->
        <img src="image/lasa-logo-white.png" style="height:50px;">
        
        
        <!-- website navigation links -->
        <ul class="nav navbar">
            <%                                                  
                // cart does not exist
                if(session.getAttribute("cart") == null){
            %>
                    <li class=nav-item><a class="nav-link link p-0" href=login.jsp>Login</a></li>
            <%
                }
                // cart exists (succesful login)
                else{        
            %>             
                    <li class="nav-item">   
                        <a class="nav-link main-nav-bar" href="LogoutServlet">Logout</a>
                    </li>
                    <%                        
                                int qty=0;
                                ArrayList<Product> s =(ArrayList<Product>)session.getAttribute("cart");
                                for(Product p: s)
                                {
                                    qty+=p.getQuantity();
                                }
                    %>
                    <li class=nav-item>                   
                        <a class="nav-link link-light ms-3 p-0" href="cart.jsp">Cart (<%=qty%>)</a>
                    </li>                  
            <%
                }
            %>
        </ul>
    </div>
</nav>
