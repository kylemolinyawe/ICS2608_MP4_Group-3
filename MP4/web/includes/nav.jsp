<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
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
                // session exists (succesful login)
                if(request.getSession(false) != null){        
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
                        <% if(session.getAttribute("cart")==null)
                            {
                         %>
                          <a class="nav-link link-light" href="CartServlet">Cart</a>
                        <%
                            }
                            else
                            {
                                int qty=0;
                                ArrayList<Product> s =(ArrayList<Product>)session.getAttribute("cart");
                                for(Product p: s)
                                {
                                    qty+=p.getQuantity();
}
                        %>
                        <a class='nav-link link-light' href="CartServlet">Cart (<%=qty%>)</a>
                        <%
                            }
                        %>
                    </li>                  
            <%
                }
            %>
            
            <%
                // session does not exists
                if(request.getSession(false) == null){
            %>
                    out.print("<li class=nav-item><a href=login.jsp>Login</a></li>"); 
            <%
                }
            %>

        </ul>
    </div>
</nav>
