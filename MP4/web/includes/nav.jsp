<!--
 TODO:
Change login to logout on successful login (done using sessions!)
So check for session using request.getSession(false) which returns null when there is no session
Now logout link address goes to a LogoutServlet which destroys the session returning to the shop page?
Display user on here?
-->
<nav> <!-- have the logo on the left side of the nav bar and a search bar-->
    <ul class="navigation">
       
        <%
            // session exists (succesful login)
            if(request.getSession(false) != null){        
            
                out.print("<li><a href=logout.jsp>Logout</a></li>");  
                
            }
                         
            // session does not exists
            else{
        
                out.print("<li><a href=login.jsp>Login</a></li>"); 
                
            }
        %>
        
        <li class="checkout"><a href="checkout.jsp">Checkout</a></li>
        
        
    </ul>
</nav>
