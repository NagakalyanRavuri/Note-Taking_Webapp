package RegisterandLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

/**
 * Servlet implementation class LoginDemo
 */
@WebServlet("/Loginform")
public class LoginDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Capturing Login Details from Frontend.
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		//Database connection Details.
		String url = "jdbc:mysql://localhost:3306/CustomerDetails";
		String user_db = "root";
		String pass_db = "Nagu@2004";

	   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection to the Database.
			Connection con = DriverManager.getConnection(url,user_db,pass_db);
			PreparedStatement pre = con.prepareStatement("SELECT * FROM cus_reg where email_id = ? and password = ?");
			pre.setString(1,email);
			pre.setString(2, password);
			//Saving result in ResultSet.
			ResultSet rs = pre.executeQuery(); 
			
			if (rs.next()) {
			    HttpSession session = request.getSession();
			    // Set session attribute for user.
			    session.setAttribute("session_name", rs.getString("first_name"));
			    
                session.setAttribute("userId", email);
			    response.setContentType("text/html");
			    
			    // Display login success message
			    out.println("<h2 style='color:green;'>Login Successful</h2>");
			    
			    // Include main.jsp content without redirecting
			    RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			    rd.include(request, response);
			} else {
			    // Invalid login
			    response.setContentType("text/html");
			    
			    // Display invalid login message
			    out.println("<h2 style='color:red;'>Invalid Login Credentials!</h2>");
			    
			    // Include the login page content with the message
			    RequestDispatcher req = request.getRequestDispatcher("/cust_login.jsp");
			    req.include(request, response);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			//e.getMessage() method is used print the exception.
			out.print("<h2 style = 'color:red;'>"+e.getMessage()+"</h2>");
			RequestDispatcher rd = request.getRequestDispatcher("/cust_login.jsp");
			rd.include(request, response);
		}
	}

}
