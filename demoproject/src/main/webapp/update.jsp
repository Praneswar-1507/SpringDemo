<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.demoproject.model.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 100%;
        max-width: 400px;
        margin: 100px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
        text-align: center;
    }
    .input-group {
        margin-bottom: 20px;
    }
    .input-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .input-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    .btn {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        color: #fff;
        cursor: pointer;
    }
    .btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
<div class="container">
    <h2>Update Details</h2>
    <% 
    UserDetails view=(UserDetails)request.getAttribute("update");
    %>
    <form action="/update" method="post">
        <div class="input-group">
            <label for="username">UserName:</label>
            <input type="text" id="username" name="username" value="<%=view.getUsername()%>" required>
        </div>
        <div class="input-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%=view.getEmail() %>" required>
        </div>
        <div class="input-group">
            <label for="phone">Password:</label>
            <input type="tel" id="phone" name="password" value="<%=view.getPassword() %>" required>
        </div>
         <input type="hidden" name="action" value="update">
        <input type="hidden" name="updateid" value="<%=view.getUserId() %>">
        <button type="submit" class="btn">Update</button> 
    </form>
</div>

</body>
</html>