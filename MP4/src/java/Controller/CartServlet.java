
package Controller;

import Model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
                         
        HttpSession session = request.getSession();
        String operation = request.getParameter("operation");
        
        
        if(operation == null){
            addToCart(request, response, session);
            
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);
        }
        
        
        else{
            int productId = Integer.parseInt(request.getParameter("id"));  
            ArrayList<Product> cart = (ArrayList<Product>)session.getAttribute("cart");
            
            int index;
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            
            switch(operation){
                case "increment":
                    
                    index = Product.searchProduct(productId, cart);
                    
                    cart.get(index).incrementQuantity();                   
                    cart.get(index).totalPrice();
                                      
                    session.setAttribute("total", getTotal(cart));
                    session.setAttribute("cart", cart);
                    
                    rd.forward(request, response);
                    
                    break;
                    
                case "decrement":
                    
                    index = Product.searchProduct(productId, cart);
                    cart.get(index).decrementQuantity();
                    
                    if(cart.get(index).isQuantityZero()){
                        
                        cart.remove(index);
                        
                        rd.forward(request, response);
                                             
                    } else{
                        
                        if(cart.isEmpty()){

                           rd.forward(request, response);

                        } else{
                           cart.get(index).totalPrice();                   

                           session.setAttribute("total", getTotal(cart));
                           session.setAttribute("cart", cart);

                           rd.forward(request, response);
                        }
                        
                    }
                                                                                               
                   break;
                                            
                case "remove":
                    
                    index = Product.searchProduct(productId, cart);
                    cart.remove(index);
                    
                    if(cart.isEmpty()){
                        
                        rd.forward(request, response);
                        
                    } else{

                        session.setAttribute("total", getTotal(cart));
                        session.setAttribute("cart", cart);

                        rd.forward(request, response);
                        
                    }
                 
                    break;
            }
            
        }
        

        /* not working for me - molinyawe
        response.sendRedirect("CartServlet?id="+id);
       */
             
    }
    
    protected double getTotal(ArrayList<Product>cart){
        
        double total = 0;
        
        for(Product p: cart){
            total += p.getBasePrice() * p.getQuantity();
        }
        
        return total;
        
    }
    
    
    protected void addToCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException{
        List<Product> products = Product.readProductsFile(this.getServletContext());
        ArrayList<Product> cart = (ArrayList<Product>)session.getAttribute("cart");
        
        if(Product.exists(Integer.parseInt(request.getParameter("id")), (ArrayList<Product>)cart)){

            int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), products);

            Product product = cart.get(index);
            int currentQuantity = product.getQuantity();

            cart.get(index).setQuantity(++currentQuantity);
            cart.get(index).totalPrice();

            session.setAttribute("total", getTotal(cart));
            session.setAttribute("cart", cart);

        } 

        // case for distinct item being added to the cart
        else{
            int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), products);

            products.get(index).setQuantity(1);        
            products.get(index).totalPrice();

            cart.add(products.get(index));

            session.setAttribute("total", getTotal(cart));
            session.setAttribute("cart", cart);
        }
            
    }
        
        
                                                                                 
    protected void buy(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        //To add: check out cart and display results in a separate jsp file
        Double TotalPrice = 0.0;
        HttpSession session = request.getSession();
        List<Product> productList = (ArrayList<Product>)session.getAttribute("cart");
        for(Product p: productList)
        {
            TotalPrice += p.getPrice();
        }
        
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
