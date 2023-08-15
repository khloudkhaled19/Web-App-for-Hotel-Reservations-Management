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
@WebServlet(urlPatterns = {"/getRoomID"})
public class getRoomID extends HttpServlet {

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
            out.println("<title>Servlet getRoomID</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getRoomID at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            HttpSession session = request.getSession(true);
           // int originalID = Integer.parseInt(request.getParameter("originalID"));
            int originalID = (Integer) session.getAttribute("originalID");
                                   
            session.setAttribute("originalID", originalID);
            try{
              Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotels";
            String user = "root";
            String dbPassword = "abc-123";
            Connection con = null;
            PreparedStatement st = null;
            con = DriverManager.getConnection(url, user, dbPassword);
         
            String validate = "Select * from rooms";
            st = con.prepareStatement(validate);
            ResultSet rs = st.executeQuery();
            //boolean found=false;
            while(rs.next()){
              if(originalID==rs.getInt(1)){
                 
              RequestDispatcher rd = request.getRequestDispatcher("updateRoom.jsp");
            rd.forward(request, response);

              
              }else{
                  out.println("id is not found");
                  RequestDispatcher rd = request.getRequestDispatcher("getRoomID.jsp");
                  rd.include(request, response);  
                    
              }
            }
            
            
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
