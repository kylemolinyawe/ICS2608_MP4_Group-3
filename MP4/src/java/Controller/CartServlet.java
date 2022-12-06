
package Controller;

import Model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kyle Molinyawe
 */
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        buy(request, response);
        
    }
    
    protected void buy(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        List<Product> products = Product.readProductsFile(this.getServletContext());
        
        HttpSession session = request.getSession();
                  
        // If no cart is found initialize one and add the item.
        if(session.getAttribute("cart") == null){
            List<Product> cart = new ArrayList<Product>();           
            int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), products);
            
            products.get(index).setQuantity(1);
            products.get(index).totalPrice();
            
            cart.add(products.get(index));           
            session.setAttribute("cart", cart);
        } 

        // If there is a cart get the cart from the session add the item
        // and set it back via the session attribute "cart"
        else{
            
            List<Product> cart = (ArrayList<Product>)session.getAttribute("cart");

            // case for adding a duplicate to the cart
            if(Product.exists(Integer.parseInt(request.getParameter("id")), (ArrayList<Product>)cart)){
                
                int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), products);

                Product product = cart.get(index);
                int currentQuantity = product.getQuantity();
                
                cart.get(index).setQuantity(++currentQuantity);
                cart.get(index).totalPrice();
                
                session.setAttribute("cart", cart);
                                              
            } 

            // case for distinct item being added to the cart
            else{
                int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), products);
                               
                products.get(index).setQuantity(1);        
                products.get(index).totalPrice();
                
                cart.add(products.get(index));
                session.setAttribute("cart", cart);
            }
        }                 
        
        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
               
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
