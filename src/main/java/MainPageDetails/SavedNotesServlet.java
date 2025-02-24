package MainPageDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class SavedNotesServlet
 */
@WebServlet("/SavedNotesServlet")
public class SavedNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavedNotesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();
	        String emailId = (String) session.getAttribute("userId");

	    
	        List<String[]> notesList = new ArrayList<>();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerDetails", "root", "Nagu@2004");

	            String query = "SELECT note_name, subject FROM notes WHERE user_id = ?";
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setString(1, emailId);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	String[] note = {rs.getString("note_name"), rs.getString("subject")};
	                notesList.add(note);
	            }
	            con.close();
	        } catch (Exception e) {
	            request.setAttribute("errorMessage", "Error fetching notes: " + e.getMessage());
	        }

	        request.setAttribute("notesList", notesList);
	        request.getRequestDispatcher("savednotes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
