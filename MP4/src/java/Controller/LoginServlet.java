package Controller;



import Model.Product;
import Model.User;
import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *  
 * @author Kyle Molinyawe
 * forwards to shop.jsp
 * Either the user logs in, a session is then created
 * As for the guest view, a link in login.jsp directly goes to shop.jsp
 * 
 */

//to add: redirect to an error page when a logged in user tries to go to the login page.
//Contents of said error page should be: Lines similar to "You have already logged in" and a Button leading to the shop page
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
                                   
            rd.forward(request, response);
        }    
        
        // failed login
        else{ 
            RequestDispatcher rd = request.getRequestDispatcher("failedlogin.jsp");  
            rd.forward(request, response);
        }

    }
    
     protected void processRequestModified(HttpServletRequest request, HttpServletResponse response)
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
            
            // create a session whose name is the username of the customer
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            response.sendRedirect("CartServlet?id="+request.getParameter("id"));
            
        }    
        
        // failed login
        else{ 
            RequestDispatcher rd = request.getRequestDispatcher("failedlogin.jsp");  
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("id");
        if(param!=null && Integer.parseInt(param)>0 && Integer.parseInt(param)<16)
        {
            //modified version of processRequest method that adds the previous item to the cart if the guest has successfully logged in
            processRequestModified(request,response);
        }
        else
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String param = request.getParameter("id");
        if(param!=null && Integer.parseInt(param)>0 && Integer.parseInt(param)<16)
        {
            //modified version of processRequest method that adds the previous item to the cart if the guest has successfully logged in
            processRequestModified(request,response);
        }
        else
            processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
