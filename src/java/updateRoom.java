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
import javax.servlet.*;

/**
 *
 * @author Khloud
 */
@WebServlet(urlPatterns = {"/updateRoom"})
public class updateRoom extends HttpServlet {

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
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateRoom</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateRoom at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
           
           try{
          //  int originalID = Integer.parseInt(request.getParameter("originalID"));
            //HttpSession session = request.getSession(true);
                        
           //session.setAttribute("originalID", originalID);
           
          int originalID = ((Integer)request.getSession().getAttribute("originalID")).intValue();
      
         //int originalID = ((Integer)Session.getAttribute("originalID")).intValue();
         //int originalID = Integer.parseInt((String)request.getSession().getAttribute("originalID"));
          //int roomID = Integer.parseInt(request.getParameter("roomID"));
          String type = request.getParameter("type");
          String facilities = request.getParameter("fac");
          String price = request.getParameter("price");
          String availabilityDate = request.getParameter("date");
          String hotel = request.getParameter("hotel");
          
          out.println("1");
          
          //int counter = Integer.parseInt(request.getParameter("counter"));
          
          Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
          out.println("2");  
         /*   String add = "INSERT INTO `rooms`(`RoomsID`, `RoomType`, `RoomFacilities`, `RoomPrice`, `availabilityDate`, `Hotel_HotelName`) VALUES ("
                         + "'" + roomID + "', "
                         + "'" + type + "', "
                         + "'" + facilities + "', "
                         + "'" + price + "',"
                         + "'" + availabilityDate + "', "
                         + "'" + hotel + "')";*/
         
            String update = "UPDATE `rooms` SET `RoomType`=?,`RoomFacilities`=?,`RoomPrice`=?,`availabilityDate`=?,`Hotel_HotelName`=? WHERE `RoomsID`=?";
          st = con.prepareStatement(update);
         // st.setInt(1, roomID);
          st.setString(1, type);
          st.setString(2, facilities);
          st.setString(3, price);
          st.setString(4, availabilityDate);
          st.setString(5, hotel);
          st.setInt(6, originalID);
          out.println("3");
          int row = st.executeUpdate();
          out.println("4");
          //ResultSet rs = st.executeQuery();
        }catch(Exception e){out.println("something went wrong");}  
         
        
           
           
           
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
