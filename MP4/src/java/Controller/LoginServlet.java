package Controller;



import Model.Product;
import Model.User;
import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Login controller servlet which validates the user's credentials when trying to login.
 * And forwards them to the appropriate pages.
* 
 * @author Kyle Molinyawe
 */
public class LoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // building collection of user objects from the file users.txt
        // TODO: remember why its necessary to add a ServletContext parameter to the file read method
        List<User> users = User.readUsersFile(this.getServletContext());
        
        // get form data from client
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // successful login
        if(User.validateUsername(users, username) && User.validatePassword(users, password)){
            RequestDispatcher rd = request.getRequestDispatcher("ShopServlet");  
            
            // create a session whose name is the username of the customer
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            
            // user's cart
            ArrayList<Product> cart = new ArrayList<Product>();
            session.setAttribute("cart", cart);
            
            rd.forward(request, response);
        }    
        
        // failed login
        else{ 
            RequestDispatcher rd = request.getRequestDispatcher("failed.jsp");  
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
