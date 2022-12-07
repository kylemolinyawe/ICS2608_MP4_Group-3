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
                // session does not exists
                if(session.getAttribute("cart") == null){
            %>
                    <li class=nav-item><a class="nav-link link-light" href=login.jsp>Login</a></li>
            <%
                }
                // session exists (succesful login)
                else{        
            %>             
                    <li class=nav-item>
                        <a class="nav-link link-light" href="LogoutServlet">Logout</a>
                    </li>
                    <li class=nav-item>
                        <a class="nav-link link-light" href="cart.jsp">Cart</a>
                    </li>                  
            <%
                }
            %>
        </ul>
    </div>
</nav>
