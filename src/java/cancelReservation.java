/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Date;
import java.time.LocalDate;
import javax.servlet.*;  
import javax.servlet.http.*; 

/**
 *
 * @author Khloud
 */
@WebServlet(urlPatterns = {"/cancelReservation"})
public class cancelReservation extends HttpServlet {

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
          /*  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet cancelReservation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet cancelReservation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
          
           try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hotels";
                String user = "root";
                String password = "abc-123";
                Connection Con = null;
                Statement Stmt = null;
                PreparedStatement preparedStatement = null;
                PreparedStatement preparedStatement1 = null;
                int RoomsID=Integer.parseInt(request.getParameter("RoomsID"));
               // ResultSet rs = null;
                int ReservationID=Integer.parseInt(request.getParameter("reservationID"));
                //LocalDate date = LocalDate.now();
                //String CurrentDate = date.toString() ;
                String FromDate= request.getParameter("FromDate").toString();
                Con = DriverManager.getConnection(url, user, password);
                
                preparedStatement = Con.prepareStatement("DELETE FROM reservation WHERE reservationID= ?");
                preparedStatement.setInt(1,ReservationID);
                preparedStatement.executeUpdate();
                
                preparedStatement1 = Con.prepareStatement("UPDATE rooms SET availabilityDate = ? WHERE RoomsID = ?");
                preparedStatement1.setString(1,FromDate);
                preparedStatement1.setInt(2,RoomsID);
                preparedStatement1.executeUpdate();
                Con.close();
                
                out.println("Reservation is cancelled");
                
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
