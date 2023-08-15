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
@WebServlet(urlPatterns = {"/reservationsList"})
public class reservationsList extends HttpServlet {

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
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet reservationsList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet reservationsList at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        
             
            try{   
          //  String id = request.getParameter("id");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            
          /*  DateTimeFormatter creationdate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
             LocalDateTime currentdate = LocalDateTime.now();  
            String date = (creationdate.format(currentdate)); //insert*/
          
          LocalDate date1 = LocalDate.now();
          String Current = date1.toString();
          
                    
            con = DriverManager.getConnection(url, user, dbPassword);
            
            String view = "Select * from reservation;";
            st = con.prepareStatement(view);
            int reservationID;
            String fromDate,toDate,userUserName,hotelHotelName;
            ResultSet rs = st.executeQuery();  
            
            //rs.beforeFirst();
            while(rs.next()){
                
               reservationID = rs.getInt(1);
               fromDate = rs.getString(2);
               toDate = rs.getString(3);
               userUserName = rs.getString(4);
               hotelHotelName = rs.getString(5);
               
               
               String testDate=rs.getDate(3).toString();
               LocalDate date2 = LocalDate.parse(testDate);
               long daysBetween = ChronoUnit.DAYS.between(date1, date2);
               int i=(int)daysBetween;
        
               if(i>=0){
               
               out.println(reservationID+" "+fromDate+" "+toDate+" "+userUserName+" "+hotelHotelName);
               }else{
                   out.println("");
               }
               
               
               
               
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
