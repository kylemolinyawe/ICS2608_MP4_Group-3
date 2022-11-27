<%-- 
TODO:
Panel display of items being sold in the online shop.
Can be filtered into specific categories (each category has a minimum of 5 items)
When an item is clicked, uses URL Rewriting to move to the product’s page.
Have each item displayed read from a item object file
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link rel="stylesheet" href="nav.css">
        <link rel="stylesheet" href="shop.css">
    </head>
    <body>
            <jsp:include page="includes/nav.jsp" />
        </script>
        <main>
            <section class="listings"> <!-- Java scriptlet for generating each item article -->
                
            <%
                
                // when using request.getAttribute there must be an explicit type conversion
                // to preserve the object's type when passed from servlet to JSP
                ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");       
                
                // create n product articles based on the size of the products collection
                for(int i = 0; i<products.size(); i++){
                    Product product = products.get(i);
                    
                    String productName = product.getName();
                    String imgURL = product.getImgURL();
                    double productPrice = product.getPrice();
                    String productDescription = product.getDescription();

                    out.print("<article class=item>");
                    out.print("<a href=item.jsp>");
                    out.print("<div class=frame>");
                    out.print("<img src=" + imgURL + ">");
                    out.print("</div>");
                    out.print("<p class=name>" + productName + "</p>");
                    out.print("<p class=price>PHP" + productPrice + "</p>");
                    out.print("</a>");
                    out.print("<p class=description>" + productDescription + "</p>");
                    out.println("</a>");
                    out.print("</article>");                  
                }
                                                
            %>                  
            </section>
        </main>
    </body>
</html>
