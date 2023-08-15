/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/ValidateEmail"})
public class ValidateEmail extends HttpServlet {

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
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hotels";
                String user = "root";
                String password = "abc-123";
                Connection Con = null;
                Statement Stmt = null;

                Con = DriverManager.getConnection(url, user, password);
                Stmt = Con.createStatement();
                String email = request.getParameter("email");
                String acc_Password = request.getParameter("password");

               // Query to select all customer records in database to validate 
                String line = ("select * from user where email ='"
                        + email
                        + " ' AND password='" 
                        + acc_Password
                        + "'");
                ResultSet RS= Stmt.executeQuery(line);
                boolean Rows = RS.next();

                if(Rows==true){//if entered email and password exist in user table
                    
                    HttpSession session = request.getSession(true); //to create session object
                    String Name=RS.getString("FirstName");
                    session.setAttribute("session_ID",Name); //will make the key available in all pages.
                    request.getSession().setAttribute(user, url);
                    request.getSession().setAttribute("session_ID",Name);
                    RequestDispatcher rd=request.getRequestDispatcher("home.jsp"); 
                    rd.forward(request, response);
                }
                else{ //redirect back to login.HTML. with error message
                    
                     request.setAttribute("error", "your data is invalid");
                     out.print("<h2> Error in Account ID or Password </h2>\n"); 
                     RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");  
                     rd.include(request, response);
                }
                
               
                Stmt.close();
                Con.close();
    
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
