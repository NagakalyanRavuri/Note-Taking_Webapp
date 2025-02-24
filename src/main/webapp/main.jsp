<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <style>
        /* Body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
            position: relative;
        }

        h2, h3 {
            color: #3b5998;
        }

        h2 {
            margin-top: 20px;
        }

        h3 {
            margin-top: 10px;
            font-weight: normal;
        }

        /* Container for forms */
        .form-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 25px;
            border-radius: 8px;
            width: 100%;
            max-width: 400px;
            margin: 20px;
        }

        /* Form paragraph text styling */
        .form-container p {
            font-size: 1.1em;
            color: #666;
            text-align: center;
            margin-bottom: 15px;
        }

        /* Button styling */
        button {
            background-color: #3b5998;
            color: white;
            border: none;
            padding: 12px 25px;
            font-size: 1.1em;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            width: 100%;
            max-width: 300px;
            margin-top: 10px;
        }

        /* Button hover effect */
        button:hover {
            background-color: #2d4373;
        }

        /* Footer styling */
        footer {
            text-align: center;
            padding: 10px;
            width: 100%;
            background-color: #3b5998;
            color: white;
            position: absolute;
            bottom: 0;
        }
    </style>
</head>
<body>
    <div>
        <h2>Hello! ${session_name}</h2>
        <h3>Welcome to the Note-making web application</h3>
        
        <div class="form-container">
            <!-- Create Note Form -->
            <form action="CreateNoteform" method="post">
                <p>Click to create a new note and store important information.</p>
                <button type="submit"> Create Notes</button>
            </form>

            <!-- View Saved Notes Form -->
          <form action="SavedNotesServlet" method="post">
    <p>View all saved notes and access your stored information.</p>
    <button type="submit">Saved Notes</button>
</form>

        </div>
    </div>

    <footer>
        <p>&copy; 2025 Note-making Web App. All rights reserved.</p>
    </footer>
</body>
</html>
