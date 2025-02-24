package RegisterandLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Regform")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirecting to login page if accessed via GET
        response.sendRedirect("cust_login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // Capturing the Registration Details from Frontend
//        String firstname = request.getParameter("Firstname");
//        String lastname = request.getParameter("Lastname");
//        String email = request.getParameter("email");
//        String password = request.getParameter("Password");
        
        RegisterEncapsulation RE = new RegisterEncapsulation(
        		request.getParameter("Firstname"),
        		request.getParameter("Lastname"),
        		request.getParameter("email"),
        		request.getParameter("Password")
        		);

        // Database Details
        String url = "jdbc:mysql://localhost:3306/CustomerDetails";
        String user_db = "root";
        String pass_db = "Nagu@2004";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user_db, pass_db);

            // Check if email already exists
            PreparedStatement preCheck = con.prepareStatement("SELECT * FROM cus_reg WHERE email_id = ?");
            preCheck.setString(1, RE.getEmail());
            ResultSet rsCheck = preCheck.executeQuery();

            if (rsCheck.next()) {
                // If email exists, display a message and redirect to the registration page
                response.setContentType("text/html");
                out.println("<h2 style='color:red;'>Email already exists! Please try a different email.</h2>");
                RequestDispatcher req = request.getRequestDispatcher("/custreg.jsp");
                req.include(request, response);
            } else {
                // If email doesn't exist, proceed with registration
                PreparedStatement pre = con.prepareStatement("INSERT INTO cus_reg (first_name, last_name, email_id, password) VALUES (?, ?, ?, ?)");
                pre.setString(1, RE.getFirstname());
                pre.setString(2, RE.getLastname());
                pre.setString(3, RE.getEmail());
                pre.setString(4, RE.getPassword());

                int count = pre.executeUpdate();

                if (count > 0) {
                    response.setContentType("text/html");
                    out.println("<h2 style='color:green;'>Registration Successful! Redirecting to login page...</h2>");
                    response.setHeader("Refresh", "2");
                    RequestDispatcher req = request.getRequestDispatcher("/cust_login.jsp");
                    req.include(request, response);
                } else {
                    response.setContentType("text/html");
                    out.println("<h2 style='color:red;'>Registration Unsuccessful! Please try again.</h2>");
                    RequestDispatcher req = request.getRequestDispatcher("/custreg.jsp");
                    req.include(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            out.println("<h2 style='color:red;'>Error: " + e.getMessage() + "</h2>");
        }
    }
}
