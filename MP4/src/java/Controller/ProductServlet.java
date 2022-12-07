
package Controller;

import Model.Product;
import java.io.IOException;
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
 * Servlet that forwards to cart.jsp
 * Uses a session attribute to keep track of the quantity of the product in the product.jsp
 * Used as a case for adding a duplicate item with quantity > 1 to the cart.
 * 
 */
public class ProductServlet extends HttpServlet {

     protected boolean verif(HttpServletRequest request) throws ServletException,IOException
    {
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("name");
        if(uname==null)
            return true;
        else
            return false;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();      
        RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
        
        // session attribute for keeping track of the quantity of the product in the product.jsp
        Product product = (Product)session.getAttribute("product");
        
        // case for quantity selector operations
        if(request.getParameter("operation") != null){
            
            String operation = request.getParameter("operation");
            
            switch(operation){
                case ("increment"):
                    
                    product.incrementQuantity();                   
                    session.setAttribute("product", product);     
                    rd.forward(request, response);
                    break;
                    
                case ("decrement"):
                    
                    if(product.getQuantity() > 1){
                        product.decrementQuantity();                    
                        session.setAttribute("product", product);
                        rd.forward(request, response);
                    } else{
                        rd.forward(request, response);
                    }                  
                    break;
                                    
            }
            
        // case for loading a product.jsp of a given shop.jsp item
        } else{
            // get id appended in url and build products list
            int searchId = Integer.parseInt(request.getParameter("id"));
            List<Product> products = Product.readProductsFile(this.getServletContext());      

            // search a product, returns an int representing the index
            int index = Product.searchProduct(searchId, products);            
            product = products.get(index);

            // set product to a sessionAttribute to keep track of quantity in product.jsp and in cart.jsp
            session.setAttribute("product", product);

            rd.forward(request, response);
        }
                       
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(verif(request))
        {
            response.sendError(401);
            return;
        }
        else
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(verif(request))
        {
            response.sendError(401);
            return;
        }
        else
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
