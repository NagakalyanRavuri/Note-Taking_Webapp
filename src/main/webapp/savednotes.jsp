<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saved Notes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            text-align: center;
            padding: 20px;
        }
        h2 {
            color: #3b5998;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #3b5998;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: white;
            background-color: #3b5998;
            padding: 10px 15px;
            display: inline-block;
            margin-top: 10px;
            border-radius: 5px;
        }
        a:hover {
            background-color: #2d4373;
        }
    </style>
</head>
<body>
    <h2>Saved Notes</h2>
<table>
    <tr>
        <th>Note Name</th>
        <th>Subject</th>
        <th>Action</th>
    </tr>
    <%
        String emailId = (String) session.getAttribute("userId"); // Get user ID from session

        if (emailId == null || emailId.isEmpty()) {
            out.println("<tr><td colspan='3'>User not logged in. Please <a href='cust_login.jsp'>Login</a></td></tr>");
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerDetails", "root", "Nagu@2004");

                String query = "SELECT note_name, subject FROM notes WHERE user_id = ?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, emailId);
                ResultSet rs = pst.executeQuery();

                boolean hasNotes = false; // Track if notes exist

                while (rs.next()) {
                    hasNotes = true;
    %>
    <tr>
        <td><%= rs.getString("note_name") %></td>
        <td><%= rs.getString("subject") %></td>
        <td>
            <a href="viewnotes.jsp?note_name=<%= java.net.URLEncoder.encode(rs.getString("note_name"), "UTF-8") %>">View Notes</a>
        </td>
    </tr>
    <%
                }
                if (!hasNotes) {
                    out.println("<tr><td colspan='3'>No saved notes found.</td></tr>");
                }
                con.close();
            } catch (Exception e) {
                out.println("<tr><td colspan='3'>Error fetching notes: " + e.getMessage() + "</td></tr>");
            }
        }
    %>
</table>


    <a href="main.jsp">Back to Home</a>
</body>
</html>
