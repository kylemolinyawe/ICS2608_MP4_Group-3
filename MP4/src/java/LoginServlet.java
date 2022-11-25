

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

/**
 * Login controller servlet which validates the user's credentials when trying to login.
* 
 * @author Kyle Molinyawe
 */
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    List<User> users = readCSV(this.getServletContext());
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if(validateUsername(users, username) && validatePassword(users, password)){ // successful login
            RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
            rd.forward(request, response);
    }else{ // failed login
    RequestDispatcher rd = request.getRequestDispatcher("failed.jsp");  
            rd.forward(request, response);
    }

       
    }

//Reads the usercredentials.txt and stores the values in a list of user objects
    protected List<User> readCSV(ServletContext servletContext){
 
        List<User> list = new ArrayList<>();
        try   {  

        InputStream ins = servletContext.getResourceAsStream("/users.txt");
 InputStreamReader isr = new InputStreamReader(ins);
                BufferedReader reader = new BufferedReader(isr);
                int n = 0;
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] byComma = line.split(",");
list.add(new User(Integer.parseInt(byComma[0]), byComma[1], byComma[2], byComma[3]));
                }
/*
        Scanner s = new Scanner(inputStream).useDelimiter("\n");
        while(s.hasNext()){
            String result = s.next();
            String[] byComma = result.split(",");
            list.add(new User(Integer.parseInt(byComma[0]), byComma[1], byComma[2], byComma[3]));
        }

inputStream.close();
*/
        }catch (IOException e){  
            e.printStackTrace();  
        }

        return list;
    }

// iterates through a list and returns a boolean value if a match is found between the response and list
protected boolean validateUsername(List<User> users, String requestUsername){
    ListIterator<User> usersIterator = users.listIterator();
    while(usersIterator.hasNext()){
        if (usersIterator.next().getUsername().equals(requestUsername)){
            return true;
        } 
    }
    return false;
}

protected boolean validatePassword(List<User> users, String requestPassword){
    ListIterator<User> usersIterator = users.listIterator();
    while(usersIterator.hasNext()){
        if (usersIterator.next().getPassword().equals(requestPassword)){
            return true;
        } 
    }
    return false;
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
