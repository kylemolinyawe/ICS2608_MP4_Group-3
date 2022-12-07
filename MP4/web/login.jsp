<!-- 
TODO:
Apply HTTPSession Object
Display incorrect credentials when login fails
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="login.css">
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
