<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<!--
n
-->
<nav class="navbar navbar-expand-lg bg-secondary" style="height: 70px;">
    <div class="container-fluid w-75 ps-3 pe-3">
        
        <!-- website logo -->
        <h3 class="text-light">branding here</h3>
        
        
        <!-- website navigation links -->
        <ul class="nav navbar">
            <%                                                  
                // cart does not exist
                if(session.getAttribute("cart") == null){
            %>
                    <li class=nav-item><a class="nav-link link-light" href=login.jsp>Login</a></li>
            <%
                }
                // cart exists (succesful login)
                else{        
            %>             
                    <li class=nav-item>
                        <%
                            if(session.getAttribute("name")==null)
                            {
                         %>
                         <a class='nav-link link-light' href='login.jsp'>Login</a>
                         <%       
                            }
                            else
                            {
                        %>
                        <a class="nav-link link-light" href="LogoutServlet">Logout</a>
                        <%  } %>
                    </li>
                    <li class=nav-item>
                    <%                        
                                int qty=0;
                                ArrayList<Product> s =(ArrayList<Product>)session.getAttribute("cart");
                                for(Product p: s)
                                {
                                    qty+=p.getQuantity();
                                }
                    %>
                        <a class="nav-link link-light" href="cart.jsp">Cart (<%=qty%>)</a>

                    </li>                  
            <%
                }
            %>
        </ul>
    </div>
</nav>
