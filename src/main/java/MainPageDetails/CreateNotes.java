package MainPageDetails;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class CreateNotes
 */
@WebServlet("/CreateNotesform")
public class CreateNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNotes() {
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
        String notename = request.getParameter("noteName");
        String notesubject = request.getParameter("noteSubject");
        String notecontent = request.getParameter("noteContent");
        
        // Get userId from the session
        String userId = (String) request.getSession().getAttribute("userId");
        
        PrintWriter out = response.getWriter();
        
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/CustomerDetails";
        String user_db = "root";
        String pass_db = "Nagu@2004";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection to the Database
            Connection con = DriverManager.getConnection(url, user_db, pass_db);

            // Modify the query to include the userId
            String query = "INSERT INTO notes(note_name, subject, note_content, user_id) values (?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, notename);
            pre.setString(2, notesubject);
            pre.setString(3, notecontent);
            pre.setString(4, userId);  // Set the userId here
            String checkQuery = "SELECT COUNT(*) FROM notes WHERE note_name = ?";
            PreparedStatement checkStmt = con.prepareStatement(checkQuery);
            checkStmt.setString(1, notename);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            
            if (rs.getInt(1) > 0) {
            	  response.setContentType("text/html");
                  out.println("<h2 style = 'color:red;'>Note name already exist</h2>");
                
                  RequestDispatcher rd = request.getRequestDispatcher("/createnotes.jsp");
                  rd.include(request, response);
            }

            int count = pre.executeUpdate();

            if (count > 0) {
            	HttpSession session  = request.getSession();
                session.setAttribute("note_name", notename);

                response.setContentType("text/html");
                out.println("<h2 style = 'color:green;'>Saved notes Successfully</h2>");
              
                RequestDispatcher rd = request.getRequestDispatcher("/createnotes.jsp");
                rd.include(request, response);
            } else {
            	 response.setContentType("text/html");
                out.println("<h2 style:'color:red;'>Error saving note. Please try again.</h2>");
                
                RequestDispatcher rd = request.getRequestDispatcher("/createnotes.jsp");
                rd.include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }

	}

