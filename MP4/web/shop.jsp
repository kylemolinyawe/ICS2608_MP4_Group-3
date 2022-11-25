<%-- 
TODO:
Panel display of items being sold in the online shop.
Can be filtered into specific categories (each category has a minimum of 5 items)
When an item is clicked, uses URL Rewriting to move to the product’s page.
Have each item displayed read from a item object file
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="nav.css">
        <link rel="stylesheet" href="shop.css">
    </head>
    <body>
        <div id="nav-placeholder"></div>
        <script> <!-- JQuery script for adding navbar -->
            $(function(){
              $("#nav-placeholder").load("nav.jsp");
            });
        </script>
        <main>
            <section class="listings"> <!-- Java scriptlet for generating each item article -->
            <%
                String displayName = "John Doe";
                String datePublished = "17 hours ago";
                String imgFilePath = "https://cdn.discordapp.com/attachments/751354918782238770/1038410899368710224/image.png";
                String itemName = "NUOWA M6 Smart Fashion Sports Women Watch";
                int itemPrice = 2499;

                for(int i = 1; i<=8; i++)
                {
                    out.print("<article class=item>");
                    out.print("<a href=item.jsp>");
                    out.print("<p class=user>" + displayName + "</p>");
                    out.print("<p class=datePublished>" + datePublished + "</p>");
                    out.print("<div class=frame>");
                    out.print("<img src=" + imgFilePath + ">");
                    out.print("</div>");
                    out.print("<p class=name>" + itemName + "</p>");
                    out.print("<p class=price>PHP" + itemPrice + "</p>");
                    out.println("</a>");
                    out.print("</article>");
                }
            %>                  
            </section>
        </main>
    </body>
</html>
