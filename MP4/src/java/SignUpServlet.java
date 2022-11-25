/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.io.FileWriter;

/**
 * Servlet to append sign-up details into a file containing all user's credentials.
 * @author Kyle Molinyawe
 */
public class SignUpServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("User Sign Up: " + email + " " + username + " " + password);

            /*TODO: read csv file and put data into an array get the array length + 1 becomes the id of the next user 
            User user = new User(01, email, username, password);
            createCSVFile();
            writeToCSV(user);
*/
            RequestDispatcher rd=request.getRequestDispatcher("/DummySuccess.jsp");  
            rd.forward(request, response);
        }
    }

    protected void createCSVFile(){
        try {
          File userCredentials = new File("/user-credentials.txt");
          if (userCredentials.createNewFile()) {
            System.out.println("File created: " + userCredentials.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }


    protected void writeToCSV(User user){
        String filePath = "user-credentials.txt";
        try{
            FileWriter writer = new FileWriter(filePath);
            writer.write(user.getId() + "," + user.getEmail() + "," + user.getUsername() + "," + user.getPassword());
            writer.close();
            System.out.println("Succesfully wrote credentials to the file.");
        }catch (IOException e){
            System.out.println("An error has ocurred.");
            e.printStackTrace();

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
