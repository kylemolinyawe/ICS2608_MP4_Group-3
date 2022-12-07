<!DOCTYPE html>
<html style="min-height: 100%; height: 100%">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/main.css">
    </head>   
    <body style="margin: 0; height: 100%; max-height: 100%">
        <div class="container-fluid h-100">
            <div class="row h-100">
                
                <!-- TODO: add image here as background -->
                <div class="col bg-primary">
                </div>
                
                <!-- Login panel -->
                <div class="col-sm-5 pt-5">
                    <div class="h-75 w-75 m-3 mt-5 p-5 mx-auto">
                        <div class="mb-5">
                            <h1 class="">Login</h1>
                            <p>Welcome to Lasa</p>
                        </div>
                        <form class="mb-5" method="POST" action="LoginServlet">
                            <div class="mb-3">
                                <input type="text" class="form-control form-control-lg" id="username" name="username" placeholder="Username" required>
                            </div>
                            <div class="mb-3">
                                <input type="text" class="form-control form-control-lg" id="password" name="password" placeholder="Password" required>
                            </div>
                            <div class="mt-4 mb-3">
                                <button type="submit" class="btn btn-primary w-100 form-control-lg">Login</button>
                            </div>                           
                        </form>
                        <div class="text-lg-end">
                            <p>Proceed as a <a href="ShopServlet?category=All" class="text-decoration-none link-primary">Guest</a></p>
                        </div>
                    </div>
                </div>
                
            </div>          
        </div>
    </body>
</html>
