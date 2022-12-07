
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
        
        String id = request.getParameter("id");
        String submit=request.getParameter("submit");
        //Only adds an item to cart without going to the cart page
        if(id!=null&&Integer.parseInt(id)>0 && Integer.parseInt(id)<17)
        {
             add(request, response);
             response.sendRedirect("ProductServlet?id="+id);
        }
        else if(request.getSession().getAttribute("cart")==null)
        {
            //should redirect to an error page that says the user's cart is empty.
            response.sendError(460);
            return;
        }
        //if user is already in the cart page and is checking out their cart
        else if(request.getSession().getAttribute("cart")!=null&&submit!=null)
        {
               buy(request,response);
               System.out.println("Valid");
        }
        else //redirect user to their cart page
        {
            response.sendRedirect("cart.jsp");
        }
       
        
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
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
                
                int index = Product.searchProduct(Integer.parseInt(request.getParameter("id")), cart);
                
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
        request.setAttribute("Total", TotalPrice);
        RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
        rd.forward(request, response);
        
    }
    
    protected boolean verif(HttpServletRequest request) throws ServletException,IOException
    {
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("name");
        if(uname==null)
            return true;
        else
            return false;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(verif(request))
        {
            
            String param = request.getParameter("id");
            if(param==null)
            {
                response.sendError(401);
                return;
            }
            else //instead of an error page redirects to the login page
            response.sendRedirect("login.jsp?id="+param);
            return;
        }
        else
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(verif(request))
        {
            String param = request.getParameter("id");
            if(param==null)
            {
                response.sendError(401);
                return;
            }
            else //instead of an error page redirects to the login page
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
