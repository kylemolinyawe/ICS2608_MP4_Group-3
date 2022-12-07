
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
 * Handles request from LoginServlet.java and from itself.
 * Generates product panels based on the values found in files/products.csv
 * As well as including categories that render only products with the matching category.
 * 
 * Differentiates user and guest from doPost and doGet methods respectively.
 * A successful login from login.jsp uses a form with action post and creates a session cart
 * Access from a guest goes through doGet
 * 
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
        
        if(category.matches("All")||category==null){
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
