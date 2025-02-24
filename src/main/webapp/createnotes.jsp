<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Notes</title>
<style type="text/css">
    /* Body styling */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        background-color: #f4f7f6;
    }

    /* Main form container */
    form {
        background-color: white;
        padding: 30px;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 100%;
        max-width: 600px;
        box-sizing: border-box;
    }

    /* Form labels */
    label {
        font-size: 16px;
        color: #333;
        margin-bottom: 5px;
        display: block;
    }

    /* Input fields */
    input[type="text"], textarea {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 20px;
        box-sizing: border-box;
    }

    /* Textarea */
    textarea {
        height: 250px;
        resize: none;
    }

    /* Button styling */
    button {
        background-color: #3b5998;
        color: white;
        border: none;
        padding: 12px 20px;
        font-size: 18px;
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

    /* Back button styling */
    .back-btn {
        background-color: #777;
        display: inline-block;
        padding: 12px 20px;
        text-align: center;
        color: white;
        border-radius: 5px;
        width: 100%;
        max-width: 300px;
        margin-top: 10px;
        text-decoration: none;
    }

    .back-btn:hover {
        background-color: #555;
    }

</style>
</head>
<body>

    <form action="CreateNotesform" method="post">
        <label for="noteName">Notes Name:</label>
        <input type="text" id="noteName" name="noteName" placeholder="Enter notes name" required><br>

        <label for="noteSubject">Notes Subject:</label>
        <input type="text" id="noteSubject" name="noteSubject" placeholder="Enter notes subject"><br>

        <label for="noteContent">Write Your Notes:</label>
        <textarea id="noteContent" name="noteContent" placeholder="Write your notes here..." required></textarea><br>

        <button type="submit">💾 Save Notes</button>

        <!-- Back to Main Page using anchor -->
        <a href="main.jsp" class="back-btn">⬅ Back to Main Page</a>
    </form>

</body>
</html>
