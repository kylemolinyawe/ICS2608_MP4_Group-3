/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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

/**
 * 
 * @author Kyle Molinyawe
 */

public class ShopServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
             
    }
    
    protected List<Product> readProductsFile(ServletContext servletContext){
 
        List<Product> list = new ArrayList<Product>();
        try{  
            InputStream ins = servletContext.getResourceAsStream("/files/products.csv");
            InputStreamReader isr = new InputStreamReader(ins);
            BufferedReader reader = new BufferedReader(isr);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] byComma = line.split(",");
                list.add(new Product(Integer.parseInt(byComma[0]), 
                                     byComma[1], 
                                     Double.parseDouble(byComma[2]), 
                                     byComma[3], 
                                     byComma[4], 
                                     byComma[5]));
            }
        }catch (IOException e){  
            e.printStackTrace();  
        }
        
        return list;
    }
    
    // given a string representing a category adds products from an input list 
    // into a new list whose with each element's category corresponding
    // with the input and outputs this a list of those products
    protected List<Product> sortByCategory(String category, List<Product> products){
        List<Product> list = new ArrayList<Product>();
            
            for(int i = 0; i < products.size(); i++){
                if(products.get(i).getCategory().matches(category)){
                    list.add(products.get(i));
                }else{
                    // do nothing
                }
            }
            
        return list;
    }

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
        response.setContentType("text/html;charset=UTF-8");
        
        String category = request.getParameter("category");
               
        List<Product> products = readProductsFile(this.getServletContext());
        
        if(category.matches("All")){
            request.setAttribute("products", products);
            RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
            rd.forward(request, response);
            return;
        }
  
        List<Product> sortedProducts = sortByCategory(category, products);
        
        request.setAttribute("products", sortedProducts);
        
        RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
        rd.forward(request, response);
        
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) // working fine
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Product> products = readProductsFile(this.getServletContext());
        
        // bind collection to request
        request.setAttribute("products", products);
            
        RequestDispatcher rd = request.getRequestDispatcher("shop.jsp");  
        rd.forward(request, response);
        
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
