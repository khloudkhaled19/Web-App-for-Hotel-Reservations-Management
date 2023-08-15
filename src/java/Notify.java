/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.*; 
import java.util.stream.Collectors; 


/**
 *
 * @author Khloud
 */
@WebServlet(urlPatterns = {"/Notify"})
public class Notify extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hotels";
                String user = "root";
                String password = "abc-123";
                Connection Con = null;
                Statement Stmt = null;

                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                String UserName=request.getParameter("username");
                String email;

               // Query to insert all customer data in database 
               String select ="select * from user where UserName=?;";    
                PreparedStatement pstmt=Con.prepareStatement(select);  
                pstmt.setString(1, UserName);
               
                
//                int x= pstmt.executeUpdate();
                ResultSet rs = pstmt.executeQuery() ;
                while(rs.next()){
                    if(UserName.equals(rs.getString(1))){
                        
                    email = rs.getString(4);
                    String subject = "Reservation Updates";
                    Stmt.close();
                Con.close();
                 SendNotification.notify(email, subject,"Your Reservation is Cancelled" ,"bookinghotelscom2@gmail.com", "Hotels12345678");
                 out.println("Sent!");
                
                    
                    
                }else{
                        out.println("username is not found");
                    }
                    
                }
                      
                      
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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
