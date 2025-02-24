<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration Details</title>
<style>
    /* Full screen container for the background image */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        height: 100vh; /* Full height of the viewport */
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        position: relative;
        background-image: url('Images/notelogin.jpg'); /* Background Image */
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
    }

    /* Background overlay for readability */
    body::before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5); /* Dark overlay */
        z-index: -1;
    }

    /* Heading Styling */
    h2 {
        color: white;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        margin-bottom: 10px;
    }

    p {
        color: white;
        font-size: 16px;
    }

    /* Form styling */
    form {
        border: 2px solid rgba(255, 255, 255, 0.3);
        width: 320px;
        padding: 20px;
        background-color: rgba(255, 255, 255, 0.1);
        box-shadow: 0px 6px 12px rgba(0, 0, 0, 0.2);
        border-radius: 10px;
        backdrop-filter: blur(6px);
        text-align: center;
        color: white;
    }

    /* Labels styling */
    label {
        display: block;
        font-size: 12px; /* Smaller labels */
        margin-bottom: 3px;
        text-align: left;
        font-weight: bold;
    }

    /* Input fields styling */
    input[type="text"], input[type="email"], input[type="password"] {
        width: 90%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 12px;
        outline: none;
    }

    input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus {
        border-color: #ffcc00;
        box-shadow: 0px 0px 6px rgba(255, 204, 0, 0.8);
    }

    /* Submit button styling */
    input[type="submit"] {
        background: linear-gradient(90deg, #007bff, #0056b3); /* Blue gradient */
        color: white;
        font-size: 14px;
        font-weight: bold;
        border: none;
        cursor: pointer;
        padding: 10px;
        border-radius: 5px;
        transition: 0.3s ease;
    }

    input[type="submit"]:hover {
        background: linear-gradient(90deg, #0056b3, #007bff);
        box-shadow: 0px 4px 10px rgba(0, 123, 255, 0.5);
    }

    /* Link styling for Login */
    h4 {
        color: white;
        font-size: 12px;
        margin-top: 8px;
    }

    a {
        color: #ffcc00;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <h2>Hello User! Welcome to Note Making App</h2>
    <p>Please Register</p>

    <form action="<%= request.getContextPath() %>/Regform" method="post">
        <label for="Firstname">Firstname:</label>
        <input type="text" name="Firstname" required placeholder="Enter your firstname"><br><br>

        <label for="Lastname">Lastname:</label>
        <input type="text" name="Lastname" required placeholder="Enter your lastname"><br><br>

        <label for="email">Email ID:</label>
        <input type="email" name="email" required placeholder="Enter your Email ID"><br><br>

        <label for="Password">Password:</label>
        <input type="password" name="Password" required placeholder="Enter your password"><br><br>

        <input type="submit" value="Register">
    </form>

    <h4>Already have an account? <a href="cust_login.jsp">Login here</a></h4>
</body>
</html>
