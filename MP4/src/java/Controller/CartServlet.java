
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
 * Servlet that handles requests from product.jsp and from itself
 * Such as decrementing, incrementing product quantity.
 * And removing the product from the cart.
 * 
 */
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                         
        HttpSession session = request.getSession();
        String operation = request.getParameter("operation");
        
        // case for adding cart products from the product.jsp page
        if(operation == null){
            addToCart(request, response, session);
            
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            rd.forward(request, response);
        }
        
        // case for removing a product, incrementing decrementing quantity, from cart.jsp
        else{
            int productId = Integer.parseInt(request.getParameter("id"));  
            ArrayList<Product> cart = (ArrayList<Product>)session.getAttribute("cart");
            
            int index;
            RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
            
            // evaluates the operation string and either increment or decrements the quantity
            // or remove the product entirely from the cart
            switch(operation){
                case "increment":
                    
                    index = Product.searchProduct(productId, cart);
                    
                    cart.get(index).incrementQuantity();                   
                    cart.get(index).updateTotalPrice();
                                      
                    session.setAttribute("total", getTotal(cart));
                    session.setAttribute("cart", cart);
                    
                    rd.forward(request, response);
                    
                    break;
                
                case "decrement":
                    
                    index = Product.searchProduct(productId, cart);
                    cart.get(index).decrementQuantity();
                    
                    // case for decrementing and removing the final product
                    if(cart.get(index).isQuantityZero()){
                        
                        cart.remove(index);
                        
                        rd.forward(request, response);
                                           
                    } else{
                        
                        if(cart.isEmpty()){

                           rd.forward(request, response);

                        } else{
                           cart.get(index).updateTotalPrice();                   

                           session.setAttribute("total", getTotal(cart));
                           session.setAttribute("cart", cart);

                           rd.forward(request, response);
                        }
                        
                    }
                                                                                               
                   break;
                                            
                case "remove":
                    
                    index = Product.searchProduct(productId, cart);
                    cart.remove(index);
                    
                    // case for removing the final product
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
        Product product = (Product)session.getAttribute("product");
        
        // case for adding a duplicate product
        if(Product.exists(Integer.parseInt(request.getParameter("id")), (ArrayList<Product>)cart)){
            
            // get quantity from product inside the cart
            int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), cart);
            Product cartProduct = cart.get(index);
            
            Product sessionProduct = (Product)session.getAttribute("product");
            
            // add cart product quantity with session produict quantity
            cartProduct.setQuantity(cartProduct.getQuantity() + sessionProduct.getQuantity());
            cartProduct.updateTotalPrice();

            session.setAttribute("total", getTotal(cart));
            session.setAttribute("cart", cart);

        } 

        // case for distinct item being added to the cart
        else{
                      
            product.updateTotalPrice();
            
            cart.add(product);

            session.setAttribute("total", getTotal(cart));
            session.setAttribute("cart", cart);
        }
            

    }
        
    
    protected void buy(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
       
        Double TotalPrice = 0.0;
        HttpSession session = request.getSession();
        List<Product> productList = (ArrayList<Product>)session.getAttribute("cart");
        for(Product p: productList)
        {
            TotalPrice += p.getPrice();
        }
        System.out.println("you reached here 1");
        request.setAttribute("Total", TotalPrice);
        System.out.println("here 2");
        RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
        rd.forward(request, response);
        
    }
    
    protected boolean verif(HttpServletRequest request) throws ServletException,IOException
    {
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("name");
        if(uname!=null)
            return true;
        else
            return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(!(verif(request)))
        {
            //To do: redirect to an error page showing "You need to be logged in to access the cart."
            String param = request.getParameter("id");
            response.sendRedirect("login.jsp?id="+param);
            return;
        }
        else
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(!(verif(request)))
        {
            //To do: redirect to an error page showing "You need to be logged in to access the cart."
            String param = request.getParameter("id");
            response.sendRedirect("login.jsp?id="+param);
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
