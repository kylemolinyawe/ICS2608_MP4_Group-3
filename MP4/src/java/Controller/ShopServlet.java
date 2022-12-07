
package Controller;

import Model.Product;
import java.io.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Kyle Molinyawe
 */

public class ShopServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             
    }
    
    // doGet when a user proceeds as a guest
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String category = request.getParameter("category");
               
        List<Product> products = Product.readProductsFile(this.getServletContext());
        
        if(category.matches("All")){
            request.setAttribute("products", products);
            RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
            rd.forward(request, response);
            return;
        }
  
        List<Product> sortedProducts = Product.sortByCategory(category, products);
        
        request.setAttribute("products", sortedProducts);
        
        RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
        rd.forward(request, response);
        
    }
    
    // doPost on a succesful login
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) // working fine
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Product> products = Product.readProductsFile(this.getServletContext());
        HttpSession session = request.getSession();
        
        // bind collection to request
        request.setAttribute("products", products);
        
        // user's cart
        ArrayList<Product> cart = new ArrayList<Product>();
        session.setAttribute("cart", cart);
            
        RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
        rd.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
