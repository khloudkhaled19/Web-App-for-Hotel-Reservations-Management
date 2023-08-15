/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
//import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.*;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Khloud
 */
@WebServlet(urlPatterns = {"/reservationsHistory"})
public class reservationsHistory extends HttpServlet {

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
            try{
            /* TODO output your page here. You may use following sample code. */
         /*   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reservationsHistory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reservationsHistory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
         
          String from = request.getParameter("from");
          String to = request.getParameter("to");
          
          
          /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date startDate = formatter.parse(fromDate);
          java.util.Date endDate = formatter.parse(toDate);*/

          
          
          out.println("good1");
          

          
          Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
            
            
            
            
            String select = "SELECT * FROM reservation WHERE fromDate BETWEEN ? AND ?;";
          //  String select = "SELECT * FROM reservation WHERE 'fromDate'=?;";
             out.println("good2");  
            st = con.prepareStatement(select);
            st.setString(1, from);
            st.setString(2, to);
           
         //  st.setDate(1, new java.sql.Date(startDate.getTime()));
          // st.setDate(2, new java.sql.Date(endDate.getTime()));
 
          
            ResultSet rs = st.executeQuery();
            out.println("good3");
           int reservationID;
           String fDate,tDate,userUserName,hotelHotelName;
           //rs.beforeFirst();
           rs.beforeFirst();
           while(rs.next()){
           out.println("in");
           reservationID = rs.getInt(1);
           fDate = rs.getString(2);
           tDate = rs.getString(3);
           userUserName = rs.getString(4);
           hotelHotelName = rs.getString(5);
           out.println("good4");
           out.println(reservationID+" "+fDate+" "+tDate+" "+userUserName+" "+hotelHotelName);
           
           }
          
         
         
         
         
         
        }catch(Exception e){
            out.println("Something went wrong");
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
