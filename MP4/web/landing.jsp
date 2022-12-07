<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="min-height: 100%; height: 100%">
    <head>
        <title>Landing</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="css/main.css">
    </head>
    
    <body style="margin: 0; height: 100%; max-height: 100%">
        <div class="container-fluid h-100">
            <div class="row">
                <jsp:include page="includes/nav.jsp" />
            </div>
            
            <!-- main content -->         
            <div class="row h-100 w-75 p-0 mx-auto">
                
                <!-- header text and description -->
                <div class="col-sm-6 ps-3 pe-3">
                    <h1 class="mt-5">Serving contemporary Filipino cuisine.</h1>
                    <p class="mb-4">Lasa is a contemporary Filipino restaurant tucked away in a corner of Chino Roces Avenue in Makati. It’s helmed by Chef Jordy Navarra, who had previously trained at The Fat Duck in the UK and Bo Innovation in Hong Kong before opening Lasa in March 2016.</p>
                    <a href="ShopServlet?category=All" class="btn btn-primary col-auto form-control-lg">View Menu</a>
                </div>
                
                <!-- image column -->
                <div class="col-sm-6 bg-black p-0">
                    <img src="image/lasa-mockup.png" class="img-fluid w-100">
                </div>
                
            </div>
        </div>
    </body>
</html>
