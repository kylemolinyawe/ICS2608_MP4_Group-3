<!--
 TODO:
Change login to logout on successful login (done using sessions!)
So check for session using request.getSession(false) which returns null when there is no session
Now logout link address goes to a LogoutServlet which destroys the session returning to the shop page?
Display user on here?
-->
<nav class="navbar navbar-expand-lg bg-secondary" style="height: 70px;">
    <div class="container-fluid w-75 ps-3 pe-3">
        
        <!-- website logo -->
        <h3 class="text-light">branding here</h3>
        
        
        <!-- website navigation links -->
        <ul class="nav navbar">
            <%
                // session does not exists
                if(request.getSession(false) == null){
            %>
                    <li class=nav-item><a href=login.jsp>Login</a></li>
            <%
                }
            %>
            
            <%
                // session exists (succesful login)
                if(request.getSession(false) != null){        
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
