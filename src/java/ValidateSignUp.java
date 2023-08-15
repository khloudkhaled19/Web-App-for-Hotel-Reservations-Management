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
 * @author Nada Abdelrahman
 */
@WebServlet(urlPatterns = {"/ValidateSignUp"})
public class ValidateSignUp extends HttpServlet {

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
                String FirstName = request.getParameter("FName");
                String SecondName = request.getParameter("SName");
                String PhoneNumber = request.getParameter("phone");
                String UserName=request.getParameter("userName");
                String email = request.getParameter("email");

               // Query to insert all customer data in database 
               String query1 ="Insert into user(UserName,FirstName,SecondName,email,password,PhoneNumber) values (?,?,?,?,?,?);";    
                PreparedStatement pstmt=Con.prepareStatement(query1);  

                String RandomPassword ;
                RandomPassword = generateCommonLangPassword();
                pstmt.setString(1, UserName);    
                pstmt.setString(2, FirstName);    
                pstmt.setString(3, SecondName);   
                pstmt.setString(4,email);
                pstmt.setString(5,RandomPassword);    
                pstmt.setString(6,PhoneNumber);   
                int x= pstmt.executeUpdate();  

                      RequestDispatcher rd=request.getRequestDispatcher("home1.jsp"); 
                      rd.forward(request, response);
                      String subject = "Welcome, "+ FirstName+" to roomsBucket ";
                      
                Stmt.close();
                Con.close();
                 SendMail.send(email, FirstName, subject, RandomPassword,"bookinghotelscom2@gmail.com", "Hotels12345678");
                 response.sendRedirect("index.html");
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
  public String generateCommonLangPassword() {
    String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
    String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
    String numbers = RandomStringUtils.randomNumeric(2);
    String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
    String totalChars = RandomStringUtils.randomAlphanumeric(2);
    String combinedChars = upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChar).concat(totalChars);
    List<Character> pwdChars = combinedChars.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    Collections.shuffle(pwdChars);
    String password = pwdChars.stream()
      .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
      .toString();
    return password;
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
