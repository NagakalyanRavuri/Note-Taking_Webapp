<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Notes</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f7f6; text-align: center; padding: 20px; }
        h2 { color: #3b5998; }
        .note-container { background: white; padding: 20px; width: 60%; margin: auto; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        p { text-align: left; }
        a { text-decoration: none; color: white; background-color: #3b5998; padding: 10px 15px; display: inline-block; margin-top: 10px; border-radius: 5px; }
        a:hover { background-color: #2d4373; }
    </style>
</head>
<body>
    <h2>View Notes</h2>
    <div class="note-container">
        <%
            String noteName = request.getParameter("note_name"); 

            if (noteName != null && !noteName.isEmpty()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerDetails", "root", "Nagu@2004");

                    String query = "SELECT note_content FROM notes WHERE note_name = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, noteName);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
        %>
        <h3><%= noteName %></h3>
        <p><%= rs.getString("note_content") %></p>
        <%
                    } else {
                        out.println("<p>No content found for this note.</p>");
                    }
                    con.close();
                } catch (Exception e) {
                    out.println("<p>Error fetching note: " + e.getMessage() + "</p>");
                }
            } else {
                out.println("<p>Invalid note selection.</p>");
            }
        %>
    </div>
    <a href="savednotes.jsp">Back to Notes</a>
</body>
</html>
