<!-- 
TODO:
Apply HTTPSession Object
Display incorrect credentials when login fails
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! 
protected boolean checkExistingLogin(HttpServletRequest request,HttpServletResponse response)
{
        HttpSession session = request.getSession();
         String uname = (String)session.getAttribute("name");
         if(uname!=null)
         {
             return true;
         }
         else
             return false;
}
%>
<% response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    if(checkExistingLogin(request,response))
{       
    response.sendError(462);
    return;
}
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/login.css">
    </head>
    <body>
        <div class="frame">
            <h3>Log In</h3>
            <form method="POST" action="LoginServlet">              
                <input type ="text" name="username" id="username" placeholder="USERNAME" required>
                <input type ="text" name="password" id="password" placeholder="PASSWORD" required>
                <input type="submit" value="LOG IN">
            </form>
            <p>New to Website? Proceed as <a href="ShopServlet?category=All">Guest</a></p>
        </div>
    </body>
</html>
